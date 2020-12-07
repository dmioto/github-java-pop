package com.dmioto.githubjavapop.domain.products.repositorypullrequest.model

import com.dmioto.githubjavapop.domain.core.DomainModel

data class PullRequestsDomain(
    var title: String?,
    var body: String?,
    var create_at: String?,
    var user: UserDomain?
) : DomainModel