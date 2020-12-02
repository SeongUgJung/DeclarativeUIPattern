package com.declarative.ui.pattern.viewcomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.declarative.ui.pattern.viewcomponents.body.BodyViewComponentHolder
import com.declarative.ui.pattern.viewcomponents.toolbar.ToolbarViewComponentHolder
import com.declarative.ui.viewcomponent.ViewComponent
import com.declarative.ui.viewcomponent.ViewComponentController
import com.declarative.ui.viewcomponent.ViewComponentHolder
import javax.inject.Provider

class RootViewComponent() : ViewComponent() {

    @Composable
    override fun render(child: @Composable() () -> Unit) {
        MaterialTheme {
            Surface {
                Column {
                    child.invoke()
                }
            }
        }

    }
}

class RootViewComponentController(
    toolbarViewComponentHolder: Provider<ToolbarViewComponentHolder>,
    bodyViewComponentHolder: Provider<BodyViewComponentHolder>
) :
    ViewComponentController() {

    init {
        activate(toolbarViewComponentHolder)
        activate(bodyViewComponentHolder)
    }

}

class RootViewComponentHolder(
    rootViewComponentController: RootViewComponentController,
    rootViewComponent: RootViewComponent
) : ViewComponentHolder(rootViewComponent, rootViewComponentController)