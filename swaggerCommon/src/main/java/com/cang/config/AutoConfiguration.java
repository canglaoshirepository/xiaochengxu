package com.cang.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration("swaggerConfig")
public class AutoConfiguration {
    @Bean //作为bean纳入spring容器
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .build();
    }
    private ApiInfo apiInfo(){
        return  new ApiInfoBuilder()
                .title("API接口文档")
                .description("API接口文档，及相关接口的说明")
                .version("1.0.0")
                .build();
    }
}
