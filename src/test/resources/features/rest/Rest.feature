Feature: Rest API

  How to test a rest API from cucumber with 'rest assured'.
  #See https://api.abalin.net/#today

  Scenario Outline: Get a nameday
    When I ask nameday in country <country_code> for <day>/<month>
    Then I get the name <name>
    Examples:
      | country_code | day | month | name   |
      | it           | 21  | 10    | Orsola |
      | fr           | 05  | 08    | Abel   |

