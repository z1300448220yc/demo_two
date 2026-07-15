package com.itcast.demo_two.data.model

import java.util.UUID


// 数据模型
data class TodoItem(
    val id: String = UUID.randomUUID().toString(),
    val text: String,
    val isDone: Boolean = false
)
