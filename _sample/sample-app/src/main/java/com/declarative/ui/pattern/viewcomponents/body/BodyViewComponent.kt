package com.declarative.ui.pattern.viewcomponents.body

import com.declarative.ui.viewcomponent.ViewComponent
import com.declarative.ui.viewcomponent.ViewModel
import com.declarative.ui.viewcomponent.ViewRender

class BodyViewComponent(
    viewModel: BodyViewModel,
    viewRender: BodyViewRender,
) : ViewComponent(viewModel, viewRender) {

    override fun isReady(): Boolean = true

}