package com.declarative.ui.pattern.viewcomponents.body

import com.declarative.ui.viewcomponent.ViewComponent
import com.declarative.ui.viewcomponent.ViewComponentController
import com.declarative.ui.viewcomponent.ViewComponentHolder

class BodyViewComponent(
    viewModel: BodyViewModel,
    viewRender: BodyViewRender,
) : ViewComponent(viewModel, viewRender)

class BodyViewComponentHolder(bodyViewComponent: BodyViewComponent) :
    ViewComponentHolder(bodyViewComponent, ViewComponentController.EMPTY)