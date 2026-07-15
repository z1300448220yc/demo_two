package com.itcast.demo_two

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.itcast.demo_two.ui.pages.TodoScreen
import com.itcast.demo_two.utils.SettingManager
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 从本地加载昵称
        runBlocking {
            SettingManager.init(this@MainActivity)
        }

        setContent {
            TodoScreen()
        }
    }
}
