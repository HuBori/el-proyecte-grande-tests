Feature: Logout
  There is a logged out state in which only homepage and login are available

  Background:
    Given is on url

  Scenario: Successful logout
    Given user is logged in
    When I click "logout" button
    Then user should not be logged in

  Scenario Outline: Only specific functions are available
    Given user is logged out
    When I click "<function>" button
    Then "<function>" page should be "<available>"

    Examples:
      | function        | available |
      | home            | true      |
      | employee list   | false     |
      | create employee | false     |
      | transaction     | false     |