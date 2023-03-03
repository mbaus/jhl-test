package com.luv2code.springbootlibrary.dummy.domain.beer;

import com.luv2code.springbootlibrary.error.domain.Assert;

public record BeerName(String name) {
  public BeerName {
    Assert.field("name", name).notBlank().maxLength(255);
  }

  public String get() {
    return name();
  }
}
