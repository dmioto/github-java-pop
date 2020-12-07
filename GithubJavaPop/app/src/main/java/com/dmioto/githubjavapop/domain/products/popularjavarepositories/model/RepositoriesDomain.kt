package com.dmioto.githubjavapop.domain.products.popularjavarepositories.model

import com.dmioto.githubjavapop.domain.core.DomainModel
import com.dmioto.githubjavapop.domain.products.popularjavarepositories.model.OwnerDomain

data class RepositoriesDomain(
    var name: String?,
    var description: String?,
    var forks_count: Int?,
    var stargazers_count: Int?,
    var owner: OwnerDomain?) : DomainModel {
}