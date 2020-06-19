package com.limeng.swagger.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * 配置Swagger
 * 2020/6/18
 */

@EnableSwagger2  //开启Swagger
@Configuration  //定义为配置类
public class swaggerConfig {

    @Bean //配置docket以配置Swagger具体参数
    public Docket docket(Environment environment) {
        // 设置要显示swagger的环境
        Profiles of = Profiles.of("dev", "test");
        // 判断当前是否处于该环境
        // 通过 enable() 接收此参数判断是否要显示
        boolean b = environment.acceptsProfiles(of);


        return new Docket(DocumentationType.SWAGGER_2)
                //配置如何修改swagger文档基本信息？？
                .apiInfo(apiInfo())

                //配置如何扫描接口？？
                //basePackage()包路径配置扫描接口
                //none() // 不扫描接口
                //any() // 扫描所有，项目中的所有接口都会被扫描到
                //withMethodAnnotation()通过 方法上的注解 扫描，如withMethodAnnotation(GetMapping.class)只扫描get请求
                //withClassAnnotation()通过 类上的注解 扫描，如withClassAnnotation(controller.class)只扫描有controller注解的类中的接口
                .select().apis(RequestHandlerSelectors.basePackage("com.limeng.swagger.controller"))

                //配置如何通过path过滤扫描？？
                //any() 任何请求都扫描
                //none() 任何请求都不扫描
                //regex(final String pathRegex)通过正则表达式控制
                //ant(final String antPattern)通过ant()控制
                .paths(PathSelectors.ant("/limeng/**")) //配置如何通过path过滤,即这里只扫描请求以/kuang开头的接口
                .build()

                .enable(b) //配置是否启用Swagger，如果是false，在浏览器将无法访问

                ;
    }

    //配置多个组，每个组对应不同的用户，信息也不同
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("张三");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("李四");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("王五");
    }

    //通过apiInfo()属性配置文档信息
    private ApiInfo apiInfo() {
        Contact contact = new Contact("李萌", "http://baidu.com/联系人访问链接", "2467719400@qq.com");
        return new ApiInfo(
                "凌志高科项目API接口文档", // 标题
                "学习演示如何配置Swagger", // 描述
                "v1.0", // 版本
                "http://terms.service.url/组织链接", // 组织链接
                contact, // 联系人信息
                "Apach 2.0 许可", // 许可
                "许可链接", // 许可连接
                new ArrayList<>()// 扩展
        );
    }



}
