package com.dmioto.githubjavapop.data.products.popularjavarepositories.entity

import com.dmioto.githubjavapop.domain.core.DomainMappable
import com.dmioto.githubjavapop.data.core.Entity
import com.dmioto.githubjavapop.domain.products.popularjavarepositories.model.OwnerDomain
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

internal data class Owner(
    @Expose @SerializedName("login") var login: String?,
    @Expose @SerializedName("avatar_url") var avatar_url: String?
) : Entity, DomainMappable<OwnerDomain> {

    override fun asDomainObject(): OwnerDomain {
        return OwnerDomain(
            this.login,
            this.avatar_url
        )
    }

    companion object {
        fun fromDomainObject(obj: OwnerDomain): Owner {
            return Owner(
                obj.login,
                obj.avatar_url
            )
        }
    }
}