package com.luv2code.springbootlibrary.error_generator.domain;

import com.luv2code.springbootlibrary.error.domain.NullElementInCollectionException;

public final class NullElementInCollectionExceptionFactory {

  private NullElementInCollectionExceptionFactory() {}

  public static NullElementInCollectionException nullElementInCollection() {
    return new NullElementInCollectionException("field");
  }
}
