package com.dmioto.githubjavapop.domain.products.repositorypullrequest

import com.dmioto.githubjavapop.data.products.repositorypullrequest.entity.PullRequests
import io.reactivex.rxjava3.core.Single

interface GithubPullRequestRepository {

    // Repo Pull-Requests
    fun getRepositoryPullRequest(owner: String?, repo: String?) : Single<ArrayList<PullRequests>>
}