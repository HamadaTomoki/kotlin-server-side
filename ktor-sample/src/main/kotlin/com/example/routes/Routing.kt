package com.example.routes

import com.example.modules.Customer
import com.example.modules.customerStorage
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*


fun Route.customerRouting() {
    route("/customer") {

        // curl http://0.0.0.0:8080/customer -w '\nStatuscode: %{http_code}\n'
        get {
            if (customerStorage.isNotEmpty()) {
                call.respond(customerStorage)
            } else {
                call.respondText("No customers found", status = HttpStatusCode.NotFound)
            }
        }

        // curl http://0.0.0.0:8080/customer/001 -w '\nStatuscode: %{http_code}\n'
        get("{id}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing or malformed id",
                status = HttpStatusCode.BadRequest
            )
            val customer = customerStorage.find { it.id == id } ?: return@get call.respondText(
                "No customer with id $id",
                status = HttpStatusCode.NotFound
            )
            call.respond(customer)
        }

        // curl -X POST http://0.0.0.0:8080/customer -w '\nStatuscode: %{http_code}\n'
        post {
            val customer = call.receive<Customer>()
            customerStorage.add(customer)
            call.respondText("Customer stored correctly", status = HttpStatusCode.Created)
        }

        // curl -X DELETE http://0.0.0.0:8080/customer/001 -w '\nStatuscode: %{http_code}\n'
        delete("{id}") {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            if (customerStorage.removeIf { it.id == id }) {
                call.respondText("Customer removed correctly", status = HttpStatusCode.Accepted)
            } else {
                call.respondText("Not Found", status = HttpStatusCode.NotFound)
            }
        }
    }
}

fun Application.registerCustomerRoutes() {
    routing {
        customerRouting()
    }
}
