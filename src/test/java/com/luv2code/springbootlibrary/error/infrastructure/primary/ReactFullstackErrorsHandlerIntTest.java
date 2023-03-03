package com.luv2code.springbootlibrary.error.infrastructure.primary;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.luv2code.springbootlibrary.IntegrationTest;
import java.util.Locale;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@IntegrationTest
@AutoConfigureMockMvc
class ReactFullstackErrorsHandlerIntTest {

  @Autowired
  private MockMvc rest;

  @Test
  void shouldHandleReactFullstackErrorWithoutLocale() throws Exception {
    rest
      .perform(get("/api/errors/bad-request"))
      .andExpect(status().is4xxClientError())
      .andExpect(jsonPath("title").value("Bad request"))
      .andExpect(jsonPath("detail").value("You send a bad request: 400"));
  }

  @Test
  void shouldHandleReactFullstackErrorForFrenchLocale() throws Exception {
    rest
      .perform(get("/api/errors/bad-request").locale(Locale.FRANCE))
      .andExpect(status().is4xxClientError())
      .andExpect(jsonPath("title").value("Bad request"))
      .andExpect(jsonPath("detail").value("Votre requête n'est pas valide: 400"));
  }
}
