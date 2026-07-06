package com.itcast.demo_two.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Greeting(name: String) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Red)
            .padding(top = 40.dp)
    ) {
        Text(
            text = "你好呀，我是一个组件， $name",
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Green)
                .padding(start = 10.dp, top = 15.dp),
            fontSize = 20.sp,
            color = Color.White
        )
    }
}