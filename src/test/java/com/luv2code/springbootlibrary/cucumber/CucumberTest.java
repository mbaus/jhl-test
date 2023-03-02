package com.luv2code.springbootlibrary.cucumber;

import com.luv2code.springbootlibrary.ComponentTest;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@ComponentTest
@RunWith(Cucumber.class)
@CucumberOptions(
  tags = "not @ignore",
  glue = "com.luv2code.springbootlibrary",
  plugin = {
    "pretty", "json:target/cucumber/cucumber.json", "html:target/cucumber/cucumber.htm", "junit:target/cucumber/TEST-cucumber.xml",
  },
  features = "src/test/features"
)
public class CucumberTest {}
