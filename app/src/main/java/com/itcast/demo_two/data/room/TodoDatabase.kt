package com.itcast.demo_two.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


// @Database → 数据库入口，管理所有表
@Database(entities = [TodoEntity::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {

    // 提供 Dao 的访问
    abstract fun todoDao(): TodoDao



    // 单例：全局只有一个数据库实例
    companion object {
        @Volatile
        private var INSTANCE: TodoDatabase? = null

        fun getDatabase(context: Context): TodoDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    TodoDatabase::class.java,
                    "todo.db"  // 数据库文件名
                ).build().also { INSTANCE = it }
            }
        }
    }
}