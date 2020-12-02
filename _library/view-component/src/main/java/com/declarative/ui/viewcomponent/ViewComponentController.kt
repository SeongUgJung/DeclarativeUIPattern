package com.declarative.ui.viewcomponent

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.MutableLiveData
import javax.inject.Provider

open class ViewComponentController {

    private val childHolders: MutableMap<Provider<out ViewComponentHolder>, ViewComponentHolder> = mutableMapOf()
    private val initializedHolder = MutableLiveData<List<ViewComponentHolder>>(emptyList())

    fun activate(holderProvider: Provider<out ViewComponentHolder>) {
        childHolders.getOrPut(holderProvider) {
            val holder = holderProvider.get()
            holder.initialize()
            initializedHolder.value = initializedHolder.value?.plus(holder)
            holder
        }
    }

    fun deactivate(holderProvider: Provider<out ViewComponentHolder>) {
        childHolders.remove(holderProvider)?.let {
            it.deinitialize()
            initializedHolder.value = initializedHolder.value?.minus(it)
        }

    }

    fun deactivateAll() {
        childHolders.onEach { it.value.deinitialize() }.clear()
        initializedHolder.value = emptyList()
    }

    @Composable
    fun render() {
        val holders by initializedHolder.observeAsState()
        holders?.forEach {
            it.render()
        }
    }

    companion object {

        val EMPTY = ViewComponentController()
    }
}