# TODO: implement test steps

  # - when logged in logout button available
  # - functions unavailable when logged out
  # - homepage available

Feature: Logout
  There is a logged out state in which only homepage and login are available

  Scenario: Successful logout
    Given user should be logged in
    When click logout button
    Then user is logged in: "false"

  Scenario Outline: Only specific functions are available
    Given user should be logged out
    When click "<function>" button
    Then the availability of "<function>" is set to "<available>"

    Examples:
      | function        | available |
      | home            | true      |
      | employee list   | false     |
      | create employee | false     |
      | transaction     | false     |