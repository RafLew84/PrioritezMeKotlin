package com.example.prioritezmekotlin.ui.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.prioritezmekotlin.R
import com.example.prioritezmekotlin.data.db.Task
import com.example.prioritezmekotlin.databinding.FragmentTaskListBinding
import com.example.prioritezmekotlin.viewmodel.TaskViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class TaskListFragment : Fragment() {

    private lateinit var binding: FragmentTaskListBinding

    private val viewModel: TaskViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskListBinding.inflate(inflater)

        val taskAdapter = TaskAdapter(
            taskComparator = TaskComparator(),
            onPriorityUp = {},
            onPriorityDown = {},
            onTaskDone = {},
            onDelete = {},
            onEdit = {}
        )
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.tasksState.collectLatest{ taskList ->
                    taskAdapter.submitList(taskList)
                }
            }
        }

        binding.recycler.apply {
            adapter = taskAdapter
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }

        return binding.root
    }
}