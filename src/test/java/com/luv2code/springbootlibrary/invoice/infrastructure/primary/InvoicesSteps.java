package com.luv2code.springbootlibrary.invoice.infrastructure.primary;

import com.luv2code.springbootlibrary.cucumber.CucumberRestTemplate;
import com.luv2code.springbootlibrary.invoice.domain.Quantity;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

public class InvoicesSteps {

  @Autowired
  private CucumberRestTemplate rest;

  @Given("I create invoice")
  public void createInvoice(List<Map<String, String>> lines) {
    //TODO
  }

  @When("I get the created invoice")
  public void getCreatedInvoice() {
    //TODO
  }

  @Then("I should have invoice")
  public void shouldHaveInvoice(Map<String, String> invoice) {
    //TODO
  }
}
