package com.declarative.ui.viewcomponent

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.internal.functions.Functions

abstract class ViewModel(open val viewStore: ViewStore) {

    open fun initialize() {}
    open fun deinitialize(){}

    companion object {
        val EMPTY = object : ViewModel(ViewStore.EMPTY) {}
    }
}

abstract class RxViewModel(viewStore: ViewStore) : ViewModel(viewStore) {

    private var disposable: Disposable? = null

    override fun initialize() {
        disposable = initCompletable().subscribe(Functions.EMPTY_ACTION, {
            it.printStackTrace()
        })
    }

    abstract fun initCompletable(): Completable

    override fun deinitialize() {
        disposable?.dispose()
    }
}