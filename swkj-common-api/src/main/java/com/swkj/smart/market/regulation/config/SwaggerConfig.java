package com.swkj.smart.market.regulation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 81509
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket sysmanageApi() {
        List<Parameter> parameters = getParameters();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(hyApiInfo())
                .groupName("系统管理")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.swkj.smart.market.regulation.sysmanage.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .globalOperationParameters(parameters);
    }
    
    @Bean
    public Docket diningApi(){
        List<Parameter> parameters = getParameters();
    
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(ylyApiInfo())
                .groupName("农村集中用餐管理")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.swkj.smart.market.regulation.dining.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .globalOperationParameters(parameters);
    }
    
    @Bean
    public Docket licenseApi(){
        List<Parameter> parameters = getParameters();
    
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(ylyApiInfo())
                .groupName("证照有效期管理")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.swkj.smart.market.regulation.license.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .globalOperationParameters(parameters);
    }
    @Bean
    public Docket equipmentApi(){
        List<Parameter> parameters = getParameters();
        
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(swpApiInfo())
                .groupName("特种设备管理")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.swkj.smart.market.regulation.equipment.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .globalOperationParameters(parameters);
    }
    
    private List<Parameter> getParameters() {
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<Parameter>();
        parameterBuilder.name("token").description("令牌")
                .modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        parameters.add(parameterBuilder.build());
        return parameters;
    }

    private ApiInfo hyApiInfo() {
        return new ApiInfoBuilder()
                .title("市场智慧监管平台")
                .contact(new Contact("胡阳","http://localhost:8080",""))
                .version("1.0")
                .build();
    }
    
    private ApiInfo ylyApiInfo(){
        return new ApiInfoBuilder()
                .title("市场智慧监管平台")
                .contact(new Contact("杨路遥","http://localhost:8080",""))
                .version("1.0")
                .build();
    }
    private ApiInfo swpApiInfo(){
        return new ApiInfoBuilder()
                .title("市场智慧监管平台")
                .contact(new Contact("宋伟鹏","http://localhost:8080",""))
                .version("1.0")
                .build();
    }
    private List<ApiKey> securitySchemes() {
        List<ApiKey> apiKeys = new ArrayList<>();
        apiKeys.add(new ApiKey("Authorization", "Authorization", "header"));
        return apiKeys;
    }

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("^(?!auth).*$")).build());
        return securityContexts;
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }
    
 
}
