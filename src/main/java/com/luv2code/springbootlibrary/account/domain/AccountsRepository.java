package com.luv2code.springbootlibrary.account.domain;

import java.util.Optional;

public interface AccountsRepository {
  Optional<Account> authenticatedUserAccount();
}
