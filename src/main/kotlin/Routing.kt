package com.emelgar

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.http.ContentType
import com.emelgar.model.TaskRepository
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.*
import io.ktor.serialization.kotlinx.json.*

fun Application.configureRouting() {
  routing {
    get("/") {
      call.respondText("Hello, world!", ContentType.parse("text/html"))
    }
  }
}

fun Application.configureSerialization(repository: TaskRepository) {
  install(ContentNegotiation) {
    json()
  }
  routing {
    route("/tasks") {
      get {
        val tasks = repository.allTasks()
        call.respond(tasks)
      }
    }
  }
}
