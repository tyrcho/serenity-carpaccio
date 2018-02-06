@issues:SDCOAGTM18-30,SDCOAGTM18-31
Feature: Cups

  Optional description of the feature

  Background:
    I have 0 cukes in my belly

  @issues:SDCOAGTM18-12
  Scenario: a few cukes
    Given I eat 42 cukes
    When I wait 60 minutes
    Then my belly should growl

  Scenario: hungry at startup
    Given I eat 0 cukes
    When I wait 0 minutes
    Then my belly should growl

  @issues:SDCOAGTM18-15
  Scenario: well fed
    Given I eat 5 cukes
    When I wait 3 minutes
    Then my belly should not growl