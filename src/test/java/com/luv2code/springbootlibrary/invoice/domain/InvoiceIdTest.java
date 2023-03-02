package com.luv2code.springbootlibrary.invoice.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.luv2code.springbootlibrary.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class InvoiceIdTest {

  @Test
  void shouldGenerateIds() {
    assertThat(InvoiceId.newId()).isNotNull().isNotEqualTo(InvoiceId.newId());
  }
}
