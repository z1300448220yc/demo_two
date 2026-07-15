package com.itcast.demo_two.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

//  @Entity 根据下面的数据类 映射出 一张 数据库表
@Entity(tableName = "todos")
data class TodoEntity(
    // 主键自增
    @PrimaryKey(autoGenerate = true)   // 主键自增 1,2,3
    val id: Int = 0,
    val text: String,
    val isDone: Boolean = false
)