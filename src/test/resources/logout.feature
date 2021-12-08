# TODO: implement test steps

  # - when logged in logout button available
  # - functions unavailable when logged out
  # - homepage available

Feature: Logout
  There is a logged out state in which only homepage and login are available

  Scenario: Successful logout
    Given user is logged out
    When I click logout button
    Then user should be logged in

  Scenario Outline: Only specific functions are available
    Given user is logged out
    When I click "<function>" button
    Then the availability of "<function>" should be set to "<available>"

    Examples:
    | function        | available |
    | login           | true      |
    | home            | true      |
    | employee list   | false     |
    | create employee | false     |
    | transaction     | false     |