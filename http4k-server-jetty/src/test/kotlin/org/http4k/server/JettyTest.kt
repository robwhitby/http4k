package org.http4k.server

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.http4k.client.ApacheClient
import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Request.Companion.get
import org.http4k.core.Response.Companion.ok
import org.http4k.routing.by
import org.http4k.routing.routes
import org.junit.After
import org.junit.Before
import org.junit.Test

class JettyTest {
    var server: Http4kServer? = null
    private val client = ApacheClient()

    @Before
    fun before() {
        server = routes(
            GET to "/" by { _: Request -> ok().body("Hello World") },
            GET to "/request-headers" by { request: Request -> ok().body(request.headerValues("foo").joinToString(", ")) }
        ).startServer(Jetty(), block = false)
    }

    @Test
    fun can_use_as_servlet() {
        val client = client
        val response = client(get("http://localhost:8000/"))

        assertThat(response.bodyString(), equalTo("Hello World"))
    }

    @Test
    fun can_handle_multiple_request_headers() {
        val client = client
        val response = client(get("http://localhost:8000/request-headers", listOf("foo" to "one", "foo" to "two", "foo" to "three")))

        assertThat(response.bodyString(), equalTo("one, two, three"))
    }

    @After
    fun after() {
        server?.stop()
    }

}
