package com.dmioto.githubjavapop.domain.core

interface Interactor<T> {
    fun execute(): T
}