package com.emelgar.model

import com.emelgar.model.Priority
import com.emelgar.model.Task

interface TaskRepository {
    suspend fun allTasks(): List<Task>

    suspend fun tasksByPriority(priority: Priority): List<Task>

    suspend fun taskByName(name: String): Task?

    suspend fun addTask(task: Task)

    suspend fun removeTask(name: String): Boolean
}
