package com.declarative.ui.pattern.viewcomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.declarative.ui.pattern.viewcomponents.body.BodyViewComponent
import com.declarative.ui.pattern.viewcomponents.toolbar.ToolbarViewComponent
import com.declarative.ui.viewcomponent.RootComponent

class RootViewComponent(
    private val toolbarViewComponent : ToolbarViewComponent,
    private val bodyViewComponent : BodyViewComponent
) : RootComponent {

    @Composable
    override fun render() {
        MaterialTheme {
            Surface {
                Column {
                    toolbarViewComponent.render()
                    bodyViewComponent.render()
                }
            }
        }

    }
}

