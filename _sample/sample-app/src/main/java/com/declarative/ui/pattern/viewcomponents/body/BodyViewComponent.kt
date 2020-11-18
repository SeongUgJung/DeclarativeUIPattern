package com.declarative.ui.pattern.viewcomponents.body

import com.declarative.ui.pattern.viewcomponents.body.child.BodyChildViewComponentHolder
import com.declarative.ui.viewcomponent.ViewComponent
import com.declarative.ui.viewcomponent.ViewComponentController
import com.declarative.ui.viewcomponent.ViewComponentHolder

class BodyViewComponent(
    viewModel: BodyViewModel,
    viewRender: BodyViewRender,
) : ViewComponent(viewModel, viewRender)

class BodyViewComponentHolder(
    bodyViewComponent: BodyViewComponent,
    bodyViewComponentController: BodyViewComponentController
) : ViewComponentHolder(bodyViewComponent, bodyViewComponentController)

class BodyViewComponentController(private val bodyChildViewComponentHolder: BodyChildViewComponentHolder) :
    ViewComponentController(bodyChildViewComponentHolder) {
    fun initChild() {
        bodyChildViewComponentHolder.initialize()
    }

    fun deinitChild() {
        bodyChildViewComponentHolder.deinitialize()
    }

}