package com.luv2code.springbootlibrary.account.domain;

public final class TokensFixture {

  private TokensFixture() {}

  public static Token token() {
    return new Token("token");
  }
}
