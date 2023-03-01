package com.luv2code.springbootlibrary;

import com.luv2code.springbootlibrary.common.domain.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
@Generated(reason = "Not testing logs")
public class ReactFullstackApp {

  private static final Logger log = LoggerFactory.getLogger(ReactFullstackApp.class);

  public static void main(String[] args) {
    Environment env = SpringApplication.run(ReactFullstackApp.class, args).getEnvironment();

    if (log.isInfoEnabled()) {
      log.info(ApplicationStartupTraces.of(env));
    }
  }
}
