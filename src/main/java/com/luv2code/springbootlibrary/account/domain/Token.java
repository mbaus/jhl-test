package com.luv2code.springbootlibrary.account.domain;

import com.luv2code.springbootlibrary.error.domain.Assert;

public record Token(String token) {
  public Token {
    Assert.notBlank("token", token);
  }

  public String get() {
    return token();
  }

  public String bearer() {
    return "Bearer " + token();
  }
}
