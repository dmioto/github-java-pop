package com.dmioto.githubjavapop.data.products.popularjavarepositories.repository

import com.dmioto.githubjavapop.data.core.BaseRepositoryImpl
import com.dmioto.githubjavapop.domain.products.popularjavarepositories.model.GithubRepositoriesDomain
import com.dmioto.githubjavapop.data.products.popularjavarepositories.remote.GithubRepositoriesServiceFactory
import com.dmioto.githubjavapop.domain.products.popularjavarepositories.GithubRepositoriesRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GithubRepositoriesRepositoryImpl() : GithubRepositoriesRepository, BaseRepositoryImpl() {

    override fun getPopularJavaRepositories(page: Int?): Single<GithubRepositoriesDomain> {
        return GithubRepositoriesServiceFactory
            .instance()
            .getGithubRepositoriesService()!!
            .getPopularJavaRepositories(page!!)
            .doOnError {
                onRequestError()
            }
            .doOnSuccess {
                onRequestSuccess()
            }
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap {
                Single.just(it.asDomainObject())
            }
    }

}
