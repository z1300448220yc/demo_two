package com.itcast.demo_two.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

// @Dao Data Access Object 定义对表的操作
@Dao
interface TodoDao {
    // 1. 查询所有代办， 按照id升序
    @Query("SELECT * FROM todos ORDER BY id ASC")
    suspend fun getAll(): List<TodoEntity>


    // 2. 插入一条代办
    @Insert
    suspend fun insert(todo: TodoEntity)

    // 3. 更新一条代办
    @Update
    suspend fun update(todo: TodoEntity)

    // 4. 删除一条代办
    @Delete
    suspend fun delete(todo: TodoEntity)
}