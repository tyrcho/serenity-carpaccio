@issues:SDCOAGTM18-1
@version:Release-1
Feature: Order Final Price with taxes and discounts

  An Order will compute its final price including taxes and discounts

  @issues:SDCOAGTM18-11
  @version:Sprint-3
  Scenario Outline: Compute price with tax and discount in different states
    When I order <items> items with price <price> to be delivered in state <state>
    Then the order basic price is <basic_price>
    And the discount rate is <discount_rate>
    And the discount amount is <discount_amount>
    And the discounted price is <discounted_price>
    And the tax rate is <tax_rate>
    And the tax amount is <tax_amount>
    And the price with tax is <price_with_tax>

    Examples:
      | items | price | basic_price | discount_rate | discount_amount | discounted_price | state | tax_rate | tax_amount | price_with_tax |
      | 3     | 5$    | 15.00$      | 0.00%         | 0.00$           | 15.00$           | UT    | 6.85%    | 1.03$      | 16.03$         |
      | 20    | 50$   | 1000.00$    | 3.00%         | 30.00$          | 970.00$          | UT    | 6.85%    | 66.45$     | 1036.44$       |
      | 50    | 100$  | 5000.00$    | 5.00%         | 250.00$         | 4750.00$         | NV    | 8.00%    | 380.00$    | 5130.00$       |
      | 70    | 100$  | 7000.00$    | 7.00%         | 490.00$         | 6510.00$         | CA    | 8.25%    | 537.08$    | 7047.08$       |
      | 100   | 100$  | 10000.00$   | 10.00%        | 1000.00$        | 9000.00$         | AL    | 4.00%    | 360.00$    | 9360.00$       |
      | 1000  | 100$  | 100000.00$  | 15.00%        | 15000.00$       | 85000.00$        | TX    | 6.25%    | 5312.50$   | 90312.50$      |
