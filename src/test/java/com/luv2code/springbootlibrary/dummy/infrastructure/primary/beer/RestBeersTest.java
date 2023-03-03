package com.luv2code.springbootlibrary.dummy.infrastructure.primary.beer;

import static org.assertj.core.api.Assertions.*;

import com.luv2code.springbootlibrary.JsonHelper;
import com.luv2code.springbootlibrary.UnitTest;
import com.luv2code.springbootlibrary.dummy.domain.beer.Beers;
import com.luv2code.springbootlibrary.dummy.domain.beer.BeersFixture;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class RestBeersTest {

  @Test
  void shouldSerializeToJson() {
    assertThat(JsonHelper.writeAsString(RestBeers.from(new Beers(List.of(BeersFixture.beer()))))).isEqualTo(json());
  }

  private String json() {
    return "{\"beers\":[" + RestBeerTest.json() + "]}";
  }
}
