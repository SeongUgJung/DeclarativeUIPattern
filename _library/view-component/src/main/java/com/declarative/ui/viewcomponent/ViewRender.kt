package com.declarative.ui.viewcomponent

import androidx.compose.runtime.Composable

abstract class ViewRender(private val viewStore: ViewStore) {

    @Composable
    fun render() {
        viewStore.draw()
    }

    companion object {
        val EMPTY = object : ViewRender(ViewStore.EMPTY) {}
    }
}