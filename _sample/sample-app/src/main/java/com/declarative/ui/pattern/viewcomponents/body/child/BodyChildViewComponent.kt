package com.declarative.ui.pattern.viewcomponents.body.child

import androidx.compose.runtime.Composable
import com.declarative.ui.viewcomponent.ViewComponent
import com.declarative.ui.viewcomponent.ViewComponentController
import com.declarative.ui.viewcomponent.ViewComponentHolder

class BodyChildViewComponent(
    viewRender: BodyChildViewRender,
) : ViewComponent(viewRender = viewRender) {

    @Composable
    override fun render(child: @Composable () -> Unit) {
        super.render(child)
    }
}

class BodyChildViewComponentHolder(bodyViewComponent: BodyChildViewComponent) :
    ViewComponentHolder(bodyViewComponent, ViewComponentController.EMPTY)