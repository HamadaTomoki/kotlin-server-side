package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module(testing:Boolean = false) {
    install(ContentNegotiation) {
        json()
    }
}
