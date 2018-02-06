Feature: Order Price
  An Order will compute its final price

  Background:
  I have a new, empty Order

  Scenario Outline: Compute basic price
    When I order <items> items with price <price>$
    Then the order basic price is <basic_price>$

    Examples:
      | items | price | basic_price |
      | 0     | 0     | 0           |
      | 5     | 0     | 0           |
      | 0     | 5     | 0           |
      | 3     | 5     | 15          |
