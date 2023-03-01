package com.luv2code.springbootlibrary.invoice.infrastructure.primary;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.luv2code.springbootlibrary.invoice.domain.Amount;
import com.luv2code.springbootlibrary.invoice.domain.Currency;
import com.luv2code.springbootlibrary.invoice.domain.Fee;
import java.math.BigDecimal;

public class RestFee {

  private final BigDecimal amount;
  private final Currency currency;

  public RestFee(@JsonProperty("amount") BigDecimal amount, @JsonProperty("currency") Currency currency) {
    this.amount = amount;
    this.currency = currency;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public Currency getCurrency() {
    return currency;
  }

  public Fee toDomain() {
    return new Fee(new Amount(amount), currency);
  }
}
