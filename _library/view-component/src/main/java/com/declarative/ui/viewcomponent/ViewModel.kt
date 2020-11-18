package com.declarative.ui.viewcomponent

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.internal.functions.Functions

abstract class ViewModel(open val viewStore: ViewStore) {

    abstract fun initialize()
    abstract fun deinitialize()

    companion object {
        val EMPTY = object : ViewModel(ViewStore.EMPTY) {
            override fun initialize() {}
            override fun deinitialize() {}
        }
    }
}

abstract class RxViewModel(viewStore: ViewStore) : ViewModel(viewStore) {

    private var disposable: Disposable? = null

    override fun initialize() {
        disposable = initCompletable().subscribe(Functions.EMPTY_ACTION, Functions.emptyConsumer())
    }

    abstract fun initCompletable(): Completable

    override fun deinitialize() {
        disposable?.dispose()
    }
}