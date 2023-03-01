Feature: Invoices

  Scenario: Create and get invoice
    Given I create invoice
      | Quantity | Unit price |
      | 1        | 450.00     |
      | 2        | 500.00     |
    When I get the created invoice
    Then I should have invoice
      | Total | 1450.00 |
