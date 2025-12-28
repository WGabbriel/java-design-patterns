package com.wgabbriel.dio.store.payment;

public class CreditCardPayment implements Payment {

  @Override
  public void pay(double amount) {
    System.out.println("Paid with credit card: " + amount);
  }

}