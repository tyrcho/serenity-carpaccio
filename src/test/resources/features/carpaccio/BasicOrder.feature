@version:Release-1
Feature: Basic Order Price

  An Order will compute its price without taxes and discounts

  @issues:SDCOAGTM18-6
  @version:Sprint-1
  Scenario Outline: Compute basic price
    When I order <items> items with price <price>
    Then the order basic price is <basic_price>

    Examples:
      | items | price | basic_price |
      | 0     | 0$    | 0.00$       |
      | 5     | 0$    | 0.00$       |
      | 0     | 5$    | 0.00$       |
      | 3     | 5$    | 15.00$      |
