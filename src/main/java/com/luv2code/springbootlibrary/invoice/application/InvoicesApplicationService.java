package com.luv2code.springbootlibrary.invoice.application;

import com.luv2code.springbootlibrary.invoice.domain.Invoice;
import com.luv2code.springbootlibrary.invoice.domain.InvoiceCreator;
import com.luv2code.springbootlibrary.invoice.domain.InvoiceId;
import com.luv2code.springbootlibrary.invoice.domain.InvoiceToCreate;
import com.luv2code.springbootlibrary.invoice.domain.InvoicesRepository;
import java.util.Optional;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Service;

@Service
public class InvoicesApplicationService {

  private final InvoicesRepository invoices;
  private final InvoiceCreator invoiceCreator;

  public InvoicesApplicationService(InvoicesRepository invoices) {
    this.invoices = invoices;
    this.invoiceCreator = new InvoiceCreator(invoices);
  }

  public Invoice create(InvoiceToCreate invoiceToCreate) {
    return invoiceCreator.create(invoiceToCreate);
  }

  public Optional<Invoice> get(InvoiceId invoice) {
    return invoices.get(invoice);
  }
}
