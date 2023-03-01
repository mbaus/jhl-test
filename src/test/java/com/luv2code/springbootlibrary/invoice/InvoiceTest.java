package com.luv2code.springbootlibrary.invoice;

import static com.luv2code.springbootlibrary.invoice.InvoicesFixture.fee;
import static com.luv2code.springbootlibrary.invoice.InvoicesFixture.firstLine;
import static com.luv2code.springbootlibrary.invoice.InvoicesFixture.secondLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.luv2code.springbootlibrary.UnitTest;
import com.luv2code.springbootlibrary.error.domain.MissingMandatoryValueException;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
public class InvoiceTest {

  @Test
  void shouldNotBuildWithoutLines() {
    assertThatThrownBy(() -> new Invoice(null)).isExactlyInstanceOf(MissingMandatoryValueException.class).hasMessageContaining("lines");
  }

  @Test
  void shouldNotBuildWithZeroLines() {
    assertThatThrownBy(() -> new Invoice(List.of()))
      .isExactlyInstanceOf(MissingMandatoryValueException.class)
      .hasMessageContaining("lines");
  }

  @Test
  void shouldGetInvoiceInformation() {
    Invoice invoice = InvoicesFixture.invoce();

    assertThat(invoice.lines()).containsExactly(firstLine(), secondLine());
    assertThat(invoice.total()).isEqualTo(fee(1400));
  }
}
