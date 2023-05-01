package com.example.fiveonefinally

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val taskList = mutableListOf<Task>() // 任务列表

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 设置RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this) // 使用线性布局管理器
        val adapter = TaskAdapter(taskList) // 创建适配器
        recyclerView.adapter = adapter // 设置适配器

        // 监听添加按钮
        val addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener {
            val inputText = findViewById<EditText>(R.id.inputText)
            val description = inputText.text.toString().trim() // 获取输入框中的文本
            if (description.isNotEmpty()) { // 如果文本不为空
                val task = Task(description) // 创建新的Task对象
                taskList.add(task) // 将Task对象添加到列表中
                adapter.notifyDataSetChanged() // 更新适配器
                inputText.setText("") // 清空输入框
            }
        }
    }

    // 定义一个ViewHolder类来绑定任务视图
    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(task: Task) {
            itemView.findViewById<TextView>(R.id.descriptionTextView).text = task.description
        }
    }

    // 定义一个适配器类
    inner class TaskAdapter(private val taskList: List<Task>) :
        RecyclerView.Adapter<TaskViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.task_item, parent, false)
            return TaskViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
            holder.bind(taskList[position])
        }

        override fun getItemCount(): Int {
            return taskList.size
        }
    }
}