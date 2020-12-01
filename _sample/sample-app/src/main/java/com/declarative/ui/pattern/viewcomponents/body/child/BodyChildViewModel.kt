package com.declarative.ui.pattern.viewcomponents.body.child

import androidx.lifecycle.MutableLiveData
import com.declarative.ui.viewcomponent.RxViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class BodyChildViewModel(override val viewStore: BodyChildViewStore) : RxViewModel(viewStore) {

    private val counter = MutableLiveData(0)

    override fun initCompletable(): Completable {
        return Observable.mergeArray(showCounter(), intervalCount())
            .ignoreElements()
    }

    private fun intervalCount(): Observable<Long> {
        return Observable.interval(1, TimeUnit.SECONDS, Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { counter.setValue(counter.value!!.plus(1)) }
    }

    private fun showCounter(): Observable<Long> {
        return Observable.fromAction<Long> {
            viewStore.showCounter(counter)
        }
            .subscribeOn(AndroidSchedulers.mainThread())
    }
}