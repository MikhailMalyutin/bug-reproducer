package test

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse
import org.jboss.resteasy.reactive.PartType
import org.jboss.resteasy.reactive.RestForm
import java.io.File
import java.io.InputStream
import java.util.*
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.core.MediaType


class FileForm {
    @RestForm("fileName")
    @PartType(MediaType.TEXT_PLAIN)
    var fileName: String = ""

    @RestForm("file")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    @field:Schema(type= SchemaType.STRING, implementation = String::class, description = "Input file", format = "binary")
    lateinit var fileStream: File
}

class FileForm1 {
    @RestForm("fileName")
    @PartType(MediaType.TEXT_PLAIN)
    var fileName: String = ""

    @RestForm("file")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    @field:Schema(type= SchemaType.STRING, description = "Input file", format = "binary")
    lateinit var fileStream: InputStream
}

@Path("/")
class BugReproduceService {
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("data")
    @APIResponse(responseCode = "200", content = [Content(
        mediaType = MediaType.APPLICATION_JSON
    )])
    fun createData(
        file: FileForm
    ) {
        TODO()
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("upload1")
    @APIResponse(responseCode = "200", content = [Content(
        mediaType = MediaType.APPLICATION_JSON
    )])
    fun createData(
        file: FileForm1
    ) {
        TODO()
    }
}