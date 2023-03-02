package com.luv2code.springbootlibrary.invoice.infrastructure.primary;

import com.luv2code.springbootlibrary.invoice.domain.Invoice;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class RestInvoice {

  private final UUID id;
  private final Collection<RestLine> lines;
  private final RestFee total;

  private RestInvoice(UUID id, Collection<RestLine> lines, RestFee total) {
    this.id = id;
    this.lines = lines;
    this.total = total;
  }

  public static RestInvoice from(Invoice invoce) {
    List<RestLine> lines = invoce.lines().stream().map(RestLine::from).toList();
    return new RestInvoice(invoce.id().get(), lines, RestFee.from(invoce.total()));
  }

  public UUID getId() {
    return id;
  }

  public Collection<RestLine> getLines() {
    return lines;
  }

  public RestFee getTotal() {
    return total;
  }
}
