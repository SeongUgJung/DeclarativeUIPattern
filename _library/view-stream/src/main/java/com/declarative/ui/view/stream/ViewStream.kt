package com.declarative.ui.view.stream

interface ViewStream {
    fun find(id: Any): ObservableView
}

interface ViewTrigger {
    fun clickable(id: Any): ClickTrigger
}

class ViewStreamImpl() : ViewStream, ViewTrigger {

    private val views = hashMapOf<Any, ObservableView>()

    override fun find(id: Any): ObservableView {
        return views.getOrPut(id) { ObservableViewImpl() }
    }

    override fun clickable(id: Any): ClickTrigger {
        val view = views.getOrPut(id) { ObservableViewImpl() }
        return (view as? ClickTrigger) ?: ClickTrigger.EMPTY
    }
}