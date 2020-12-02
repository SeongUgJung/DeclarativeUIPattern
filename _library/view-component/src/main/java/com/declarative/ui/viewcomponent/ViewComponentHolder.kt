package com.declarative.ui.viewcomponent

import androidx.compose.runtime.Composable

abstract class ViewComponentHolder(private val viewComponent: ViewComponent,
                                   private val controller: ViewComponentController = ViewComponentController.EMPTY) {

    fun initialize() {
        viewComponent.isReady = true
    }

    fun deinitialize() {
        viewComponent.isReady = false
        controller.deactivateAll()
    }

    @Composable
    fun render() {
        viewComponent.render { controller.render() }
    }
}