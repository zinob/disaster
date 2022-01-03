package se.zensum.disaster

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import se.zensum.disaster.plugins.*

fun main() {
    embeddedServer(Netty, port = 8365, host = "0.0.0.0") {
        configureRouting()
    }.start(wait = true)
    println("Done")
}
