package com.dmioto.githubjavapop.domain.products.popularjavarepositories.model

import com.dmioto.githubjavapop.domain.core.DomainModel
import com.dmioto.githubjavapop.data.products.popularjavarepositories.entity.Repository

data class GithubRepositoriesDomain(
    var items: ArrayList<Repository>?
) : DomainModel