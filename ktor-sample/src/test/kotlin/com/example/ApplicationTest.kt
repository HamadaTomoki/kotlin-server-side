package com.example

import io.ktor.http.*
import kotlin.test.*
import io.ktor.server.testing.*
import com.example.routes.customerRouting

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ customerRouting() }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Hello World!", response.content)
            }
        }
    }
}
