package com.dmioto.githubjavapop.data.products.popularjavarepositories.entity

import com.dmioto.githubjavapop.domain.core.DomainMappable
import com.dmioto.githubjavapop.data.core.Entity
import com.dmioto.githubjavapop.domain.products.popularjavarepositories.model.GithubRepositoriesDomain
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

internal data class GithubRepositories(
    @Expose @SerializedName("items") var items : ArrayList<Repository>?
    ) : Entity,
    DomainMappable<GithubRepositoriesDomain> {

    override fun asDomainObject(): GithubRepositoriesDomain {
        return GithubRepositoriesDomain(
            this.items
        )
    }

    companion object {
        fun fromDomainObject(obj: GithubRepositoriesDomain): GithubRepositories {
            return GithubRepositories(
                obj.items
            )
        }
    }
}