package com.luv2code.springbootlibrary.invoice.domain;

import static com.luv2code.springbootlibrary.invoice.domain.InvoicesFixture.fee;
import static com.luv2code.springbootlibrary.invoice.domain.InvoicesFixture.firstLine;
import static com.luv2code.springbootlibrary.invoice.domain.InvoicesFixture.invoce;
import static com.luv2code.springbootlibrary.invoice.domain.InvoicesFixture.invoiceId;
import static com.luv2code.springbootlibrary.invoice.domain.InvoicesFixture.secondLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.luv2code.springbootlibrary.UnitTest;
import com.luv2code.springbootlibrary.error.domain.MissingMandatoryValueException;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class InvoiceTest {

  @Test
  void shouldNotBuildWithoutLines() {
    assertThatThrownBy(() -> new Invoice(invoiceId(), null))
      .isExactlyInstanceOf(MissingMandatoryValueException.class)
      .hasMessageContaining("lines");
  }

  @Test
  void shouldNotBuildWithZeroLines() {
    assertThatThrownBy(() -> new Invoice(invoiceId(), List.of()))
      .isExactlyInstanceOf(MissingMandatoryValueException.class)
      .hasMessageContaining("lines");
  }

  @Test
  void shouldGetInvoiceInformation() {
    Invoice invoice = invoce();

    assertThat(invoice.lines()).containsExactly(firstLine(), secondLine());
    assertThat(invoice.total()).isEqualTo(fee(1400));
  }
}
