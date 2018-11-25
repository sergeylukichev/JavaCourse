package com.telran.project.tracker.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {


    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .globalOperationParameters(getHeader())
                .apiInfo(apiInfo());
    }

    private List<Parameter> getHeader() {
        return Arrays.asList(new ParameterBuilder()
                .name("Authorization")
                .required(false)
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .defaultValue("")
                .build());
    }


    private ApiInfo apiInfo() {
        return ApiInfo.DEFAULT;
    }

    @Bean
    public springfox.documentation.swagger.web.SecurityConfiguration security() {
        //Setting swagger to use authorization header when typing appkey in the top of the swagger screen
        return new SecurityConfiguration(
                null,
                null,
                null,
                null,
                "",
                ApiKeyVehicle.HEADER,
                "Authorization",
                ",");
    }

    @Bean
    public UiConfiguration uiConfig() {
        return UiConfiguration.DEFAULT;
    }
}
