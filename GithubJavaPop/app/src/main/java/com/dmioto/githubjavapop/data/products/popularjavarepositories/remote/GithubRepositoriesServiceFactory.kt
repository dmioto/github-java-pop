package com.dmioto.githubjavapop.data.products.popularjavarepositories.remote

import com.dmioto.githubjavapop.data.core.RequestManager
import com.dmioto.githubjavapop.data.core.ServicesFactory
import com.dmioto.githubjavapop.data.products.popularjavarepositories.remote.services.GithubRepositoriesServices

internal class GithubRepositoriesServiceFactory private constructor():
    ServicesFactory {

    companion object {
        const val BASE_URL = "https://api.github.com"
        private var instance: GithubRepositoriesServiceFactory? = null

        @Synchronized
        fun instance(): GithubRepositoriesServiceFactory {
            if (instance == null) {
                instance =
                    GithubRepositoriesServiceFactory()
            }
            return instance!!
        }
    }

    /* Services */
    private var githubRepositoriesServices: GithubRepositoriesServices? = null

    override fun refreshAllServices() {
        githubRepositoriesServices = null
    }


    /**
     * Github Repositories Services
     */

    fun getGithubRepositoriesService(): GithubRepositoriesServices? {

        if (githubRepositoriesServices == null) {
            githubRepositoriesServices = RequestManager.provideRetrofit(BASE_URL).create(
                GithubRepositoriesServices::class.java)
        }
        return githubRepositoriesServices
    }


}