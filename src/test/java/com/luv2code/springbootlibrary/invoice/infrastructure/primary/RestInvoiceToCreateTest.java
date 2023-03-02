package com.luv2code.springbootlibrary.invoice.infrastructure.primary;

import static com.luv2code.springbootlibrary.invoice.domain.InvoicesFixture.invoiceToCreate;
import static org.assertj.core.api.Assertions.assertThat;

import com.luv2code.springbootlibrary.ComponentTest;
import com.luv2code.springbootlibrary.JsonHelper;
import com.luv2code.springbootlibrary.invoice.domain.InvoicesFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@ComponentTest
class RestInvoiceToCreateTest {

  @Test
  void sholdConvertToDomain() {
    assertThat(JsonHelper.readFromJson(json(), RestInvoiceToCreate.class).toDomain())
      .usingRecursiveComparison()
      .isEqualTo(invoiceToCreate());
  }

  private String json() {
    return """
      {
        "lines": [
          {
            "quantity": 2,
             "unitPrice": {
                "amount": 500,
                "currency": "EURO"
             }
          },
                    {
            "quantity": 1,
             "unitPrice": {
                "amount": 400,
                "currency": "EURO"
             }
          }
        ]
      }
      """;
  }
}
//TODO bean validation
