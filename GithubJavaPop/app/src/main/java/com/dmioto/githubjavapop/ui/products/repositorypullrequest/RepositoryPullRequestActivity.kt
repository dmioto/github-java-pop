package com.dmioto.githubjavapop.ui.products.repositorypullrequest

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dmioto.githubjavapop.R
import com.dmioto.githubjavapop.data.products.repositorypullrequest.entity.PullRequests
import com.dmioto.githubjavapop.ui.core.base.BackButtonType
import com.dmioto.githubjavapop.ui.core.base.BaseActivity
import com.dmioto.githubjavapop.ui.products.repositorypullrequest.list.PullRequestAdapter
import kotlinx.android.synthetic.main.activity_repository_pull_request.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

internal class RepositoryPullRequestActivity : BaseActivity(), RepositoryPullRequestView {

    private val presenter: RepositoryPullRequestPresenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_pull_request)

        val owner = intent.getStringExtra(PullRequests.PULL_REQUEST_OWNER)!!
        val repo = intent.getStringExtra(PullRequests.PULL_REQUEST_REPO)!!

        setupToolbar(repo, true, BackButtonType.LEFT_BLUE)

        presenter.attachView(this)

        presenter.getPullRequestsFromRepository(owner, repo)

        repository_pull_request_recyclerview.let {
            it.layoutManager = LinearLayoutManager(this)
        }
    }

    override fun getPullRequests(pullRequests: ArrayList<PullRequests>) = runOnUiThread {
        repository_pull_request_recyclerview.adapter = PullRequestAdapter(pullRequests)
    }

    override fun showLoading() {
        showDefaultLoading()
    }

    override fun hideLoading() {
        hideDefaultLoading()
    }

}