package com.declarative.ui.pattern.viewcomponents.body

import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.declarative.ui.viewcomponent.ViewStore

class BodyViewStore : ViewStore() {

    private var cached: (@Composable () -> Unit) = {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable(onClick = {})
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text("HA")
            Column(
                modifier = Modifier.padding(start = 16.dp)
                    .fillMaxWidth()
            ) {
                Text("Steve Jung")
                Text("3 mins ago")
            }
        }
    }

    @Composable
    override fun draw() {
        cached.invoke()
    }
}