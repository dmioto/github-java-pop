package com.dmioto.githubjavapop.ui.products.main

import com.dmioto.githubjavapop.ui.products.Navigator
import com.dmioto.githubjavapop.ui.core.base.BasePresenter

internal class MainPresenter(private val navigator: Navigator) : BasePresenter<MainView>() {

    fun navigatePopularJavaRepositories() {
        navigator.navigatePopularJavaRepositories()
    }
}