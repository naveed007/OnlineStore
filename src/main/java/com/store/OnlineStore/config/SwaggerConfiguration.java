package com.store.OnlineStore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author naveed.
 *
 */
@Configuration
public class SwaggerConfiguration {

  /**
   * swagger configuration.
   *
   * @return swagger.
   */
  @Bean
  public Docket swagger() {
    return new Docket(DocumentationType.SWAGGER_2).directModelSubstitute(LocalDate.class, java.sql.Date.class)
        .directModelSubstitute(LocalTime.class, String.class).apiInfo(apiInfo()).select()
        .apis(RequestHandlerSelectors.basePackage("com.store")).build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("My Store").description("online store").version("1.0").build();
  }

}
