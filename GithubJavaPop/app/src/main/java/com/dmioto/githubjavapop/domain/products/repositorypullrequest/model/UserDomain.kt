package com.dmioto.githubjavapop.domain.products.repositorypullrequest.model

import com.dmioto.githubjavapop.domain.core.DomainModel

data class UserDomain(
    var login: String?,
    var avatar_url: String?
) : DomainModel