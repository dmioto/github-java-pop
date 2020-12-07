package com.dmioto.githubjavapop.data.products.popularjavarepositories.remote.services

import com.dmioto.githubjavapop.data.products.popularjavarepositories.entity.GithubRepositories
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

internal interface GithubRepositoriesServices {

    @GET("search/repositories?q=language:Java&sort=stars")
    fun getPopularJavaRepositories(
        @Query("page") page: Int
    ) : Single<GithubRepositories>


}