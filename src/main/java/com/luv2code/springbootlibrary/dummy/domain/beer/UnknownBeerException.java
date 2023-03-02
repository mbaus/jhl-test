package com.luv2code.springbootlibrary.dummy.domain.beer;

import com.luv2code.springbootlibrary.dummy.domain.BeerId;

class UnknownBeerException extends RuntimeException {

  public UnknownBeerException(BeerId id) {
    super("Beer " + id.get() + " is unknown");
  }
}
