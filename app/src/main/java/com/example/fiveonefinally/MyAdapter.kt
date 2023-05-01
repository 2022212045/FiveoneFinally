package com.example.fiveonefinally

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

// 定义适配器类
class MyAdapter(private val taskList: MutableList<String>) :
    RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // 创建视图并返回ViewHolder对象
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // 获取指定位置的任务并绑定到ViewHolder上
        val task = taskList[position]
        holder.bind(task, this)
    }

    override fun getItemCount(): Int {
        // 返回任务列表大小
        return taskList.size
    }
}