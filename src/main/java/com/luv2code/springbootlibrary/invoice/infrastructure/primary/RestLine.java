package com.luv2code.springbootlibrary.invoice.infrastructure.primary;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.luv2code.springbootlibrary.invoice.domain.Line;
import com.luv2code.springbootlibrary.invoice.domain.Quantity;

public class RestLine {

  private final int quantity;
  private final RestFee unitPrice;

  public RestLine(@JsonProperty("quantity") int quantity, @JsonProperty("unitPrice") RestFee unitPrice) {
    this.quantity = quantity;
    this.unitPrice = unitPrice;
  }

  Line toDomain() {
    return new Line(new Quantity(quantity), unitPrice.toDomain());
  }
}
