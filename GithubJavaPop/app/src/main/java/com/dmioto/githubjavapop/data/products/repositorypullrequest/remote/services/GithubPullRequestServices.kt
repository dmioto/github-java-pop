package com.dmioto.githubjavapop.data.products.repositorypullrequest.remote.services

import com.dmioto.githubjavapop.data.products.repositorypullrequest.entity.PullRequests
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

internal interface GithubPullRequestServices {

    @GET("repos/{owner}/{repo}/pulls")
    fun getPullRequestsFromRepository(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ) : Single<ArrayList<PullRequests>>

}