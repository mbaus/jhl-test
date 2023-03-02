package com.luv2code.springbootlibrary.account.infrastructure.primary;

import com.luv2code.springbootlibrary.authentication.domain.Role;
import com.luv2code.springbootlibrary.authentication.infrastructure.primary.AuthenticatedUser;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class AccountResource {

  /**
   * {@code GET  /account} : get the current user.
   *
   * @return the current user.
   * @throws AccountResourceException
   *           {@code 500 (Internal Server Error)} if the user couldn't be returned.
   */
  @GetMapping("/account")
  public RestAccount getAccount() {
    return new RestAccount(AuthenticatedUser.username().get(), roles());
  }

  private Set<String> roles() {
    return AuthenticatedUser.roles().stream().map(Role::key).collect(Collectors.toUnmodifiableSet());
  }
}
