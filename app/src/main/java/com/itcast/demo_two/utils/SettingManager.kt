package com.itcast.demo_two.utils

import android.content.Context
import com.itcast.demo_two.data.local.TodoPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object SettingManager {
    private val _nickname = MutableStateFlow("")
    val nickname = _nickname.asStateFlow()

    private var preferences: TodoPreferences? = null

    /**
     * 初始化方法
     */
    suspend fun init(context: Context) {
        // 1. 创建preferences实例
        preferences = TodoPreferences(context.applicationContext)
        // 2. 从DataStore中读取昵称
        _nickname.value = preferences?.getNickName() ?: ""
    }


    /**
     * 设置昵称
     */
    suspend fun setNickName(name: String) {
        // 1. 更新内存
        _nickname.value = name
        // 2. 更新本地
        preferences?.saveNickName(name)
    }

}