package com.yusufsezer.resources;

import com.yusufsezer.model.ErrorMessage;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        servers = {
            @Server(url = "/jax-rs-example/webapi/",
                    description = "JAX-RS Contact API"
            )
        },
        info = @Info(title = "JAX-RS Contact",
                version = "v1",
                description = "JAX-RS Contact API",
                termsOfService = "N/A",
                contact = @Contact(name = "Yusuf SEZER",
                        url = "http://www.yusufsezer.com",
                        email = "yusufsezer@mail.com"),
                license = @License(name = "MIT",
                        url = "https://opensource.org/licenses/MIT"))
)
@ApiResponse(
        responseCode = "400",
        description = "Bad Request",
        content = @Content(
                schema = @Schema(implementation = ErrorMessage.class)
        )
)
@ApiResponse(
        responseCode = "404",
        description = "Not Found",
        content = @Content(
                schema = @Schema(implementation = ErrorMessage.class)
        )
)
@ApiResponse(
        responseCode = "500",
        description = "Internal Server Error",
        content = @Content(
                schema = @Schema(implementation = ErrorMessage.class)
        )
)
public class Metadata {
}
