package com.wgabbriel.dio.store.config;

import org.springframework.stereotype.Component;

@Component
public class AppConfig {

  private final String storeName = "Store Spring";

  public String getStoreName() {
    return storeName;
  }
}
