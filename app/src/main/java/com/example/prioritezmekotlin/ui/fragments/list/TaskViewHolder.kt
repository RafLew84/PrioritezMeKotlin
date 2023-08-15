package com.example.prioritezmekotlin.ui.fragments.list

import android.graphics.Color
import android.graphics.PorterDuff
import androidx.recyclerview.widget.RecyclerView
import com.example.prioritezmekotlin.data.db.Priority
import com.example.prioritezmekotlin.data.db.Task
import com.example.prioritezmekotlin.databinding.RvItemBinding

class TaskViewHolder(
    private val binding: RvItemBinding,
    private val onPriorityUp: (Task) -> Unit,
    private val onPriorityDown: (Task) -> Unit,
    private val onTaskDone: (Task) -> Unit,
    private val onDelete: (Task) -> Unit,
    private val onEdit: (Int) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Task){
        binding.apply {
            title.text = item.title
            description.text = item.description
            priorityIcon.setColorFilter(priorityColor(item).toArgb(), PorterDuff.Mode.SRC_IN)
            priorityUp.setOnClickListener { onPriorityUp(item) }
            priorityDown.setOnClickListener { onPriorityDown(item) }
            done.setOnClickListener { onTaskDone(item) }
            delete.setOnClickListener { onDelete(item) }
            edit.setOnClickListener { onEdit(item.id) }
        }
    }

    private fun priorityColor(task: Task): Color {
        return when(task.priority) {
            Priority.WYSOKI -> Color.valueOf(Color.RED)
            Priority.NISKI -> Color.valueOf(Color.BLUE)
            Priority.NORMALNY -> Color.valueOf(Color.GREEN)
            else -> Color.valueOf(128f, 203f, 196f)
        }
    }
}