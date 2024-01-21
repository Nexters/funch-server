package kr.co.funch.api.supports.config.swagger

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.context.annotation.Configuration

@OpenAPIDefinition(
    info =
        Info(
            title = "Funch Server API 명세서",
            description = "-",
            version = "v1",
        ),
)
@Configuration
class SwaggerConfig
