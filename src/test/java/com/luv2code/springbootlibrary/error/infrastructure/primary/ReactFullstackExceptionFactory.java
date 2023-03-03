package com.luv2code.springbootlibrary.error.infrastructure.primary;

import com.luv2code.springbootlibrary.error.domain.ReactFullstackException;

public final class ReactFullstackExceptionFactory {

  private ReactFullstackExceptionFactory() {}

  public static final ReactFullstackException buildEmptyException() {
    return ReactFullstackException.builder(null).build();
  }
}
