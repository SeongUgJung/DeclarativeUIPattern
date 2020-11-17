package com.declarative.ui.pattern.viewcomponents.toolbar

import com.declarative.ui.viewcomponent.ViewModel

class ToolbarViewModel(override val viewStore: ToolbarViewStore) : ViewModel(viewStore) {

    override fun initialize() {
        viewStore.showBasicToolbar()
    }
}