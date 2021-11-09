package com.example

import com.example.routes.registerCustomerRoutes
import com.example.routes.registerOrderRoutes
import io.ktor.server.netty.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        json()
    }
    registerCustomerRoutes()
    registerOrderRoutes()
}
