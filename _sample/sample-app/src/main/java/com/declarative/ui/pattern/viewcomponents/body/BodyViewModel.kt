package com.declarative.ui.pattern.viewcomponents.body

import com.declarative.ui.view.stream.ViewStream
import com.declarative.ui.viewcomponent.RxViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

class BodyViewModel(override val viewStore: BodyViewStore,
                    private val viewStream: ViewStream,
                    private val interactor: BodyViewInteractor) : RxViewModel(viewStore) {

    override fun initCompletable(): Completable {
        return Observable.mergeArray(showScreen(), observeClick())
            .ignoreElements()
    }

    private fun showScreen(): Observable<Int> {
        return Observable.just(1)
            .delay(2, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { viewStore.showBasicButton() }
    }

    private fun observeClick(): Observable<Int> {
        return viewStream.find("item")
            .onClick()
            .scan(1, { t1, _ -> t1 + 1 })
            .doOnNext { clickCount ->
                if (clickCount % 2 == 0) {
                    interactor.showChild()
                } else {
                    interactor.hideChild()
                }
            }
    }
}