package com.dmioto.githubjavapop.data.products.repositorypullrequest.entity

import com.dmioto.githubjavapop.data.core.Entity
import com.dmioto.githubjavapop.domain.core.DomainMappable
import com.dmioto.githubjavapop.domain.products.repositorypullrequest.model.UserDomain
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

internal data class User(
    @Expose @SerializedName("login") var login: String?,
    @Expose @SerializedName("avatar_url") var avatar_url: String?
) : Entity, DomainMappable<UserDomain> {

    override fun asDomainObject(): UserDomain {
        return UserDomain(
            this.login,
            this.avatar_url
        )
    }

    companion object {
        fun fromDomainObject(obj: UserDomain): User {
            return User(
                obj.login,
                obj.avatar_url
            )
        }
    }

}