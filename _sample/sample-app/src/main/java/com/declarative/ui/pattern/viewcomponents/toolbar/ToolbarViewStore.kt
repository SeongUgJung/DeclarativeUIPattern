package com.declarative.ui.pattern.viewcomponents.toolbar

import androidx.compose.foundation.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.imageResource
import com.declarative.ui.pattern.R
import com.declarative.ui.viewcomponent.ViewStore

class ToolbarViewStore : ViewStore() {

    private var cached: (@Composable () -> Unit) = {
        TopAppBar(title = { Text(text = "Sample App") })
    }

    @Composable
    override fun draw() {
        cached.invoke()
    }
}