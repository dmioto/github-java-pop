package com.dmioto.githubjavapop.ui.products.repositorypullrequest

import com.dmioto.githubjavapop.domain.products.repositorypullrequest.interactor.GetPullRequestsFromRepository
import com.dmioto.githubjavapop.ui.products.Navigator
import com.dmioto.githubjavapop.ui.core.base.BasePresenter

internal class RepositoryPullRequestPresenter(
    private val navigator: Navigator,
    private val getPullRequestsFromRepository: GetPullRequestsFromRepository
) : BasePresenter<RepositoryPullRequestView>() {

    fun getPullRequestsFromRepository(repo: String, owner: String) {
        view?.showLoading()
        disposable = getPullRequestsFromRepository
            .with(repo, owner)
            .execute()
            .subscribe({
                view?.getPullRequests(it)
                view?.hideLoading()
            }, {
                view?.hideLoading()
                // TODO show error
            })
    }
}