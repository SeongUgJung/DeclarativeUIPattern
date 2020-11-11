package com.declarative.ui.viewcomponent

import androidx.compose.runtime.Composable

abstract class ViewComponent(
    private val viewModel: ViewModel,
    private val viewRender: ViewRender,
    private vararg val childViewComponents: ViewComponent
) {

    abstract fun isReady(): Boolean

    @Composable
    fun render() {
        viewRender.render()
        childViewComponents.filter { isReady() }.forEach {
            it.render()
        }
    }
}