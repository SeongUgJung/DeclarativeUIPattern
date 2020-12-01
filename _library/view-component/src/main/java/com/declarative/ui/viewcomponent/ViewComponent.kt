package com.declarative.ui.viewcomponent

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.MutableLiveData

abstract class ViewComponent(private val viewModel: ViewModel = ViewModel.EMPTY,
                             private val viewRender: ViewRender = ViewRender.EMPTY) : RouterComponent {

    internal var cached: MutableLiveData<Boolean> = MutableLiveData(false)

    override var isReady: Boolean = false
        set(value) {
            if (value) {
                viewModel.initialize()
            } else {
                viewModel.deinitialize()
            }
            cached.value = value
        }

    @Composable
    override fun render(child: (@Composable () -> Unit)) {
        val observeAsState by cached.observeAsState()
        if (observeAsState!!) {
            viewRender.render()
            child.invoke()
        }
    }
}