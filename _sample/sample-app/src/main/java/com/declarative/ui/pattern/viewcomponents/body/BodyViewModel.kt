package com.declarative.ui.pattern.viewcomponents.body

import com.declarative.ui.viewcomponent.ViewModel

class BodyViewModel(override val viewStore: BodyViewStore) : ViewModel(viewStore) {
    override fun initialize() {
        viewStore.showBasicButton()
    }
}