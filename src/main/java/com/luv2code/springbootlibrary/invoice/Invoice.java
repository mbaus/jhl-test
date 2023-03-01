package com.luv2code.springbootlibrary.invoice;

import com.luv2code.springbootlibrary.error.domain.Assert;
import java.util.Collection;

public record Invoice(InvoiceId id, Collection<Line> lines) {
  public Invoice {
    Assert.notNull("id", id);
    Assert.notEmpty("lines", lines);
  }

  public Fee total() {
    return lines.stream().map(Line::total).reduce(Fee.ZERO, Fee::add);
  }
}
