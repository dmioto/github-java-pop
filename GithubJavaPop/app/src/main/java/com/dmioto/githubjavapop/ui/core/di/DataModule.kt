package com.dmioto.githubjavapop.ui.core.di

import com.dmioto.githubjavapop.domain.products.popularjavarepositories.GithubRepositoriesRepository
import com.dmioto.githubjavapop.data.products.popularjavarepositories.repository.GithubRepositoriesRepositoryImpl
import com.dmioto.githubjavapop.data.products.repositorypullrequest.repository.GithubPullRequestsRepositoryImpl
import com.dmioto.githubjavapop.domain.products.repositorypullrequest.GithubPullRequestRepository
import org.koin.dsl.module

object DataModule {

    fun get() = module {
        single<GithubRepositoriesRepository> { GithubRepositoriesRepositoryImpl() }
        single<GithubPullRequestRepository> { GithubPullRequestsRepositoryImpl() }
    }

}