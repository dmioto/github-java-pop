package com.dmioto.githubjavapop.ui.products.popularjavarepositories

import com.dmioto.githubjavapop.data.products.popularjavarepositories.entity.Repository
import com.dmioto.githubjavapop.domain.products.popularjavarepositories.interactor.GetPopularJavaRepositories
import com.dmioto.githubjavapop.ui.products.Navigator
import com.dmioto.githubjavapop.ui.core.base.BasePresenter

internal class PopularJavaRepositoriesPresenter(
    private val navigator: Navigator,
    private val getPopularJavaRepositories: GetPopularJavaRepositories
) : BasePresenter<PopularJavaRepositoriesView>() {

    private lateinit var repositories: ArrayList<Repository>
    var page: Int = 1

    fun getJavaRepos() {
        view?.showLoading()
        disposable = getPopularJavaRepositories
            .with(page)
            .execute()
            .subscribe({
                view?.getRepositories(it.items!!)
                repositories = it.items!!
                view?.hideLoading()
            }, {
                view?.hideLoading()
                view?.showGenericError()
            })
    }

    fun navigateRepositoryPullRequest(position: Int) {
        navigator.navigateRepositoryPullRequests(repositories[position].owner!!.login!!, repositories[position].name!!)
    }

}