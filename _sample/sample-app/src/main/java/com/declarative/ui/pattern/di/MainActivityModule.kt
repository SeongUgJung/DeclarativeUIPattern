package com.declarative.ui.pattern.di

import com.declarative.ui.pattern.viewcomponents.RootViewComponent
import com.declarative.ui.pattern.viewcomponents.RootViewComponentController
import com.declarative.ui.pattern.viewcomponents.RootViewComponentHolder
import com.declarative.ui.pattern.viewcomponents.body.*
import com.declarative.ui.pattern.viewcomponents.body.child.BodyChildViewComponent
import com.declarative.ui.pattern.viewcomponents.body.child.BodyChildViewComponentHolder
import com.declarative.ui.pattern.viewcomponents.body.child.BodyChildViewRender
import com.declarative.ui.pattern.viewcomponents.body.child.BodyChildViewStore
import com.declarative.ui.pattern.viewcomponents.toolbar.*
import com.declarative.ui.view.stream.ViewStream
import com.declarative.ui.view.stream.ViewStreamImpl
import com.declarative.ui.view.stream.ViewTrigger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object MainActivityModule {

    @Provides
    @ActivityScoped
    fun toolbarHolder(): ToolbarViewComponentHolder {
        val toolbarViewStore = ToolbarViewStore()
        val toolbarViewComponent = ToolbarViewComponent(
            ToolbarViewModel(toolbarViewStore),
            ToolbarViewRender(toolbarViewStore)
        )
        return ToolbarViewComponentHolder(toolbarViewComponent)
    }

    @Provides
    @ActivityScoped
    fun bodyChildHolder(): BodyChildViewComponentHolder {
        return BodyChildViewComponentHolder(
            BodyChildViewComponent(
                BodyChildViewRender(
                    BodyChildViewStore()
                )
            )
        )
    }

    @Provides
    @ActivityScoped
    fun bodyHolder(
        viewStream: ViewStream,
        viewTrigger: ViewTrigger,
        bodyChildViewComponentHolder: BodyChildViewComponentHolder
    ): BodyViewComponentHolder {
        val bodyViewStore = BodyViewStore(viewTrigger)
        val bodyViewComponentController = BodyViewComponentController(bodyChildViewComponentHolder)
        val bodyViewComponent = BodyViewComponent(
            BodyViewModel(
                bodyViewStore,
                viewStream,
                BodyViewInteractor(bodyViewComponentController)
            ),
            BodyViewRender(bodyViewStore)
        )
        return BodyViewComponentHolder(bodyViewComponent, bodyViewComponentController)
    }

    @Provides
    @ActivityScoped
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

    @Provides
    @ActivityScoped
    fun viewStreamImpl() = ViewStreamImpl()

    @Provides
    @ActivityScoped
    fun viewStream(viewStream: ViewStreamImpl): ViewStream = viewStream

    @Provides
    @ActivityScoped
    fun viewTrigger(viewStream: ViewStreamImpl): ViewTrigger = viewStream

}