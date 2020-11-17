package com.declarative.ui.viewcomponent

abstract class ViewModel(open val viewStore: ViewStore) {

    open fun initialize() {}
    open fun deinitialize() {}

    companion object {
        val EMPTY = object : ViewModel(ViewStore.EMPTY) {}
    }
}