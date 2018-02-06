Feature: Order Price
  An Order will compute its final price

  Background:
  I have a new, empty Order

  Scenario Outline: Compute basic price
    When I order <items> items with price <price>
    Then the order basic price is <basic_price>

    Examples:
      | items | price | basic_price |
      | 0     | 0$    | 0,00$          |
      | 5     | 0$    | 0,00$          |
      | 0     | 5$    | 0,00$          |
      | 3     | 5$    | 15,00$         |


#  Scenario Outline: Compute price with tax in UT
#    When I order <items> items with price <price>$ to be delivered in UT
#    Then the order basic price is <basic_price>$
#    And the price with tax is <price_with_tax>$
#
#    Examples:
#      | items | price | basic_price | price_with_tax |
#      | 3     | 5     | 15          | 16.03           |
