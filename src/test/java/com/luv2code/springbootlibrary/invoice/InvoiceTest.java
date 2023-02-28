package com.luv2code.springbootlibrary.invoice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.luv2code.springbootlibrary.UnitTest;
import com.luv2code.springbootlibrary.error.domain.MissingMandatoryValueException;
import java.math.BigDecimal;
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
    Line firstLine = new Line(new Quantity(2), new Fee(new Amount(new BigDecimal(500)), Currency.EURO));
    Line secondLine = new Line(new Quantity(1), new Fee(new Amount(new BigDecimal(400)), Currency.EURO));
    Invoice invoice = new Invoice(List.of(firstLine, secondLine));

    assertThat(invoice.lines()).containsExactly(firstLine, secondLine);
    assertThat(invoice.total()).isEqualTo(new Fee(new Amount(new BigDecimal(1400)), Currency.EURO));
  }
}
