package com.luv2code.springbootlibrary.account.domain;

import static com.luv2code.springbootlibrary.useridentity.domain.UsersIdentitiesFixture.*;

import com.luv2code.springbootlibrary.authentication.domain.Role;
import java.util.List;

public final class AccountsFixture {

  private AccountsFixture() {}

  public static Account account() {
    return Account
      .builder()
      .username(username())
      .firstname(firstname())
      .lastname(lastname())
      .email(email())
      .roles(List.of(Role.ADMIN.key()))
      .build();
  }
}
