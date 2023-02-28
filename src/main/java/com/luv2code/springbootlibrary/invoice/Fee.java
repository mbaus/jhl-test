package com.luv2code.springbootlibrary.invoice;

import com.luv2code.springbootlibrary.error.domain.Assert;

public record Fee(Amount amount, Currency currency) {
  public Fee {
    Assert.notNull("amount", amount);
    Assert.notNull("currency", currency);
  }
  //TODO
}
