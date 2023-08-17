package com.example.prioritezmekotlin.ui.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.RadioButton
import androidx.core.view.forEach
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.prioritezmekotlin.data.db.Priority
import com.example.prioritezmekotlin.data.db.Task
import com.example.prioritezmekotlin.databinding.FragmentTaskAddBinding
import com.example.prioritezmekotlin.viewmodel.TaskViewModel

class TaskAddFragment : Fragment() {

    private lateinit var binding: FragmentTaskAddBinding

    private val viewModel: TaskViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskAddBinding.inflate(inflater)

        var enabled = true

        binding.apply {
            radioNormal.isChecked = true
            checkbox.setOnClickListener {
                enabled = !enabled
                radio.forEach { (it as RadioButton).isEnabled = enabled }
                if (!enabled) radioDone.isChecked = true
            }


            save.setOnClickListener {
                val title = title.text.toString()
                val description = description.text.toString()

                if ("$title$description".isNotEmpty()){
                    val task = Task(
                        title = title,
                        description = description,
                        isDone = checkbox.isChecked,
                        priority = getPriority()
                    )
                    viewModel.addTask(task)
                    val action = TaskAddFragmentDirections.actionTaskAddFragmentToTaskListFragment()
                    Navigation.findNavController(requireView()).navigate(action)
                }
            }

            back.setOnClickListener {
                val action = TaskAddFragmentDirections.actionTaskAddFragmentToTaskListFragment()
                Navigation.findNavController(requireView()).navigate(action)
            }
        }

        return binding.root
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