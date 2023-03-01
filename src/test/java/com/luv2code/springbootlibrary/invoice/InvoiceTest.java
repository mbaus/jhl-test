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
    Line firstLine = new Line(new Quantity(2), fee(500));
    Line secondLine = new Line(new Quantity(1), fee(400));
    Invoice invoice = new Invoice(List.of(firstLine, secondLine));

    assertThat(invoice.lines()).containsExactly(firstLine, secondLine);
    assertThat(invoice.total()).isEqualTo(fee(1400));
  }

  private static Fee fee(int amount) {
    return new Fee(amount(amount), Currency.EURO);
  }

  private static Amount amount(int amount) {
    return new Amount(new BigDecimal(amount));
  }
}
