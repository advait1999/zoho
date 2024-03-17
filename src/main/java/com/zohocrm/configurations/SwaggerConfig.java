package com.zohocrm.configurations;

import com.zohocrm.properties.SwaggerProperties;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//http://localhost:8080/swagger-ui/index.html#/
@Configuration
@OpenAPIDefinition
@RequiredArgsConstructor
public class SwaggerConfig {
    private final SwaggerProperties swaggerProperties;

    @Bean
    public GroupedOpenApi controllerApi(){
        return GroupedOpenApi.builder()
                .group(swaggerProperties.getGroup())
                .packagesToScan(swaggerProperties.getPackagesToScan())
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI().info(apiInfo());
    }

    private Info apiInfo(){
        return new Info()
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .version(swaggerProperties.getVersion());
    }

}
