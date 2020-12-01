package com.declarative.ui.pattern.viewcomponents.body.child

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.MutableLiveData
import com.declarative.ui.viewcomponent.ViewStore

class BodyChildViewStore : ViewStore {

    private val cached: MutableLiveData<(@Composable () -> Unit)> = MutableLiveData @Composable {
    }

    @Composable
    override fun draw() {
        val observeAsState by cached.observeAsState()
        observeAsState!!.invoke()
    }

    fun showCounter(counter: MutableLiveData<Int>) {
        cached.value = @Composable {
            val counter1 by counter.observeAsState()
            Text(text = "Hello World = ${counter1!!}")
        }
    }

}