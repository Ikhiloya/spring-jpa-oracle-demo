package com.loya.springjpaoracledemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-jpa-oracle-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-17
 * Time: 18:34
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /*
     * Docket bean in a Spring Boot configuration to configure Swagger 2 for the
     * application. A Springfox Docket instance provides the primary API
     * configuration with sensible defaults and convenience methods for
     * configuration
     */
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.loya.springjpaoracledemo"))
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        Contact contact = new Contact("Hendi Santika", "http://hendisantika.wordpress.com", "hendisantika@gmail.com");
        return new ApiInfoBuilder()
                .title("Spring Boot Restful Webservice Demo")
                .description("Spring Boot Restful Webservice Demo")
                .version("1.0.0")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .contact(contact)
                .build();
    }

}