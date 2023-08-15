package com.example.prioritezmekotlin.data.repository

import android.app.Application
import com.example.prioritezmekotlin.data.db.Task
import com.example.prioritezmekotlin.data.db.TaskDatabase

class TaskRepository(private val application: Application) {
    private val db = TaskDatabase.getDatabase(application)
    private val dao = db.taskDao()

    fun getTasks() = dao.getTasks()
    suspend fun insertTask(task: Task) = dao.insertTask(task)
    suspend fun insertAllTasks(tasks: List<Task>) = dao.insertAllTasks(tasks)
    suspend fun deleteTask(task: Task) = dao.deleteTask(task)
    suspend fun updateTask(task: Task) = dao.updateTask(task)
    suspend fun deleteAll() = dao.deleteAll()
}