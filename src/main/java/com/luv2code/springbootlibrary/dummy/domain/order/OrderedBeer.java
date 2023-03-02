package com.luv2code.springbootlibrary.dummy.domain.order;

import com.luv2code.springbootlibrary.dummy.domain.Amount;
import com.luv2code.springbootlibrary.dummy.domain.BeerId;
import com.luv2code.springbootlibrary.error.domain.Assert;

public record OrderedBeer(BeerId beer, Amount unitPrice) {
  public OrderedBeer {
    Assert.notNull("beer", beer);
    Assert.notNull("unitPrice", unitPrice);
  }
}
