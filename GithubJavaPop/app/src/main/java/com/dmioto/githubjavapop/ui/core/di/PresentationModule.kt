package com.dmioto.githubjavapop.ui.core.di

import com.dmioto.githubjavapop.ui.products.Navigator
import com.dmioto.githubjavapop.ui.core.base.BaseActivity
import com.dmioto.githubjavapop.ui.products.main.MainPresenter
import com.dmioto.githubjavapop.ui.products.popularjavarepositories.PopularJavaRepositoriesPresenter
import com.dmioto.githubjavapop.ui.products.repositorypullrequest.RepositoryPullRequestPresenter
import org.koin.dsl.module

object PresentationModule {

    fun get() = module {

        factory { (activity: BaseActivity) -> MainPresenter(
            Navigator(
                activity
            )
        ) }
        factory { (activity: BaseActivity) -> PopularJavaRepositoriesPresenter(
            Navigator(
                activity
            ), get()) }
        factory { (activity: BaseActivity) -> RepositoryPullRequestPresenter(
            Navigator(
                activity
            ), get()) }

    }

}