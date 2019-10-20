package com.fp.easybuy;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@ConfigurationProperties(prefix = "swagger")
@Configuration
@Data
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages = {"com.fp.easybuy.controller"})
public class swagger {

    private String name;
    private String url;
    private String email;
    private String title;
    private String description;
    private String version;

    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact(name, url, email);
        return new ApiInfoBuilder().title(title).description(description).contact(contact).version(version).build();
    }

}
