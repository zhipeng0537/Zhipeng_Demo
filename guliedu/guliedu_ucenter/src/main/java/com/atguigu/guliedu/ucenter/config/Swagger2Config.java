package com.atguigu.guliedu.ucenter.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("WebApi")
                .apiInfo(webApiInfo())// 调用apiInfo方法,创建一个ApiInfo实例,里面是展示在文档页面信息内容
                .select()
                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();


    }
    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("网站-用户中心微服务API")//大标题
                .description("此文档描述了网站-用户中心微服务API")//详细描述
                .version("1.0")//版本
                .contact(new Contact("LiuZhiPeng","http://atguigu.com","zhipeng0537@Foxmail"))//作者
                .build();
    }

    @Bean
    public Docket adminApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("AdminApi")
                .apiInfo(adminApiInfo())// 调用apiInfo方法,创建一个ApiInfo实例,里面是展示在文档页面信息内容
                .select()
                .paths(Predicates.and(PathSelectors.regex("/admin/.*")))

                .build();


    }
    private ApiInfo adminApiInfo() {
        return new ApiInfoBuilder()
                .title("后台管理系统-用户中心微服务API")//大标题
                .description("此文档描述了后台管理系统-用户中心微服务API")//详细描述
                .version("1.0")//版本
                .contact(new Contact("LiuZhiPeng","http://atguigu.com","zhipeng0537@Foxmail"))//作者
                .build();
    }


}
