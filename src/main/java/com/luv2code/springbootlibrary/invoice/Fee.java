package com.luv2code.springbootlibrary.invoice;

import com.luv2code.springbootlibrary.error.domain.Assert;
import java.util.function.BinaryOperator;

public record Fee(Amount amount, Currency currency) {
  public static final Fee ZERO = new Fee(Amount.ZERO, Currency.EURO);

  public Fee {
    Assert.notNull("amount", amount);
    Assert.notNull("currency", currency);
  }

  public Fee times(Quantity quantity) {
    Assert.notNull("quantity", quantity);

    return new Fee(amount.times(quantity), currency);
  }

  public Fee add(Fee other) {
    Assert.notNull("other", other);

    return new Fee(amount.add(other.amount), currency);
  }
}
