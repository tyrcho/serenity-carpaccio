@issues:SDCOAGTM18-1
Feature: Order Price
  An Order will compute its final price

  Background:
  I have a new, empty Order

  @issues:SDCOAGTM18-6
  Scenario Outline: Compute basic price
    When I order <items> items with price <price>
    Then the order basic price is <basic_price>

    Examples:
      | items | price | basic_price |
      | 0     | 0$    | 0.00$       |
      | 5     | 0$    | 0.00$       |
      | 0     | 5$    | 0.00$       |
      | 3     | 5$    | 15.00$      |


  Scenario Outline: Compute price with tax in UT
    When I order <items> items with price <price> to be delivered in UT
    Then the order basic price is <basic_price>
    And the tax rate is <tax_rate>
    And the tax amount is <tax_amount>
    And the price with tax is <price_with_tax>

    Examples:
      | items | price | basic_price | tax_rate | tax_amount | price_with_tax |
      | 3     | 5$    | 15.00$      | 6.85%    | 1.03$      | 16.03$         |
      | 8     | 1.45$ | 11.60$      | 6.85%    | 0.79$      | 12.39$         |

  Scenario Outline: Compute price with tax in different states
    When I order <items> items with price <price> to be delivered in state <state>
    Then the order basic price is <basic_price>
    And the tax rate is <tax_rate>
    And the tax amount is <tax_amount>
    And the price with tax is <price_with_tax>

    # In all the examples we are below the threshold for the discounts
    Examples:
      | items | price | basic_price | state | tax_rate | tax_amount | price_with_tax |
      | 3     | 5$    | 15.00$      | UT    | 6.85%    | 1.03$      | 16.03$         |
      | 8     | 1.45$ | 11.60$      | NV    | 8.00%    | 0.93$      | 12.53$         |
      | 2     | 5$    | 10.00$      | TX    | 6.25%    | 0.63$      | 10.63$         |
      | 2     | 5$    | 10.00$      | AL    | 4.00%    | 0.40$      | 10.40$         |
      | 2     | 5$    | 10.00$      | CA    | 8.25%    | 0.83$      | 10.83$         |

  @issues:SDCOAGTM18-11
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
