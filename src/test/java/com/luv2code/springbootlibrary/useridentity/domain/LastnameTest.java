package com.luv2code.springbootlibrary.useridentity.domain;

import static org.assertj.core.api.Assertions.*;

import com.luv2code.springbootlibrary.UnitTest;
import com.luv2code.springbootlibrary.error.domain.MissingMandatoryValueException;
import com.luv2code.springbootlibrary.error.domain.StringTooLongException;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

@UnitTest
class LastnameTest {

  @Test
  void shouldNotBuildWithoutLastname() {
    assertThatThrownBy(() -> new Lastname(null)).isExactlyInstanceOf(MissingMandatoryValueException.class).hasMessageContaining("lastname");
  }

  @Test
  void shouldNotBuildWithBlankLastname() {
    assertThatThrownBy(() -> new Lastname(" ")).isExactlyInstanceOf(MissingMandatoryValueException.class).hasMessageContaining("lastname");
  }

  @Test
  void shouldNotBuildWithTooLongLastname() {
    assertThatThrownBy(() -> new Lastname("a".repeat(151)))
      .isExactlyInstanceOf(StringTooLongException.class)
      .hasMessageContaining("lastname");
  }

  @Test
  void shouldBeEmptyWithoutLastname() {
    assertThat(Lastname.of(null)).isEmpty();
  }

  @Test
  void shouldBeEmptyWithBlankLastname() {
    assertThat(Lastname.of(" ")).isEmpty();
  }

  @Test
  void shouldUpperCaseAndTrimLastname() {
    Lastname lastname = new Lastname(" Dupond ");

    assertThat(lastname.get()).isEqualTo("DUPOND");
  }

  @Test
  void shouldCompareLastnames() {
    List<Lastname> lastnames = Stream.of(null, new Lastname("DUPONT"), new Lastname("DUPOND")).sorted().toList();

    assertThat(lastnames).containsExactly(new Lastname("DUPOND"), new Lastname("DUPONT"), null);
  }
}
