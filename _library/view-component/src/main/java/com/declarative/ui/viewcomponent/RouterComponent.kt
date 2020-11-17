package com.declarative.ui.viewcomponent

import androidx.compose.runtime.Composable

interface RouterComponent {

    var isReady: Boolean

    @Composable
    fun render(child: (@Composable() () -> Unit) = {})
}