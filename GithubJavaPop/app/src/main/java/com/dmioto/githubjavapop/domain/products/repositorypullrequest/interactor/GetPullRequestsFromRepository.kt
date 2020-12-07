package com.dmioto.githubjavapop.domain.products.repositorypullrequest.interactor

import com.dmioto.githubjavapop.data.products.repositorypullrequest.entity.PullRequests
import com.dmioto.githubjavapop.domain.core.Interactor
import com.dmioto.githubjavapop.domain.products.repositorypullrequest.GithubPullRequestRepository
import io.reactivex.rxjava3.core.Single

class GetPullRequestsFromRepository(private val repository: GithubPullRequestRepository) :
    Interactor<Single<ArrayList<PullRequests>>> {

    private var owner: String = ""
    private var repo: String = " "

    fun with(owner: String, repo: String) : GetPullRequestsFromRepository {
        this.owner = owner
        this.repo = repo
        return this
    }

    override fun execute(): Single<ArrayList<PullRequests>> {
        return repository.getRepositoryPullRequest(owner, repo)

    }
}