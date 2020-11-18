package com.declarative.ui.pattern.viewcomponents.body

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import com.declarative.ui.view.stream.ViewTrigger
import com.declarative.ui.viewcomponent.ViewStore

class BodyViewStore(val viewTrigger: ViewTrigger) : ViewStore {

    private var cached: (@Composable () -> Unit) = {}
    private val updator = MutableLiveData<Int>(0)

    @Composable
    override fun draw() {
        cached.invoke()
    }

    fun showBasicButton() {

        cached = @Composable {
            val rowId = "item"
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable(onClick = {
                    viewTrigger.clickable(rowId).click()
                })
                    .layoutId(rowId)
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text("HA")
                Column(
                    modifier = Modifier.padding(start = 16.dp)
                        .fillMaxWidth()
                ) {
                    Text("Steve Jung")
                    Text("4 mins ago")
                }
            }
        }

    }
}