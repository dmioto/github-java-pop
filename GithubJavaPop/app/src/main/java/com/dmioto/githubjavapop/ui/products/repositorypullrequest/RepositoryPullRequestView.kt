package com.dmioto.githubjavapop.ui.products.repositorypullrequest

import com.dmioto.githubjavapop.data.products.repositorypullrequest.entity.PullRequests
import com.dmioto.githubjavapop.ui.core.base.RequestViewInterface

internal interface RepositoryPullRequestView : RequestViewInterface {
    fun getPullRequests(pullRequests: ArrayList<PullRequests>)
}