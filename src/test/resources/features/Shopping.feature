
Feature: Place Order

  Scenario: user add first item
    Given user navigate to web page
    When search "pink" item
    And add "pink" item
    When search "dress" item
    And add "dress" item
    When user filling billing detail
    And user place order
    Then validate "valid" scenario