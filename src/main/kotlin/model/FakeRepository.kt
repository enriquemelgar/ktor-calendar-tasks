package com.emelgar.model

import com.emelgar.model.TaskRepository

class FakeRepository : TaskRepository {
    private val tasks =
        mutableListOf<Task>(
            Task("Fantasias de lo nuevo", "Ray Bradbury storyteller book", Priority.Medium),
        )

    override suspend fun allTasks(): List<Task> = tasks

    override suspend fun tasksByPriority(priority: Priority): List<Task> = tasks.filter { it.priority == priority }

    override suspend fun taskByName(name: String): Task? = tasks.find { it.name == name }

    override suspend fun addTask(task: Task) {
        tasks.add(task)
    }

    override suspend fun removeTask(name: String): Boolean = tasks.removeIf { it.name == name }
}
