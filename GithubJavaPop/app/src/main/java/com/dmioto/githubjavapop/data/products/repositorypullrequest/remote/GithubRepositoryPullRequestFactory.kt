package com.dmioto.githubjavapop.data.products.repositorypullrequest.remote

import com.dmioto.githubjavapop.data.core.RequestManager
import com.dmioto.githubjavapop.data.core.ServicesFactory
import com.dmioto.githubjavapop.data.products.repositorypullrequest.remote.services.GithubPullRequestServices

internal class GithubRepositoryPullRequestFactory private constructor() : ServicesFactory {

    companion object {
        const val BASE_URL = "https://api.github.com"
        private var instance: GithubRepositoryPullRequestFactory? = null

        @Synchronized
        fun instance(): GithubRepositoryPullRequestFactory {
            if (instance == null) {
                instance =
                    GithubRepositoryPullRequestFactory()
            }
            return instance!!
        }
    }

    /* Services */
    private var githubPullRequestServices: GithubPullRequestServices? = null

    override fun refreshAllServices() {
        githubPullRequestServices = null
    }

    /**
     * Github Repositories Services
     */

    fun getGithubPullRequestService(): GithubPullRequestServices? {

        if (githubPullRequestServices == null) {
            githubPullRequestServices = RequestManager.provideRetrofit(
                BASE_URL
            ).create(
                GithubPullRequestServices::class.java)
        }
        return githubPullRequestServices
    }


}