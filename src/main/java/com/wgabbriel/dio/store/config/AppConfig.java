package com.wgabbriel.dio.store.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Store API", version = "1.0", description = "API de loja demonstrando padrões de design"))
public class AppConfig {

  private final String storeName = "Store Spring";

  public String getStoreName() {
    return storeName;
  }
}
