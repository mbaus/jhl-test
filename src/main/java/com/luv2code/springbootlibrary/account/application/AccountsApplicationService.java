package com.luv2code.springbootlibrary.account.application;

import com.luv2code.springbootlibrary.account.domain.Account;
import com.luv2code.springbootlibrary.account.domain.AccountsRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AccountsApplicationService {

  private final AccountsRepository accounts;

  public AccountsApplicationService(AccountsRepository accounts) {
    this.accounts = accounts;
  }

  public Optional<Account> authenticatedUserAccount() {
    return accounts.authenticatedUserAccount();
  }
}