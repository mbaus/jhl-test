package com.luv2code.springbootlibrary.technical.infrastructure.secondary.logstash;

import static org.assertj.core.api.Assertions.assertThat;

import com.luv2code.springbootlibrary.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class LogstashTcpPropertiesTest {

  @Test
  void shouldDisableByDefault() {
    assertThat(new LogstashTcpProperties().isEnabled()).isFalse();
  }
}
