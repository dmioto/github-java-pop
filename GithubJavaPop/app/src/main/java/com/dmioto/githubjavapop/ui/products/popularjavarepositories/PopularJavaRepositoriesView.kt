package com.dmioto.githubjavapop.ui.products.popularjavarepositories

import com.dmioto.githubjavapop.data.products.popularjavarepositories.entity.Repository
import com.dmioto.githubjavapop.ui.core.base.RequestViewInterface

internal interface PopularJavaRepositoriesView : RequestViewInterface {
    fun getRepositories(repositories: ArrayList<Repository>)
    fun showGenericError()
}