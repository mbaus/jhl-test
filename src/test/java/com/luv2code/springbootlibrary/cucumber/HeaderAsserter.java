package com.luv2code.springbootlibrary.cucumber;

public interface HeaderAsserter<T extends ResponseAsserter> {
  HeaderAsserter<T> containing(String value);

  HeaderAsserter<T> startingWith(String prefix);

  T and();
}
