package com.wgabbriel.dio.store.shipping;

public interface ShippingStrategy {
    double calculate(double orderValue);
}
