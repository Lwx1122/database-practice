package com.liwx.eureka.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.PathProvider;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfig {
    @Value("${spring.application.name}")
    String name;
//    @Value("${spring.profiles.active}")
//    String active;

    private List<SecurityContext> securityContexts() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> security = Collections.singletonList(
                new SecurityReference("Authorization", authorizationScopes));
        return Collections.singletonList(
                SecurityContext.builder()
                        .securityReferences(security)
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build());
    }

    private List<SecurityScheme> securitySchemes() {
        return Collections.singletonList(new ApiKey("Authorization"
                , "Authorization", "header"));
    }


    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("www.liwx"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .pathProvider(new PathProvider() {
                    @Override
                    public String getOperationPath(String operationPath) {
                        String path = String.format("/%s%s", name, operationPath);
                      /* String path = operationPath;
                        if (!active.equals("local"))
                            path = String.format("/%s%s", name, operationPath);*/
                        return path;
                    }

                    @Override
                    public String getResourceListingPath(String groupName, String apiDeclaration) {
                        return groupName;
                    }
                });
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("file api service")
                .description("文件接口")
                .version("1.0")
                .build();
    }
}
