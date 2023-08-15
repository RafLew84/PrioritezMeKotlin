package com.example.prioritezmekotlin.ui.fragments.list

import androidx.recyclerview.widget.DiffUtil
import com.example.prioritezmekotlin.data.db.Task

class TaskComparator : DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return newItem === oldItem
    }

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        return newItem == oldItem
    }
}