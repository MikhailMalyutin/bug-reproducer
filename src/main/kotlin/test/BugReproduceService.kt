package test

import com.fasterxml.jackson.annotation.JsonProperty
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse
import org.jboss.resteasy.reactive.PartType
import org.jboss.resteasy.reactive.RestForm
import java.io.File
import java.io.InputStream
import java.util.*
import javax.annotation.security.RolesAllowed
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.WebApplicationException
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response


class FileForm {
    @RestForm("fileName")
    @PartType(MediaType.TEXT_PLAIN)
    var fileName: String = ""

    @RestForm("file")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    @field:Schema(type= SchemaType.STRING, description = "Input file", format = "binary")
    lateinit var fileStream: File
}

@Path("/")
class BugReproduceService {
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("data")
    @Operation(description = "Создание данных", summary = "Создание данных")
    @APIResponse(responseCode = "200", content = [Content(
        mediaType = MediaType.APPLICATION_JSON
    )])
    fun createData(
        file: FileForm
    ) {
        TODO()
    }
}