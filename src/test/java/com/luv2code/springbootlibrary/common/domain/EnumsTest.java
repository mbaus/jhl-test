package com.luv2code.springbootlibrary.common.domain;

import static org.assertj.core.api.Assertions.*;

import com.luv2code.springbootlibrary.UnitTest;
import com.luv2code.springbootlibrary.error.domain.MissingMandatoryValueException;
import org.junit.jupiter.api.Test;

@UnitTest
class EnumsTest {

  @Test
  void shouldNotMapWithoutTo() {
    assertThatThrownBy(() -> Enums.map(Primary.ONE, null))
      .isExactlyInstanceOf(MissingMandatoryValueException.class)
      .hasMessageContaining("to");
  }

  @Test
  void shouldMapToNullFromNullFrom() {
    assertThat(Enums.map(null, Primary.class)).isNull();
  }

  @Test
  void shouldMapFromPrimaryToDomain() {
    assertThat(Enums.map(Primary.ONE, Domain.class)).isEqualTo(Domain.ONE);
  }

  @Test
  void shouldMapFromDomainToPrimary() {
    assertThat(Enums.map(Domain.ONE, Primary.class)).isEqualTo(Primary.ONE);
  }

  @Test
  void shouldNotMapWithMoreValueInSourceThanDestination() {
    assertThatThrownBy(() -> Enums.map(Other.ONE, Primary.class)).isExactlyInstanceOf(UnmappableEnumException.class);
  }

  @Test
  void shouldMapWithMoreValueInDestinationThanSource() {
    assertThat(Enums.map(Primary.ONE, Other.class)).isEqualTo(Other.ONE);
  }

  private enum Primary {
    ONE,
  }

  private enum Domain {
    ONE,
  }

  private enum Other {
    ONE,
    TWO,
  }
}
