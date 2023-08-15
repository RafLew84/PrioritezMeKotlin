package com.example.prioritezmekotlin.ui.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.prioritezmekotlin.R
import com.example.prioritezmekotlin.databinding.FragmentTaskListBinding
import com.example.prioritezmekotlin.viewmodel.TaskViewModel

class TaskListFragment : Fragment() {

    private lateinit var binding: FragmentTaskListBinding

    private val viewModel: TaskViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskListBinding.inflate(inflater)
        return binding.root
    }
}