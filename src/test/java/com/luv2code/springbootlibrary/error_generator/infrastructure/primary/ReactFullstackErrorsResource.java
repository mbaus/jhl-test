package com.luv2code.springbootlibrary.error_generator.infrastructure.primary;

import com.luv2code.springbootlibrary.error.domain.ReactFullstackException;
import com.luv2code.springbootlibrary.error.domain.StandardErrorKey;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/errors")
class ReactFullstackErrorsResource {

  @GetMapping("bad-request")
  void getBadRequest() {
    throw ReactFullstackException.badRequest(StandardErrorKey.BAD_REQUEST).addParameter("code", "400").build();
  }
}
