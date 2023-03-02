package com.luv2code.springbootlibrary.account.infrastructure.primary;

import static com.luv2code.springbootlibrary.account.domain.TokensFixture.*;
import static org.assertj.core.api.Assertions.*;

import com.luv2code.springbootlibrary.JsonHelper;
import com.luv2code.springbootlibrary.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class RestTokenTest {

  @Test
  void shouldConvertFromDomain() {
    assertThat(JsonHelper.writeAsString(RestToken.from(token()))).isEqualTo(json());
  }

  private String json() {
    return "{\"id_token\":\"token\"}";
  }
}
