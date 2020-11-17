package com.declarative.ui.viewcomponent

import androidx.compose.runtime.Composable

abstract class ViewComponentHolder(
    private val viewComponent: ViewComponent,
    private val controller: ViewComponentController = ViewComponentController.EMPTY
) {

    fun initialize() {
        viewComponent.isReady = true
    }

    fun deinitialize() {
        viewComponent.isReady = false
        controller.deinitialize()
    }

    @Composable
    fun render() {
        if (viewComponent.isReady) {
            viewComponent.render { controller.render() }
        }
    }
}