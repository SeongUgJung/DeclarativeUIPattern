package com.declarative.ui.pattern.viewcomponents.body.child

import com.declarative.ui.viewcomponent.ViewComponent
import com.declarative.ui.viewcomponent.ViewComponentController
import com.declarative.ui.viewcomponent.ViewComponentHolder

class BodyChildViewComponent(
    viewRender: BodyChildViewRender,
) : ViewComponent(viewRender = viewRender)

class BodyChildViewComponentHolder(bodyViewComponent: BodyChildViewComponent) :
    ViewComponentHolder(bodyViewComponent, ViewComponentController.EMPTY)