package com.luv2code.springbootlibrary.invoice;

import com.luv2code.springbootlibrary.error.domain.Assert;

public record Quantity(int quantity) {
  public Quantity {
    Assert.field("quantity", quantity).min(0);
  }
}
