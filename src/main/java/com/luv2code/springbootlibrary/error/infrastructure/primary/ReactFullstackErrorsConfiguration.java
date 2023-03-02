package com.luv2code.springbootlibrary.error.infrastructure.primary;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
class ReactFullstackErrorsConfiguration {

  @Bean("applicationErrorMessageSource")
  MessageSource applictionErrorMessageSource() {
    ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();

    source.setBasename("classpath:/messages/errors/react-fullstack-errors-messages");
    source.setDefaultEncoding("UTF-8");

    return source;
  }
}
