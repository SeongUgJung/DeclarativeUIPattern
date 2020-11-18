package com.declarative.ui.pattern.viewcomponents.body.child

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.declarative.ui.viewcomponent.ViewStore

class BodyChildViewStore : ViewStore {

    private val cached: (@Composable () -> Unit) = {
        Text(text = "Hello World~!!!!")
    }

    @Composable
    override fun draw() {
        cached.invoke()
    }

}