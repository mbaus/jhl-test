package com.luv2code.springbootlibrary.invoice.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public final class InvoicesFixture {

  private InvoicesFixture() {}

  public static Invoice invoce() {
    return new Invoice(invoiceId(), lines());
  }

  public static InvoiceToCreate invoiceToCreate() {
    return new InvoiceToCreate(lines());
  }

  private static List<Line> lines() {
    return List.of(firstLine(), secondLine());
  }

  public static InvoiceId invoiceId() {
    return new InvoiceId(UUID.fromString("abee3957-6e90-4213-a1ec-574f406ac5eb"));
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
