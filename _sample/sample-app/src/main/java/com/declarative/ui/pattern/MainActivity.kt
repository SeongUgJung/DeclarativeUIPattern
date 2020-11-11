package com.declarative.ui.pattern

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.platform.setContent
import com.declarative.ui.pattern.viewcomponents.toolbar.ToolbarViewComponent
import com.declarative.ui.pattern.viewcomponents.toolbar.ToolbarViewModel
import com.declarative.ui.pattern.viewcomponents.toolbar.ToolbarViewRender
import com.declarative.ui.pattern.viewcomponents.toolbar.ToolbarViewStore
import com.declarative.ui.pattern.ui.DeclarativeUIPatternTheme
import com.declarative.ui.pattern.viewcomponents.RootViewComponent
import com.declarative.ui.pattern.viewcomponents.body.BodyViewComponent
import com.declarative.ui.pattern.viewcomponents.body.BodyViewModel
import com.declarative.ui.pattern.viewcomponents.body.BodyViewRender
import com.declarative.ui.pattern.viewcomponents.body.BodyViewStore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val toolbarViewStore = ToolbarViewStore()
        val toolbarViewComponent = ToolbarViewComponent(
            ToolbarViewModel(toolbarViewStore),
            ToolbarViewRender(toolbarViewStore)
        )

        val bodyViewStore = BodyViewStore()
        val bodyViewComponent = BodyViewComponent(
            BodyViewModel(bodyViewStore),
            BodyViewRender(bodyViewStore)
        )




        val rootViewComponent = RootViewComponent(toolbarViewComponent, bodyViewComponent)
        setContent {
            DeclarativeUIPatternTheme {
                Surface(color = MaterialTheme.colors.background) {
                    rootViewComponent.render()
                }
            }
        }
    }
}