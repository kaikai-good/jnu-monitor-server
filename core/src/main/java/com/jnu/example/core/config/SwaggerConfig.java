package com.jnu.example.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;


/**
 *  @Author: zy
 *  @Date: 2020/4/14 22:51
 *  @Description: swagger配置
 *  创建该API的基本信息（这些基本信息会展现在文档页面中）
 *  访问地址：http://127.0.0.1:9001/swagger-ui.html
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.application.version: V1.0}")
    private String version;

    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title(applicationName)
                        .version(version)
                        .build()
                )
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jnu.example")) // 注意修改此处的包名
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    /*
     *   验证
     */
    private List<ApiKey> securitySchemes() {
        return Collections.singletonList(new ApiKey("token", "Authorization", "header"));
    }

    /*
     * 指定需要授权的接口
     */
    private List<SecurityContext> securityContexts() {
        //过滤要验证的路径
        return Collections.singletonList(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build());
    }

    /*
     * 增加全局认证
     */
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope[] authorizationScopes = {new AuthorizationScope("global", "accessEverything")};
        return Collections.singletonList(new SecurityReference("token", authorizationScopes));
    }
}
