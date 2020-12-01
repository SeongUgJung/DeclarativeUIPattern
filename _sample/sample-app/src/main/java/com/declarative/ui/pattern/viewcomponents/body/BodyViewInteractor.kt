package com.declarative.ui.pattern.viewcomponents.body

import com.declarative.ui.viewcomponent.Interactor

class BodyViewInteractor(private val bodyViewComponentController: BodyViewComponentController) : Interactor {

    fun showChild() {
        bodyViewComponentController.initChild()
    }

    fun hideChild() {
        bodyViewComponentController.deinitChild()
    }
}