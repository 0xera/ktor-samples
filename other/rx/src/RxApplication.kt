package io.ktor.samples.rx

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.reactivex.*
import kotlinx.coroutines.experimental.reactive.*
import java.util.concurrent.*

/**
 * Documentation: https://github.com/Kotlin/kotlinx.coroutines/tree/master/reactive/kotlinx-coroutines-rx2
 */
fun main(args: Array<String>) {
    embeddedServer(Netty, port = 8080) {
        routing {
            get("/") {
                val result = Flowable.range(1, 10)
                    .map { it * it }
                    .delay(300L, TimeUnit.MILLISECONDS)
                    .awaitLast()

                call.respondText("LAST ITEM: $result")
            }
        }
    }.start(wait = true)
}
