package com.luv2code.springbootlibrary.account.infrastructure.primary;

import static com.luv2code.springbootlibrary.account.domain.AccountsFixture.*;
import static org.assertj.core.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luv2code.springbootlibrary.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class RestAccountTest {

  private static final ObjectMapper json = new ObjectMapper();

  @Test
  void shouldSerializeToJson() throws JsonProcessingException {
    assertThat(json.writeValueAsString(RestAccount.from(account()))).isEqualTo(json());
  }

  private String json() {
    return """
        {\
        "username":"user",\
        "name":"Paul DUPOND",\
        "email":"email@company.fr",\
        "roles":["ROLE_ADMIN"]\
        }\
        """;
  }
}
