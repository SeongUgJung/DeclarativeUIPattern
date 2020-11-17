package com.declarative.ui.viewcomponent

import androidx.compose.runtime.Composable

interface ViewStore {
    @Composable
    fun draw()

    companion object {
        val EMPTY = object :ViewStore {
            override fun draw() {
            }
        }
    }
}