package com.wgabbriel.dio.store.facade;

import org.springframework.stereotype.Service;

import com.wgabbriel.dio.store.config.AppConfig;
import com.wgabbriel.dio.store.payment.Payment;
import com.wgabbriel.dio.store.payment.PaymentFactory;
import com.wgabbriel.dio.store.shipping.ShippingStrategy;

@Service
public class OrderFacade {

  private final PaymentFactory paymentFactory;
  private final AppConfig appConfig;

  public OrderFacade(PaymentFactory paymentFactory, AppConfig appConfig) {
    this.paymentFactory = paymentFactory;
    this.appConfig = appConfig;
  }

  public String closeOrder(double value,
      String paymentType,
      ShippingStrategy shippingStrategy) {

    double shipping = shippingStrategy.calculate(value);
    double total = value + shipping;

    Payment payment = paymentFactory.createPayment(paymentType);
    payment.pay(total);

    String message = String.format("""
        === %s ===
        Order received with total value of $%.2f
        """,
        appConfig.getStoreName(), total);

    return message;
  }
}
