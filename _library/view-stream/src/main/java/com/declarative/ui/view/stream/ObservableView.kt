package com.declarative.ui.view.stream

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject

interface ObservableView {
    fun onClick(): Observable<Boolean>
}

interface ClickTrigger {
    fun click()

    companion object {
        val EMPTY = object : ClickTrigger {
            override fun click() {}
        }
    }
}

internal class ObservableViewImpl : ObservableView, ClickTrigger {

    private val clickSubject by lazy { PublishSubject.create<Boolean>() }

    override fun onClick(): Observable<Boolean> {
        return clickSubject
    }

    override fun click() {
        clickSubject.onNext(true)
    }
}