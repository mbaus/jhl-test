package com.luv2code.springbootlibrary.invoice.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.luv2code.springbootlibrary.UnitTest;
import java.math.BigDecimal;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@UnitTest
class AmountTest {

  @Test
  void shouldScaleAtTwoDigets() {
    Assertions.assertThat(new Amount(new BigDecimal("12.137"))).isEqualTo(new Amount(new BigDecimal("12.14")));
  }
}
