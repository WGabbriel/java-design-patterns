package com.wgabbriel.dio.store.payment;

public class PixPayment implements Payment {

  @Override
  public void pay(double amount) {
    System.out.println("Paid with Pix: " + amount);
  }
}