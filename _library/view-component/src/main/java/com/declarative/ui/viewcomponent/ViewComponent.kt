package com.declarative.ui.viewcomponent

import androidx.compose.runtime.Composable

abstract class ViewComponent(
    private val viewModel: ViewModel = ViewModel.EMPTY,
    private val viewRender: ViewRender = ViewRender.EMPTY,
    private vararg val childViewComponents: ViewComponent
) : RouterComponent {

    override var isReady: Boolean = false
        set(value) {
            field = value

            if (value) {
                viewModel.initialize()
            } else {
                viewModel.deinitialize()
            }
        }

    @Composable
    override fun render(child: (@Composable () -> Unit)) {
        viewRender.render()
        childViewComponents.filter { isReady }.forEach {
            it.render()
        }
    }
}