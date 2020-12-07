package com.dmioto.githubjavapop.domain.products.popularjavarepositories.model

import com.dmioto.githubjavapop.domain.core.DomainModel

data class OwnerDomain(
    var login: String?,
    var avatar_url: String?
) : DomainModel