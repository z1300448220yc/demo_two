package com.itcast.demo_two.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.itcast.demo_two.data.room.TodoDatabase
import com.itcast.demo_two.data.room.TodoEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class TodoRoomViewModel(application: Application) : AndroidViewModel(application) {

    private val _todos = MutableStateFlow<List<TodoEntity>>(emptyList())
    val todos = _todos.asStateFlow()

    private val db = TodoDatabase.getDatabase(application.applicationContext)
    private val todoDao = db.todoDao()

    init {
        loadTodos()
    }

    private fun loadTodos() {
        viewModelScope.launch {
            _todos.value = todoDao.getAll()
        }
    }

    fun addTodo(text: String) {
        viewModelScope.launch {
            todoDao.insert(TodoEntity(text = text))
            loadTodos() // 重新查询刷新列表
        }
    }

    // 修改Todo
    fun toggleTodo(todo: TodoEntity) {
        viewModelScope.launch {
            todoDao.update(todo.copy(isDone = !todo.isDone))
            loadTodos() // 重新查询刷新列表
        }
    }

    // 删除Todo
    fun deleteTodo(todo: TodoEntity) {
        viewModelScope.launch {
            todoDao.delete(todo)
            loadTodos() // 重新查询刷新列表
        }
    }
}