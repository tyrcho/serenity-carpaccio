Feature: Order Price
  An Order will compute its final price

  Background:
    I have a new, empty Order

  Scenario: Compute basic price
    When I order 0 items with price 0$
    Then the order basic price is 0$

  Scenario: Compute basic price 2
    When I order 5 items with price 3$
    Then the order basic price is 15$
