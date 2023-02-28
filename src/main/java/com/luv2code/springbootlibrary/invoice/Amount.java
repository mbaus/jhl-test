package com.luv2code.springbootlibrary.invoice;

import com.luv2code.springbootlibrary.error.domain.Assert;
import java.math.BigDecimal;

public record Amount(BigDecimal amount) {
  public Amount {
    Assert.field("amount", amount).notNull().min(0);
  }
}
