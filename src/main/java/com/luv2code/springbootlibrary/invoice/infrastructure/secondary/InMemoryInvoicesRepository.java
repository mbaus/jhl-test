package com.luv2code.springbootlibrary.invoice.infrastructure.secondary;

import com.luv2code.springbootlibrary.error.domain.Assert;
import com.luv2code.springbootlibrary.invoice.domain.Invoice;
import com.luv2code.springbootlibrary.invoice.domain.InvoiceId;
import com.luv2code.springbootlibrary.invoice.domain.InvoicesRepository;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
class InMemoryInvoicesRepository implements InvoicesRepository {

  private final Map<InvoiceId, Invoice> invoices = new ConcurrentHashMap<>();

  @Override
  public void save(Invoice invoice) {
    Assert.notNull("invoice", invoice);

    invoices.put(invoice.id(), invoice);
  }

  @Override
  public Optional<Invoice> get(InvoiceId invoice) {
    return Optional.ofNullable(invoices.get(invoice));
  }
}
