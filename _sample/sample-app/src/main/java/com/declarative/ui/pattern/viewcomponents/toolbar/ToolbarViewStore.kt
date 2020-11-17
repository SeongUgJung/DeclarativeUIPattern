package com.declarative.ui.pattern.viewcomponents.toolbar

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.declarative.ui.viewcomponent.ViewStore

class ToolbarViewStore : ViewStore {

    private var cached: (@Composable () -> Unit) = {}

    @Composable
    override fun draw() {
        cached.invoke()
    }

    fun showBasicToolbar() {
        cached = @Composable {
            TopAppBar(title = { Text(text = "Sample App") })
        }
    }
}