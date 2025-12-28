package com.wgabbriel.dio.store.payment;

import org.springframework.stereotype.Component;

@Component
public class PaymentFactory {

  public Payment createPayment(String type) {
    return switch (type.toLowerCase()) {
      case "pix" -> new PixPayment();
      case "credit" -> new CreditCardPayment();
      default -> throw new IllegalArgumentException("Unknown payment type: " + type);
    };
  }
}