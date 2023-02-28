package com.luv2code.springbootlibrary.invoice;

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
    Line line = new Line();
    Invoice invoice = new Invoice(List.of(line));

    assertThat(invoice.lines()).containsExactly(line);
  }
}
