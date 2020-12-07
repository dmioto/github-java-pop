package com.dmioto.githubjavapop.data.products.popularjavarepositories.entity

import com.dmioto.githubjavapop.domain.core.DomainMappable
import com.dmioto.githubjavapop.data.core.Entity
import com.dmioto.githubjavapop.domain.products.popularjavarepositories.model.OwnerDomain
import com.dmioto.githubjavapop.domain.products.popularjavarepositories.model.RepositoriesDomain
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Repository(
    @Expose @SerializedName("name") var name: String?,
    @Expose @SerializedName("description") var description: String?,
    @Expose @SerializedName("forks_count") var forks_count: Int?,
    @Expose @SerializedName("stargazers_count") var stargazers_count: Int?,
    @Expose @SerializedName("owner") var owner: OwnerDomain?
) : Entity,
    DomainMappable<RepositoriesDomain> {

    override fun asDomainObject(): RepositoriesDomain {
        return RepositoriesDomain(
            this.name,
            this.description,
            this.forks_count,
            this.stargazers_count,
            this.owner
        )
    }
}