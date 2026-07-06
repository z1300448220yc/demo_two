package com.itcast.demo_two.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ModifierOrderDemo() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        // padding 在 background 前面 → 外边距效果
        // 红色方块外面有 16dp 透明边距
        Box(
            modifier = Modifier
                .padding(16.dp)        // ← 外边距
                .background(Color.Red) // ← 红色背景
                .size(80.dp)
        ) {
            Text("外", color = Color.White)
        }

        // padding 在 background 后面 → 内边距效果
        // 红色方块更大，文字内缩 16dp
        Box(
            modifier = Modifier
                .padding(16.dp)        // ← 和左边一样有外边距
                .background(Color.Red) // ← 红色背景（包含 padding 区域）
                .padding(16.dp)        // ← 内边距
                .size(80.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("内", color = Color.White)
        }
    }
}

@Composable
fun ColorDemo() {
    Column(
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxSize()
            .padding(top = 40.dp)
    ) {
        Text(
            text = "颜色1",
            modifier = Modifier
                //  .size(width = 100.dp, height = 50.dp)
                .width(100.dp)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(10.dp))
                .border(3.dp, Color.Cyan, RoundedCornerShape(10.dp))
                .background(color = Color(0xFFFF0000).copy(alpha = 0.9f))
                .padding(horizontal = 16.dp, vertical = 8.dp)  // 分别设置
                .clickable {
                    println("666-点我干嘛")
                }

        )
        Text(
            text = "其它",
            modifier = Modifier
                .background(color = Color.Green)
                .weight(1f)
        )
    }
}

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