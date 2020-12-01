package com.declarative.ui.pattern.viewcomponents.body.child

import com.declarative.ui.viewcomponent.ViewComponent
import com.declarative.ui.viewcomponent.ViewComponentController
import com.declarative.ui.viewcomponent.ViewComponentHolder

class BodyChildViewComponent(viewModel: BodyChildViewModel,
                             viewRender: BodyChildViewRender) : ViewComponent(viewRender = viewRender, viewModel = viewModel)

class BodyChildViewComponentHolder(bodyViewComponent: BodyChildViewComponent) : ViewComponentHolder(bodyViewComponent,
                                                                                                    ViewComponentController.EMPTY)