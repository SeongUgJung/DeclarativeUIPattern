package com.declarative.ui.pattern.viewcomponents.body

import com.declarative.ui.view.stream.ViewStream
import com.declarative.ui.viewcomponent.RxViewModel
import io.reactivex.rxjava3.core.Completable

class BodyViewModel(
    override val viewStore: BodyViewStore,
    private val viewStream: ViewStream,
    private val interactor: BodyViewInteractor
) : RxViewModel(viewStore) {

    override fun initialize() {
        super.initialize()
        viewStore.showBasicButton()
    }

    override fun initCompletable(): Completable {
        return viewStream.find("item")
            .onClick()
            .scan(0, { t1, _ -> t1 + 1 })
            .doOnNext { clickCount ->
                if (clickCount % 2 == 0) {
                    interactor.showChild()
                } else {
                    interactor.hideChild()
                }
            }
            .ignoreElements()
    }
}