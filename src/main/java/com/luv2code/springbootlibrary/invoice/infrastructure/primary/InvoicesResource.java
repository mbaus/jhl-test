package com.luv2code.springbootlibrary.invoice.infrastructure.primary;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/invoices")
public class InvoicesResource {

  @PostMapping
  ResponseEntity<RestInvoice> create(@Validated RestInvoiceToCreate invoiceToCreate) {
    //TODO
    return null;
  }
}
