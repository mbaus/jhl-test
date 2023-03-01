package com.luv2code.springbootlibrary.invoice;

import com.luv2code.springbootlibrary.error.domain.Assert;
import java.util.UUID;

public record InvoiceId(UUID id) {
  public InvoiceId {
    Assert.notNull("id", id);
  }
}
