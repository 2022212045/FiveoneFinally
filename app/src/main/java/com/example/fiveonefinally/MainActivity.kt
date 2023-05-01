package com.example.fiveonefinally

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.EditText

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var taskList: MutableList<String>
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 初始化SharedPreferences对象
        sharedPreferences = getSharedPreferences("task_list", Context.MODE_PRIVATE)

        // 加载任务列表数据
        loadTaskList()

        // 获取RecyclerView并设置LayoutManager
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // 创建适配器并将其设置到RecyclerView上
        myAdapter = MyAdapter(taskList)
        recyclerView.adapter = myAdapter

        // 获取添加按钮并设置点击事件监听器
        val addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener {
            // 获取输入框中的文本
            val inputText = findViewById<EditText>(R.id.inputText)
            val newTask = inputText.text.toString().trim()

            // 将新任务添加到任务列表中
            if (newTask.isNotEmpty()) {
                taskList.add(newTask)
                saveTaskList()
                myAdapter.notifyDataSetChanged()
                inputText.setText("")
            }
        }
    }

    // 从SharedPreferences中加载任务列表数据
    private fun loadTaskList() {
        taskList = mutableListOf()
        val tasksString = sharedPreferences.getString("tasks", "")
        if (!tasksString.isNullOrEmpty()) {
            val tasksArray = tasksString.split(",").toTypedArray()
            taskList.addAll(tasksArray)
        }
    }

    // 将任务列表数据保存到SharedPreferences中
    private fun saveTaskList() {
        val editor = sharedPreferences.edit()
        editor.putString("tasks", taskList.joinToString(","))
        editor.apply()
    }

}