Feature: Invoices

  @ignore
  Scenario: Create and get invoice
    Given I create invoice
      | Quantity | Unit price |
      | 1        | 450.00     |
      | 2        | 500.00     |
    When I get the created invoice
    Then I should have invoice
      | Total. Amount | 1450.0 |
