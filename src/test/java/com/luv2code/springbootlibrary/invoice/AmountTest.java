package com.luv2code.springbootlibrary.invoice;

import static org.assertj.core.api.Assertions.assertThat;

import com.luv2code.springbootlibrary.UnitTest;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

@UnitTest
public class AmountTest {

  @Test
  void shouldRoundAtTwoDigets() {
    assertThat(new Amount(new BigDecimal("12.137"))).isEqualTo(new Amount(new BigDecimal("12.14")));
  }
}
