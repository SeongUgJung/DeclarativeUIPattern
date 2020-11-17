package com.declarative.ui.pattern

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.platform.setContent
import com.declarative.ui.pattern.ui.DeclarativeUIPatternTheme
import com.declarative.ui.pattern.viewcomponents.RootViewComponentHolder
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var rootViewComponentHolder: RootViewComponentHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        rootViewComponentHolder.initialize()

        setContent {
            DeclarativeUIPatternTheme {
                Surface(color = MaterialTheme.colors.background) {
                    rootViewComponentHolder.render()
                }
            }
        }
    }
}