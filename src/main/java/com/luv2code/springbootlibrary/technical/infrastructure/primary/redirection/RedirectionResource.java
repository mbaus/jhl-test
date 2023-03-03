package com.luv2code.springbootlibrary.technical.infrastructure.primary.redirection;

import com.luv2code.springbootlibrary.common.domain.Generated;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Generated
@Controller
class RedirectionResource {

  @GetMapping(value = "/{path:[^\\.]*}")
  public String redirectApi() {
    return "forward:/";
  }
}
