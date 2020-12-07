package com.dmioto.githubjavapop.data.products.repositorypullrequest.entity

import com.dmioto.githubjavapop.data.core.Entity
import com.dmioto.githubjavapop.domain.core.DomainMappable
import com.dmioto.githubjavapop.domain.products.repositorypullrequest.model.PullRequestsDomain
import com.dmioto.githubjavapop.domain.products.repositorypullrequest.model.UserDomain
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PullRequests(
    @Expose @SerializedName("title") var title: String,
    @Expose @SerializedName("body") var body: String,
    @Expose @SerializedName("created_at") var created_at: String,
    @Expose @SerializedName("user") var user: UserDomain
) : Entity,
    DomainMappable<PullRequestsDomain> {

    override fun asDomainObject(): PullRequestsDomain {
        return PullRequestsDomain(
            this.title,
            this.body,
            this.created_at,
            this.user
        )
    }

    companion object {
        const val PULL_REQUEST_OWNER = "PULL_REQUEST_OWNER"
        const val PULL_REQUEST_REPO = "PULL_REQUEST_REPO"
    }
}