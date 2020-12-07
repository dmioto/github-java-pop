package com.dmioto.githubjavapop.ui.core.di

import com.dmioto.githubjavapop.domain.products.popularjavarepositories.interactor.GetPopularJavaRepositories
import com.dmioto.githubjavapop.domain.products.repositorypullrequest.interactor.GetPullRequestsFromRepository
import org.koin.dsl.module

object DomainModule {

    fun get() = module {

        single {
            GetPopularJavaRepositories(
                get()
            )
        }

        single {
            GetPullRequestsFromRepository(
                get()
            )
        }

    }

}