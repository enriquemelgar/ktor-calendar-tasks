package emelgar.db

import io.ktor.server.application.Application
import org.jetbrains.exposed.sql.Database

fun Application.configureDatabases() {
    Database.connect("jdbc:postgresql://localhost:5432/taskdb", user = "postgres", password = "password")
}
