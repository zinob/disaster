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
        get("/{path?}") {
            log.error("Starting")
            var path:String = call.parameters["path"] ?: "None"
            log.error("got path: ${path}")
            log.error("\${jndi:ldap://127.0.0.1:1389/probably_not_vulnerable}")
            call.request.headers.forEach { k, v -> log.error("$k:$v") }

            call.respondText("Hello World! ${path}")
            log.error("Done")
        }
    }
}