package com.declarative.ui.viewcomponent

import androidx.compose.runtime.Composable

abstract class ViewStore {
    @Composable
    abstract fun draw()
}