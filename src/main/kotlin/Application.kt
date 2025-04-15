package com.emelgar

import io.ktor.server.application.*
import com.emelgar.model.FakeRepository

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization(FakeRepository())
    configureRouting()
}
