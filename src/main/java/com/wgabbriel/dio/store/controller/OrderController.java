package com.wgabbriel.dio.store.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wgabbriel.dio.store.facade.OrderFacade;
import com.wgabbriel.dio.store.shipping.ExpressShipping;
import com.wgabbriel.dio.store.shipping.NormalShipping;

@RestController
@RequestMapping("/orders")
public class OrderController {

  private final OrderFacade orderFacade;
  private final NormalShipping normal;
  private final ExpressShipping express;

  public OrderController(OrderFacade orderFacade, NormalShipping normal, ExpressShipping express) {
    this.orderFacade = orderFacade;
    this.normal = normal;
    this.express = express;
  }

  @PostMapping
  public String createOrder(@RequestParam double value, @RequestParam String payment,
      @RequestParam(defaultValue = "normal") String shipping) {

    return switch (shipping.toLowerCase()) {
      case "express" -> orderFacade.closeOrder(value, payment, express);
      default -> orderFacade.closeOrder(value, payment, normal);

    };
  }
}
