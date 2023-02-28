package com.luv2code.springbootlibrary.invoice;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.luv2code.springbootlibrary.UnitTest;
import com.luv2code.springbootlibrary.error.domain.MissingMandatoryValueException;
import org.junit.jupiter.api.Test;

@UnitTest
public class InvoiceTest {

  @Test
  void shouldNotBuildWithoutLines() {
    assertThatThrownBy(() -> new Invoice(null)).isExactlyInstanceOf(MissingMandatoryValueException.class).hasMessageContaining("lines");
  }
}
