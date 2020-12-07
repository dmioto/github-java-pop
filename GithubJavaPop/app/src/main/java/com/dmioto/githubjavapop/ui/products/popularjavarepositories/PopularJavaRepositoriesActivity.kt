package com.dmioto.githubjavapop.ui.products.popularjavarepositories

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dmioto.githubjavapop.R
import com.dmioto.githubjavapop.data.products.popularjavarepositories.entity.Repository
import com.dmioto.githubjavapop.ui.core.base.BaseActivity
import com.dmioto.githubjavapop.ui.custom.AppAlert
import com.dmioto.githubjavapop.ui.products.popularjavarepositories.list.RepositoriesAdapter
import kotlinx.android.synthetic.main.activity_popular_java_repositories.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


internal class PopularJavaRepositoriesActivity : BaseActivity(), PopularJavaRepositoriesView {

    private val presenter: PopularJavaRepositoriesPresenter by inject { parametersOf(this) }
    private val layoutManager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popular_java_repositories)
        setupToolbar(getString(R.string.app_name))
        presenter.attachView(this)
        presenter.getJavaRepos()
        java_repositories_recyclerview.layoutManager = layoutManager

    }

    override fun getRepositories(repositories: ArrayList<Repository>) = runOnUiThread {
        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val pastVisibleItems = layoutManager.findFirstVisibleItemPosition()
        val adapter = RepositoriesAdapter(repositories)
        java_repositories_recyclerview.let {
            /* Set recycler view adapter */
            adapter.let { adapter ->
                it.adapter = adapter
                /* Set item click listener action */
                adapter.setOnItemClickListener(object : RepositoriesAdapter.ItemClickListener {
                    override fun onItemClick(position: Int) {
                        presenter.navigateRepositoryPullRequest(position)
                    }
                })
            }
            /* Pagination */
            it.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    if (dy > 0) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            presenter.page++
                            presenter.getJavaRepos()
                        }
                    }
                }
            })
        }
    }

    override fun showGenericError() = runOnUiThread {
        AppAlert.topAlert(
            this,
            AppAlert.TopAlertType.ERROR,
            getString(R.string.error_popular_java_repositories)
        )
    }

    override fun showLoading() = runOnUiThread {
        showDefaultLoading()
    }

    override fun hideLoading() = runOnUiThread {
        hideDefaultLoading()
    }
}