package com.itcast.demo_two.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.itcast.demo_two.data.model.TodoItem
import kotlinx.serialization.json.Json


// 顶级声明一个实例， 确保全局只有一个DataStore实例
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "todo_store")


class TodoPreferences(context: Context) {
    // 1. 获取dataStore
    private val dataStore = context.dataStore

    // 2. json初始化
    private val json = Json { ignoreUnknownKeys = true }

    // 3. 定义key
    private val TODO_KEY = stringPreferencesKey("todo_list")

    // 4. 保存todos
    suspend fun saveTodos(todos: List<TodoItem>) {

    }

    // 5. 获取todos
    suspend fun loadTodos(): List<TodoItem> {
        return emptyList()
    }
}