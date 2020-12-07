package com.dmioto.githubjavapop.ui.core.base

import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import org.koin.core.KoinComponent

internal abstract class BasePresenter<T : RequestViewInterface> : KoinComponent {

    internal var disposable: Disposable? = null
    internal var compositeDisposable = CompositeDisposable()
    internal var view: T? = null

    open fun attachView(view: T) {
        this.view = view
    }

    open fun detachView() {
        this.view = null
        cancelDisposable()
    }

    fun onDestroyView() {
        cancelDisposable()
        detachView()
    }

    private fun cancelDisposable() {
        compositeDisposable.clear()
        disposable?.dispose()
        disposable = null
    }
}