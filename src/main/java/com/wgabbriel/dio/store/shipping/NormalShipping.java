package com.wgabbriel.dio.store.shipping;

import org.springframework.stereotype.Component;

@Component
public class NormalShipping implements ShippingStrategy {

  @Override
  public double calculate(double orderValue) {
    return 10.0;
  }
}
