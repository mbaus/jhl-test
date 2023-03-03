package com.luv2code.springbootlibrary.dummy.infrastructure.secondary;

import static com.luv2code.springbootlibrary.dummy.domain.beer.BeersFixture.*;
import static org.assertj.core.api.Assertions.*;

import com.luv2code.springbootlibrary.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class BeerEntityTest {

  @Test
  void shouldConvertFromAndToDomain() {
    assertThat(BeerEntity.from(beer()).toDomain()).usingRecursiveComparison().isEqualTo(beer());
  }
}
