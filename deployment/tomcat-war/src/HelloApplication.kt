package io.ktor.samples.hello

import io.ktor.application.*
import io.ktor.html.*
import io.ktor.routing.*
import kotlinx.html.*

fun Application.main() {
    install(Routing) {
        get("/") {
            call.respondHtml {
                head {
                    title { +"Ktor: tomcat-war" }
                }
                body {
                    p {
                        +"Hello from Ktor Tomcat WAR deployment sample application "
                        +"running under ${System.getProperty("java.version")}"
                    }
                }
            }
        }
    }
}
