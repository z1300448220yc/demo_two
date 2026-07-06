package com.itcast.demo_two.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Greeting(name: String) {

    Column(
        modifier = Modifier.padding(top = 40.dp)
    ) {
        Text("你好呀，我是一个组件， $name")
    }
}