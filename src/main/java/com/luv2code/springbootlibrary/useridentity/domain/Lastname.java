package com.luv2code.springbootlibrary.useridentity.domain;

import com.luv2code.springbootlibrary.error.domain.Assert;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;

public record Lastname(String lastname) implements Comparable<Lastname> {
  public Lastname(String lastname) {
    Assert.field("lastname", lastname).notBlank().maxLength(150);

    this.lastname = lastname.trim().toUpperCase();
  }

  public static Optional<Lastname> of(String birthName) {
    return Optional.ofNullable(birthName).filter(StringUtils::isNotBlank).map(Lastname::new);
  }

  public String get() {
    return lastname();
  }

  @Override
  public int compareTo(Lastname other) {
    if (other == null) {
      return -1;
    }

    return lastname.compareTo(other.lastname);
  }
}