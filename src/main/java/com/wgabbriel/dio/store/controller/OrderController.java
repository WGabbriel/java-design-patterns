package com.wgabbriel.dio.store.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wgabbriel.dio.store.facade.OrderFacade;
import com.wgabbriel.dio.store.shipping.ExpressShipping;
import com.wgabbriel.dio.store.shipping.NormalShipping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/orders")
@Tag(name = "Pedidos", description = "API para gerenciamento de pedidos")
public class OrderController {

  private final OrderFacade orderFacade;
  private final NormalShipping normal;
  private final ExpressShipping express;

  public OrderController(OrderFacade orderFacade, NormalShipping normal, ExpressShipping express) {
    this.orderFacade = orderFacade;
    this.normal = normal;
    this.express = express;
  }

  @PostMapping(produces = "text/plain")
  @Operation(summary = "Criar novo pedido", description = "Processa um novo pedido aplicando o padrão Facade para coordenar pagamento e frete")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Pedido criado com sucesso", content = @Content(mediaType = "text/plain", schema = @Schema(type = "string", example = "=== Store Spring ===\nOrder received with total value of $110.00"))),
  })
  public String createOrder(
      @Parameter(description = "Valor total do pedido", example = "150.50", required = true) @RequestParam double value,
      @Parameter(description = "Método de pagamento", example = "PIX", required = true) @RequestParam String payment,
      @Parameter(description = "Tipo de frete", example = "express", schema = @Schema(allowableValues = { "normal",
          "express" })) @RequestParam(defaultValue = "normal") String shipping) {

    return switch (shipping.toLowerCase()) {
      case "express" -> orderFacade.closeOrder(value, payment, express);
      default -> orderFacade.closeOrder(value, payment, normal);
    };
  }
}
