package com.example.prioritezmekotlin.ui.fragments.list


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.prioritezmekotlin.data.db.Task
import com.example.prioritezmekotlin.databinding.RvItemBinding

class TaskAdapter(
    taskComparator: TaskComparator,
    private val onPriorityUp: (Task) -> Unit,
    private val onPriorityDown: (Task) -> Unit,
    private val onTaskDone: (Task) -> Unit,
    private val onDelete: (Task) -> Unit,
    private val onEdit: (Int) -> Unit,
): ListAdapter<Task, TaskViewHolder>(taskComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            binding = RvItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            onPriorityUp = onPriorityUp,
            onPriorityDown = onPriorityDown,
            onTaskDone = onTaskDone,
            onDelete = onDelete,
            onEdit = onEdit
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item = item)
    }

}