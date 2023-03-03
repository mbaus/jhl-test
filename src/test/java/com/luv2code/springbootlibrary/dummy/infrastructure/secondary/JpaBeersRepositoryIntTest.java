package com.luv2code.springbootlibrary.dummy.infrastructure.secondary;

import static com.luv2code.springbootlibrary.dummy.domain.BeersIdentityFixture.*;
import static com.luv2code.springbootlibrary.dummy.domain.beer.BeersFixture.*;
import static org.assertj.core.api.Assertions.*;

import com.luv2code.springbootlibrary.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@IntegrationTest
class JpaBeersRepositoryIntTest {

  @Autowired
  private JpaBeersRepository beers;

  @Test
  void shouldSaveAndGetBeer() {
    beers.saveAndFlush(BeerEntity.from(beer()));

    assertThat(beers.findById(cloackOfFeathersId().get()).get().toDomain()).usingRecursiveComparison().isEqualTo(beer());
  }
}
