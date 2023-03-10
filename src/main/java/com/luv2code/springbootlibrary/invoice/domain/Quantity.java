package com.luv2code.springbootlibrary.invoice.domain;

import com.luv2code.springbootlibrary.error.domain.Assert;

public record Quantity(int quantity) {
  public Quantity {
    Assert.field("quantity", quantity).min(0);
  }

  public int get() {
    return quantity();
  }
}
