package com.luv2code.springbootlibrary.invoice;

import java.math.BigDecimal;
import java.util.List;

public final class InvoicesFixture {

  private InvoicesFixture() {}

  public static Invoice invoce() {
    return new Invoice(List.of(firstLine(), secondLine()));
  }

  public static Line firstLine() {
    return line(2, 500);
  }

  public static Line secondLine() {
    return line(1, 400);
  }

  private static Line line(int quantity, int amount) {
    return new Line(new Quantity(quantity), fee(amount));
  }

  public static Fee fee(int amount) {
    return new Fee(amount(amount), Currency.EURO);
  }

  private static Amount amount(int amount) {
    return new Amount(new BigDecimal(amount));
  }
}
