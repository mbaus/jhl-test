package com.luv2code.springbootlibrary.invoice.infrastructure.primary;

import com.luv2code.springbootlibrary.invoice.application.InvoicesApplicationService;
import com.luv2code.springbootlibrary.invoice.domain.InvoiceId;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/invoices")
public class InvoicesResource {

  private final InvoicesApplicationService invoices;

  public InvoicesResource(InvoicesApplicationService invoices) {
    this.invoices = invoices;
  }

  @PostMapping
  ResponseEntity<RestInvoice> create(@Validated @RequestBody RestInvoiceToCreate invoiceToCreate) {
    RestInvoice createdInvoice = RestInvoice.from(invoices.create(invoiceToCreate.toDomain()));

    return new ResponseEntity<>(createdInvoice, HttpStatus.CREATED);
  }

  @GetMapping("/{invoice-id}")
  ResponseEntity<RestInvoice> get(@PathVariable("invoice-id") UUID id) {
    return ResponseEntity.of(invoices.get(new InvoiceId(id)).map(RestInvoice::from));
  }
}
