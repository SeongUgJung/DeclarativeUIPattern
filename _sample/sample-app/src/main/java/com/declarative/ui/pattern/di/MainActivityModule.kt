package com.declarative.ui.pattern.di

import com.declarative.ui.pattern.viewcomponents.RootViewComponent
import com.declarative.ui.pattern.viewcomponents.RootViewComponentController
import com.declarative.ui.pattern.viewcomponents.RootViewComponentHolder
import com.declarative.ui.pattern.viewcomponents.body.*
import com.declarative.ui.pattern.viewcomponents.toolbar.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object MainActivityModule {

    @Provides
    fun toolbarHolder(): ToolbarViewComponentHolder {
        val toolbarViewStore = ToolbarViewStore()
        val toolbarViewComponent = ToolbarViewComponent(
            ToolbarViewModel(toolbarViewStore),
            ToolbarViewRender(toolbarViewStore)
        )
        return ToolbarViewComponentHolder(toolbarViewComponent)
    }

    @Provides
    fun bodyHolder(): BodyViewComponentHolder {
        val bodyViewStore = BodyViewStore()
        val bodyViewComponent = BodyViewComponent(
            BodyViewModel(bodyViewStore),
            BodyViewRender(bodyViewStore)
        )
        return BodyViewComponentHolder(bodyViewComponent)
    }

    @Provides
    fun rootHolder(
        toolbarViewComponentHolder: ToolbarViewComponentHolder,
        bodyViewComponentHolder: BodyViewComponentHolder
    ): RootViewComponentHolder {
        val rootViewComponent = RootViewComponent()

        return RootViewComponentHolder(
            RootViewComponentController(
                toolbarViewComponentHolder,
                bodyViewComponentHolder
            ), rootViewComponent
        )

    }
}