package com.luv2code.springbootlibrary.error.infrastructure.primary;

import com.luv2code.springbootlibrary.common.domain.Enums;
import com.luv2code.springbootlibrary.error.domain.ErrorKey;
import com.luv2code.springbootlibrary.error.domain.ReactFullstackException;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE - 1000)
class ReactFullstackErrorsHandler {

  private static final Logger log = LoggerFactory.getLogger(ReactFullstackErrorsHandler.class);
  private static final String MESSAGES_PREFIX = "error.";

  private final MessageSource messages;

  public ReactFullstackErrorsHandler(@Qualifier("applicationErrorMessageSource") MessageSource messages) {
    Locale.setDefault(Locale.ENGLISH);

    this.messages = messages;
  }

  @ExceptionHandler(ReactFullstackException.class)
  ProblemDetail handleReactFullstackException(ReactFullstackException exception) {
    HttpStatus status = Enums.map(exception.status(), HttpStatus.class);
    ProblemDetail problem = ProblemDetail.forStatusAndDetail(status, buildDetail(exception));

    problem.setTitle(getMessage(exception.key(), "title"));
    problem.setProperty("key", exception.key().get());

    logException(exception, status);

    return problem;
  }

  private String buildDetail(ReactFullstackException exception) {
    String messageTemplate = getMessage(exception.key(), "detail");

    return ArgumentsReplacer.replaceParameters(messageTemplate, exception.parameters());
  }

  private String getMessage(ErrorKey key, String suffix) {
    return messages.getMessage(MESSAGES_PREFIX + key.get() + "." + suffix, null, locale());
  }

  private Locale locale() {
    return LocaleContextHolder.getLocale();
  }

  private void logException(ReactFullstackException exception, HttpStatus status) {
    if (status.is4xxClientError()) {
      log.info(exception.getMessage(), exception);
    } else {
      log.error(exception.getMessage(), exception);
    }
  }
}
