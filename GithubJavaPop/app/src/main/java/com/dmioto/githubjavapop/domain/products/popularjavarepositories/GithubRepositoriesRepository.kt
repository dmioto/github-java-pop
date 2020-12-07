package com.dmioto.githubjavapop.domain.products.popularjavarepositories

import com.dmioto.githubjavapop.domain.products.popularjavarepositories.model.GithubRepositoriesDomain
import io.reactivex.rxjava3.core.Single

interface GithubRepositoriesRepository {

    // Github repositories
    fun getPopularJavaRepositories(page: Int?) : Single<GithubRepositoriesDomain>

}