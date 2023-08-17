package com.example.prioritezmekotlin.ui.fragments.edit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.core.view.forEach
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.prioritezmekotlin.R
import com.example.prioritezmekotlin.data.db.Priority
import com.example.prioritezmekotlin.data.db.Task
import com.example.prioritezmekotlin.databinding.FragmentTaskListBinding
import com.example.prioritezmekotlin.databinding.FragmentTaskUpdateBinding
import com.example.prioritezmekotlin.ui.fragments.add.TaskAddFragmentDirections
import com.example.prioritezmekotlin.viewmodel.TaskViewModel

class TaskUpdateFragment : Fragment() {

    private lateinit var binding: FragmentTaskUpdateBinding

    private val viewModel: TaskViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskUpdateBinding.inflate(inflater)

        var enabled = true

        val id = arguments?.getInt("task_id") ?: 0

        val task = viewModel.getTask(id)

        binding.apply {
            title.setText(task.title)
            description.setText(task.description)
            setRadio(task.priority)
            checkbox.isChecked = task.isDone

            checkbox.setOnClickListener {
                enabled = !enabled
                radio.forEach { (it as RadioButton).isEnabled = enabled }
                if (!enabled) radioDone.isChecked = true
            }

            update.setOnClickListener {
                val title = title.text.toString()
                val description = description.text.toString()

                if ("$title$description".isNotEmpty()){

                    viewModel.updateTask(
                        task.copy(
                        title = title,
                        description = description,
                        isDone = checkbox.isChecked,
                        priority = getPriority()
                        )
                    )
                    val action = TaskUpdateFragmentDirections.actionTaskUpdateFragmentToTaskListFragment()
                    Navigation.findNavController(requireView()).navigate(action)
                }
            }

            back.setOnClickListener {
                val action = TaskUpdateFragmentDirections.actionTaskUpdateFragmentToTaskListFragment()
                Navigation.findNavController(requireView()).navigate(action)
            }

            delete.setOnClickListener {
                viewModel.deleteTask(task)
                val action = TaskUpdateFragmentDirections.actionTaskUpdateFragmentToTaskListFragment()
                Navigation.findNavController(requireView()).navigate(action)
            }
        }

        return binding.root
    }

    private fun setRadio(priority: Priority){
        when(priority){
            Priority.WYSOKI -> binding.radioHigh.isChecked = true
            Priority.NORMALNY -> binding.radioNormal.isChecked = true
            Priority.NISKI -> binding.radioLow.isChecked = true
            else -> binding.radioDone.isChecked = true
        }
    }

    private fun getPriority(): Priority{
        return when(binding.radio.checkedRadioButtonId){
            binding.radioHigh.id -> Priority.WYSOKI
            binding.radioNormal.id -> Priority.NORMALNY
            binding.radioLow.id -> Priority.NISKI
            else -> Priority.WYKONANY
        }
    }
}