package com.declarative.ui.viewcomponent

import androidx.compose.runtime.Composable

open class ViewComponentController(vararg val holders: ViewComponentHolder) {

    fun deinitialize() {
        holders.asSequence().onEach { it.deinitialize() }
    }

    @Composable
    fun render() {
        holders.forEach { it.render() }
    }

    companion object {
        val EMPTY = ViewComponentController()
    }
}