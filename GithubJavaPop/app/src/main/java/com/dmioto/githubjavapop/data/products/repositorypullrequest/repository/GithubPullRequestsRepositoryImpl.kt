package com.dmioto.githubjavapop.data.products.repositorypullrequest.repository

import com.dmioto.githubjavapop.data.core.BaseRepositoryImpl
import com.dmioto.githubjavapop.data.products.repositorypullrequest.entity.PullRequests
import com.dmioto.githubjavapop.data.products.repositorypullrequest.remote.GithubRepositoryPullRequestFactory
import com.dmioto.githubjavapop.domain.products.repositorypullrequest.GithubPullRequestRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers


class GithubPullRequestsRepositoryImpl() : GithubPullRequestRepository, BaseRepositoryImpl() {

    override fun getRepositoryPullRequest(
        owner: String?,
        repo: String?
    ): Single<ArrayList<PullRequests>> {
        return GithubRepositoryPullRequestFactory
            .instance()
            .getGithubPullRequestService()!!
            .getPullRequestsFromRepository(owner!!, repo!!)
            .doOnError {
                onRequestError()
            }
            .doOnSuccess {
                onRequestSuccess()
            }
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap {
                Single.just(it)
            }

    }
}