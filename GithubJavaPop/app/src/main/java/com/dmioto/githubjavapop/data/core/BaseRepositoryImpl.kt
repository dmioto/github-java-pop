package com.dmioto.githubjavapop.data.core

import org.koin.core.KoinComponent

open class BaseRepositoryImpl : KoinComponent {
    fun onRequestSuccess(tag: String? = null, obj: String? = null) {
        //TODO success flux
    }

    fun onRequestError(tag: String? = null, e: Throwable? = null) {
        //TODO error flux
    }
}