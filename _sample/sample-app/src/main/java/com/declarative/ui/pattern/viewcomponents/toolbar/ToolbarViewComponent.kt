package com.declarative.ui.pattern.viewcomponents.toolbar

import com.declarative.ui.viewcomponent.ViewComponent
import com.declarative.ui.viewcomponent.ViewComponentHolder

class ToolbarViewComponent(
    viewModel: ToolbarViewModel,
    viewRender: ToolbarViewRender,
) : ViewComponent(viewModel, viewRender)

class ToolbarViewComponentHolder(
    viewComponent: ToolbarViewComponent
) : ViewComponentHolder(viewComponent)