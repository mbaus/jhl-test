package com.luv2code.springbootlibrary.error.infrastructure.primary;

import static org.mockito.Mockito.*;

import ch.qos.logback.classic.Level;
import com.luv2code.springbootlibrary.LogsSpy;
import com.luv2code.springbootlibrary.UnitTest;
import com.luv2code.springbootlibrary.error.domain.ReactFullstackException;
import com.luv2code.springbootlibrary.error.domain.StandardErrorKey;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.MessageSource;

@UnitTest
@ExtendWith(LogsSpy.class)
class ReactFullstackErrorsHandlerTest {

  private static final ReactFullstackErrorsHandler handler = new ReactFullstackErrorsHandler(mock(MessageSource.class));

  private final LogsSpy logs;

  public ReactFullstackErrorsHandlerTest(LogsSpy logs) {
    this.logs = logs;
  }

  @Test
  void shouldLogServerErrorAsError() {
    handler.handleReactFullstackException(
      ReactFullstackException.internalServerError(StandardErrorKey.INTERNAL_SERVER_ERROR).message("Oops").build()
    );

    logs.shouldHave(Level.ERROR, "Oops");
  }

  @Test
  void shouldLogClientErrorAsInfo() {
    handler.handleReactFullstackException(ReactFullstackException.badRequest(StandardErrorKey.BAD_REQUEST).message("Oops").build());

    logs.shouldHave(Level.INFO, "Oops");
  }
}
