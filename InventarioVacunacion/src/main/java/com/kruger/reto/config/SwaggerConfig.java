package com.kruger.reto.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kruger.reto.controller"))
                .build().apiInfo(apiEndPointInfo());
    }

    private ApiInfo apiEndPointInfo(){

        return new ApiInfoBuilder().title("API RETO KRUGER INVENTARIO DE VACUNACIÓN DE EMPLEADOS")
                .description("Servicios para ingresar datos del empleado y la información de su vacunación")
                .build();

    }
}
