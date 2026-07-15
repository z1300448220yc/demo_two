package com.itcast.demo_two.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.itcast.demo_two.data.local.TodoPreferences
import com.itcast.demo_two.data.model.TodoItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {
    // 数据列表
    private val _todos = MutableStateFlow<List<TodoItem>>(emptyList())
    val todos = _todos.asStateFlow()

    // DataStore的操作实例
    private val preferences = TodoPreferences(application.applicationContext)

    // 初始化方法
    init {
        viewModelScope.launch {
            _todos.value = preferences.loadTodos()
        }
    }

    // 增加Todo

    // 修改Todo

    // 删除Todo
}