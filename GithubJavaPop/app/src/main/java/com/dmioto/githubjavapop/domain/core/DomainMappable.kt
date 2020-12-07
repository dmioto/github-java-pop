package com.dmioto.githubjavapop.domain.core

interface DomainMappable<DomainClass: DomainModel> {
    fun asDomainObject() : DomainClass
}