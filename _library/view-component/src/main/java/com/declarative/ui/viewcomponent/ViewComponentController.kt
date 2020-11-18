package com.declarative.ui.viewcomponent

import androidx.compose.runtime.Composable

open class ViewComponentController(vararg val childHolders: ViewComponentHolder) {

    fun deinitialize() {
        childHolders.asSequence().onEach { it.deinitialize() }
    }

    @Composable
    fun render() {
        childHolders.forEach {
            it.render()
        }
    }

    companion object {
        val EMPTY = ViewComponentController()
    }
}