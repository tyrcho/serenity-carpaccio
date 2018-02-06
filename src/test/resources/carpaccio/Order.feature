Feature: Order Price
  An Order will compute its final price

  Background:
  I have a new, empty Order

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

    Examples:
      | items | price | basic_price | state | tax_rate | tax_amount | price_with_tax |
      | 3     | 5$    | 15.00$      | UT    | 6.85%    | 1.03$      | 16.03$         |
      | 8     | 1.45$ | 11.60$      | NV    | 8.00%    | 0.93$      | 12.53$         |
      | 2     | 5$    | 10.00$      | TX    | 6.25%    | 0.63$      | 10.63$         |
      | 2     | 5$    | 10.00$      | AL    | 4.00%    | 0.40$      | 10.40$         |
      | 2     | 5$    | 10.00$      | CA    | 8.25%    | 0.83$      | 10.83$         |
