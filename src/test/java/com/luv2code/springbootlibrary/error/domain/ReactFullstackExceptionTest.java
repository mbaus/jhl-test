package com.luv2code.springbootlibrary.error.domain;

import static org.assertj.core.api.Assertions.*;

import com.luv2code.springbootlibrary.UnitTest;
import com.luv2code.springbootlibrary.error.infrastructure.primary.ReactFullstackExceptionFactory;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class ReactFullstackExceptionTest {

  @Test
  void shouldGetMinimalReactFullstackExceptionFromDomain() {
    ReactFullstackException exception = ReactFullstackException.builder(null).build();

    assertThat(exception.key()).isEqualTo(StandardErrorKey.INTERNAL_SERVER_ERROR);
    assertThat(exception.status()).isEqualTo(ErrorStatus.INTERNAL_SERVER_ERROR);
    assertThat(exception.getMessage()).isEqualTo("An error occured");
    assertThat(exception.getCause()).isNull();
    assertThat(exception.parameters()).isEmpty();
  }

  @Test
  void shouldGetMinimalReactFullstackExceptionFromPrimary() {
    ReactFullstackException exception = ReactFullstackExceptionFactory.buildEmptyException();

    assertThat(exception.key()).isEqualTo(StandardErrorKey.INTERNAL_SERVER_ERROR);
    assertThat(exception.status()).isEqualTo(ErrorStatus.BAD_REQUEST);
    assertThat(exception.getMessage()).isEqualTo("An error occured");
    assertThat(exception.getCause()).isNull();
    assertThat(exception.parameters()).isEmpty();
  }

  @Test
  void shouldGetFullReactFullstackException() {
    RuntimeException cause = new RuntimeException();
    ReactFullstackException exception = ReactFullstackException
      .builder(StandardErrorKey.BAD_REQUEST)
      .message("This is an error")
      .cause(cause)
      .addParameter("parameter", "value")
      .addParameters(Map.of("key", "value"))
      .status(ErrorStatus.BAD_REQUEST)
      .build();

    assertThat(exception.key()).isEqualTo(StandardErrorKey.BAD_REQUEST);
    assertThat(exception.status()).isEqualTo(ErrorStatus.BAD_REQUEST);
    assertThat(exception.getMessage()).isEqualTo("This is an error");
    assertThat(exception.getCause()).isEqualTo(cause);
    assertThat(exception.parameters()).containsOnly(entry("parameter", "value"), entry("key", "value"));
  }

  @Test
  void shouldGetTechnicalErrorExceptionFromMessage() {
    ReactFullstackException exception = ReactFullstackException.technicalError("This is a problem");

    assertThat(exception.getMessage()).isEqualTo("This is a problem");
    assertThat(exception.key()).isEqualTo(StandardErrorKey.INTERNAL_SERVER_ERROR);
    assertThat(exception.status()).isEqualTo(ErrorStatus.INTERNAL_SERVER_ERROR);
  }

  @Test
  void shouldGetTechnicalErrorException() {
    RuntimeException cause = new RuntimeException();
    ReactFullstackException exception = ReactFullstackException.technicalError("This is a problem", cause);

    assertThat(exception.getMessage()).isEqualTo("This is a problem");
    assertThat(exception.key()).isEqualTo(StandardErrorKey.INTERNAL_SERVER_ERROR);
    assertThat(exception.getCause()).isEqualTo(cause);
    assertThat(exception.status()).isEqualTo(ErrorStatus.INTERNAL_SERVER_ERROR);
  }

  @Test
  void shouldGetInternalServerErrorShortcut() {
    ReactFullstackException exception = ReactFullstackException.internalServerError(StandardErrorKey.INTERNAL_SERVER_ERROR).build();

    assertThat(exception.status()).isEqualTo(ErrorStatus.INTERNAL_SERVER_ERROR);
  }

  @Test
  void shouldGetBadRequestShortcut() {
    ReactFullstackException exception = ReactFullstackException.badRequest(StandardErrorKey.BAD_REQUEST).build();

    assertThat(exception.status()).isEqualTo(ErrorStatus.BAD_REQUEST);
  }
}
