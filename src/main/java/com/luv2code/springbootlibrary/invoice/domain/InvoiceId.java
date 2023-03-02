package com.luv2code.springbootlibrary.invoice.domain;

import com.luv2code.springbootlibrary.error.domain.Assert;
import java.util.UUID;

public record InvoiceId(UUID id) {
  public InvoiceId {
    Assert.notNull("id", id);
  }

  public UUID get() {
    return id();
  }

  public static InvoiceId newId() {
    return new InvoiceId(UUID.randomUUID());
  }
}
