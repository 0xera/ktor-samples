package io.ktor.samples.post

import io.ktor.application.*
import io.ktor.content.*
import io.ktor.features.*
import io.ktor.html.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.html.*

fun Application.main() {
    install(DefaultHeaders)
    install(CallLogging)
    install(Routing)  {
        get("/"){
            call.respondHtml {
                head {
                    title { +"Ktor: post" }
                }
                body {
                    p {
                        +"Hello from Ktor Post sample application "
                        +"running under ${System.getProperty("java.version")}"
                    }
                    p {
                        +"File upload"
                    }
                    form("/form", encType = FormEncType.multipartFormData, method = FormMethod.post) {
                        acceptCharset = "utf-8"
                        p {
                            label { +"Text field: " }
                            textInput { name = "textField" }
                        }
                        p {
                            label { +"File field: " }
                            fileInput { name = "fileField" }
                        }
                        p {
                            submitInput { value = "send" }
                        }
                    }
                }
            }
        }

        post("/form") {
            val multipart = call.receiveMultipart()
            call.respondWrite {
                if (!call.request.isMultipart()) {
                    appendln("Not a multipart request")
                } else {
                    while (true) {
                        val part = multipart.readPart() ?: break
                        when (part) {
                            is PartData.FormItem ->
                                appendln("FormItem: ${part.partName} = ${part.value}")
                            is PartData.FileItem ->
                                appendln("FileItem: ${part.partName} -> ${part.originalFileName} of ${part.contentType}")
                        }
                        part.dispose()
                    }
                }
            }
        }
    }
}
