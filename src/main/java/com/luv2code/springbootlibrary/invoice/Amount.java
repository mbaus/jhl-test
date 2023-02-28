package com.luv2code.springbootlibrary.invoice;

import com.luv2code.springbootlibrary.error.domain.Assert;
import java.math.BigDecimal;

public record Amount(BigDecimal amount) {
  public static final Amount ZERO = new Amount(BigDecimal.ZERO);

  public Amount {
    Assert.field("amount", amount).notNull().min(0);
  }

  public Amount times(Quantity quantity) {
    Assert.notNull("quantity", quantity);

    return new Amount(amount.multiply(new BigDecimal(quantity.get())));
  }

  public Amount add(Amount other) {
    Assert.notNull("other", other);

    return new Amount(amount().add(other.amount));
  }
}
