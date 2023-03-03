package com.luv2code.springbootlibrary.dummy.domain.order;

import com.luv2code.springbootlibrary.dummy.domain.Amount;
import com.luv2code.springbootlibrary.error.domain.Assert;

public record BeerOrderLine(OrderedBeer beer, int quantity) {
  public BeerOrderLine {
    Assert.notNull("beer", beer);
    Assert.field("quantity", quantity).min(1);
  }

  Amount amount() {
    return beer().unitPrice().times(quantity());
  }
}
