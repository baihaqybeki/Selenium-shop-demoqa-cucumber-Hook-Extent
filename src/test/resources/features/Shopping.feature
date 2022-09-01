
Feature: Place Order

  Scenario: user add item
  	When user navigate web page
    And search "pink" item
    And add "pink" item
    And search "dress" item
    And add "dress" item
    And user filling billing detail
    And user place order
    Then validate "valid" scenario