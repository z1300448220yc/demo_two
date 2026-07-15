package com.itcast.demo_two.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.itcast.demo_two.data.model.TodoItem
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.serialization.builtins.ListSerializer
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
        // 4.1 把 kotlin对象 转成 json字符串
        val jsonStr = json.encodeToString(ListSerializer(TodoItem.serializer()), todos)
        // 4.2 保存
        dataStore.edit { it[TODO_KEY] = jsonStr }
    }

    // 5. 获取todos
    suspend fun loadTodos(): List<TodoItem> {
        return dataStore.data.map { prefs ->
            val jsonStr = prefs[TODO_KEY] ?: ""
            if (jsonStr.isEmpty()) emptyList()
            else json.decodeFromString(ListSerializer(TodoItem.serializer()), jsonStr)
        }.first()
    }

    // ---------------------------

    private val NICKNAME_KEY = stringPreferencesKey("nick_name")

    suspend fun saveNickName(name: String){
        dataStore.edit { it[NICKNAME_KEY] = name}
    }

    suspend fun getNickName(): String{
        return dataStore.data.map { it[NICKNAME_KEY] ?: "" }.first()
    }


}