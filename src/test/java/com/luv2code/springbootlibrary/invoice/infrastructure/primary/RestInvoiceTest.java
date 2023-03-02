package com.luv2code.springbootlibrary.invoice.infrastructure.primary;

import static com.luv2code.springbootlibrary.invoice.domain.InvoicesFixture.invoce;
import static org.assertj.core.api.Assertions.assertThat;

import com.luv2code.springbootlibrary.JsonHelper;
import com.luv2code.springbootlibrary.UnitTest;
import com.luv2code.springbootlibrary.invoice.domain.InvoicesFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@UnitTest
class RestInvoiceTest {

  @Test
  void shouldSerializeToJson() {
    assertThat(JsonHelper.writeAsString(RestInvoice.from(invoce()))).isEqualTo(json());
  }

  private String json() {
    return """
      {\
      "id":"abee3957-6e90-4213-a1ec-574f406ac5eb",\
      "lines":[\
      {"quantity":2,"unitPrice":{"amount":500.00,"currency":"EURO"}},\
      {"quantity":1,"unitPrice":{"amount":400.00,"currency":"EURO"}}\
      ],\
      "total":{"amount":1400.00,"currency":"EURO"}\
      }\
      """;
  }
}
