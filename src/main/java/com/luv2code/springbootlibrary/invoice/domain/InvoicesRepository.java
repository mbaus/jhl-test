package com.luv2code.springbootlibrary.invoice.domain;

import java.util.Optional;

public interface InvoicesRepository {
  void save(Invoice invoice);

  Optional<Invoice> get(InvoiceId invoice);
}
