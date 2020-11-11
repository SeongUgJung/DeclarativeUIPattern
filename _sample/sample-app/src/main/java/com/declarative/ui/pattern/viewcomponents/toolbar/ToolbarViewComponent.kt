package com.declarative.ui.pattern.viewcomponents.toolbar

import com.declarative.ui.viewcomponent.ViewComponent

class ToolbarViewComponent(
    viewModel: ToolbarViewModel,
    viewRender: ToolbarViewRender,
) : ViewComponent(viewModel, viewRender) {

    override fun isReady(): Boolean = true

}