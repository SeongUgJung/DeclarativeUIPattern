package com.declarative.ui.pattern.viewcomponents.body

import com.declarative.ui.pattern.viewcomponents.body.child.BodyChildViewComponentHolder
import com.declarative.ui.viewcomponent.ViewComponent
import com.declarative.ui.viewcomponent.ViewComponentController
import com.declarative.ui.viewcomponent.ViewComponentHolder
import javax.inject.Provider

class BodyViewComponent(
    viewModel: BodyViewModel,
    viewRender: BodyViewRender,
) : ViewComponent(viewModel, viewRender)

class BodyViewComponentHolder(
    bodyViewComponent: BodyViewComponent,
    bodyViewComponentController: BodyViewComponentController
) : ViewComponentHolder(bodyViewComponent, bodyViewComponentController)

class BodyViewComponentController(private val bodyChildViewComponentHolder: Provider<BodyChildViewComponentHolder>) :
    ViewComponentController() {
    fun initChild() {
        activate(bodyChildViewComponentHolder)
    }

    fun deinitChild() {
        deactivate(bodyChildViewComponentHolder)
    }

}