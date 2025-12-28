package com.wgabbriel.dio.store.shipping;

import org.springframework.stereotype.Component;

@Component()
public class ExpressShipping implements ShippingStrategy {

  @Override
  public double calculate(double orderValue) {
    return 25.0;
  }
}
