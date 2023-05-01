package com.example.fiveonefinally

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// 定义ViewHolder类来绑定视图
class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(task: String, adapter: MyAdapter) {
        itemView.findViewById<TextView>(R.id.taskTextView).text = task

        // 获取删除按钮并设置点击事件监听器
        val deleteButton = itemView.findViewById<Button>(R.id.deleteButton)
        deleteButton.setOnClickListener {
            // 从任务列表中删除指定的任务并更新适配器
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                adapter.notifyItemRemoved(position)
            }
        }
    }
}