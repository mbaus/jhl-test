package com.luv2code.springbootlibrary.dummy.domain.beer;

import com.luv2code.springbootlibrary.dummy.domain.Amount;
import com.luv2code.springbootlibrary.dummy.domain.BeerId;
import com.luv2code.springbootlibrary.error.domain.Assert;

public record BeerToCreate(BeerName name, Amount unitPrice) {
  public BeerToCreate {
    Assert.notNull("name", name);
    Assert.notNull("unitPrice", unitPrice);
  }

  public Beer create() {
    return Beer.builder().id(BeerId.newId()).name(name()).unitPrice(unitPrice()).sellingState(BeerSellingState.SOLD).build();
  }
}
