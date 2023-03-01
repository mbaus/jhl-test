package com.luv2code.springbootlibrary.invoice.infrastructure.primary;

import static com.luv2code.springbootlibrary.cucumber.CucumberAssertions.assertThatLastResponse;

import com.luv2code.springbootlibrary.cucumber.CucumberAssertions;
import com.luv2code.springbootlibrary.cucumber.CucumberRestTemplate;
import com.luv2code.springbootlibrary.cucumber.CucumberTestContext;
import com.luv2code.springbootlibrary.invoice.domain.Quantity;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

public class InvoicesSteps {

  @Autowired
  private CucumberRestTemplate rest;

  @Given("I create invoice")
  public void createInvoice(List<Map<String, String>> lines) {
    String payload = "{\"lines\":[" + linesPayload(lines) + "]}";
    rest.post("/api/invoices", payload);
  }

  private static String linesPayload(List<Map<String, String>> lines) {
    return lines
      .stream()
      .map(line ->
        "\"quantity\": " + line.get("Quantity") + ", \"unitPrice\": {\"amount\": " + line.get("Unit price") + ", \"currency\": \"EURO\"}"
      )
      .collect(Collectors.joining(","));
  }

  @When("I get the created invoice")
  public void getCreatedInvoice() {
    rest.get("/api/invoices/" + CucumberTestContext.getElement("$..id"));
  }

  @Then("I should have invoice")
  public void shouldHaveInvoice(Map<String, String> invoice) {
    assertThatLastResponse().hasOkStatus().hasResponse().containing(invoice);
  }
}
