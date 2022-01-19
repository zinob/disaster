package se.zensum.disaster.plugins

import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import org.apache.logging.log4j.kotlin.logger

fun Application.configureRouting() {
    val log = logger("Main")
    routing {
        route("/{path...}" ) {
            handle {
                log.error("Starting")
                var path: String = call.parameters["path"] ?: "None"
                log.error("got path: ${path}")
                log.error("got full_path: ${call.request.path()}")
                log.error( "got body: ${call.receiveText()}")
                call.request.headers.forEach { k, v -> log.error("$k:$v") }
                call.respondText("Hello World! ${path}")
            }
        }
    }
}