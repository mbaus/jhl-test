package com.luv2code.springbootlibrary.account.domain;

public interface TokensRepository {
  Token buildToken(AuthenticationQuery query);
}
