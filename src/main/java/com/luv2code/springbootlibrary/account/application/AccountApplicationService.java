package com.luv2code.springbootlibrary.account.application;

import com.luv2code.springbootlibrary.account.domain.AuthenticationQuery;
import com.luv2code.springbootlibrary.account.domain.Token;
import com.luv2code.springbootlibrary.account.domain.TokensRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountApplicationService {

  private final TokensRepository tokens;

  public AccountApplicationService(TokensRepository tokens) {
    this.tokens = tokens;
  }

  public Token createToken(AuthenticationQuery query) {
    return tokens.buildToken(query);
  }
}
