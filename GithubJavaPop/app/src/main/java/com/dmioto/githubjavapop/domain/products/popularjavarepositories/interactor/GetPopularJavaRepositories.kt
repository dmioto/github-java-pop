package com.dmioto.githubjavapop.domain.products.popularjavarepositories.interactor

import com.dmioto.githubjavapop.domain.core.Interactor
import com.dmioto.githubjavapop.domain.products.popularjavarepositories.model.GithubRepositoriesDomain
import com.dmioto.githubjavapop.domain.products.popularjavarepositories.GithubRepositoriesRepository
import io.reactivex.rxjava3.core.Single

class GetPopularJavaRepositories(private val repository: GithubRepositoriesRepository) :
    Interactor<Single<GithubRepositoriesDomain>> {

    private var page: Int = 1

    fun with(page: Int) : GetPopularJavaRepositories {
        this.page = page
        return this
    }

    override fun execute(): Single<GithubRepositoriesDomain> {
        return repository.getPopularJavaRepositories(page)
    }
}