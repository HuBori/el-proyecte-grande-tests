# TODO: implement test steps

  # - when logged out login function available
  # - invalid login when invalid or empty username or password
  # - valid login when valid username and password
  # - invalid login when username and password does not match
  # - stays logged in after page closed and reopened (but not when server restarted)

Feature: Login
  In logged out state login is available, login not allowed unless valid username-password pair given

  Background:
    Given user is logged out

  Scenario Outline: Empty username or password
    Given login credentials are filled with "<username>" and "<password>"
    When I click login button
    Then user should not be logged in

    Examples:
      | username  | password  |
      | empty     | valid     |
      | valid     | empty     |

  Scenario Outline: Invalid pair of username and password
    Given login credentials are filled with "<username>" and "<password>"
    When I click login button
    Then user should not be logged in

    # TODO: pair values to keys: valid, invalid, other (for both username and password)
    Examples:
      | username  | password  |
      | invalid   | valid     |
      | valid     | invalid   |
      | other     | valid     |
      | valid     | other     |

  Scenario: Valid login
    Given user is logged out
    Given login credentials are filled with "valid" and "valid"
    When I click login button
    Then user is logged in

  Scenario Outline: All functions are available
    Given user is logged in
    When I click "<function>" button
    Then the availability of "<function>" should be set to "true"

    Examples:
      | function        |
      | login           |
      | home            |
      | employee list   |
      | create employee |
      | transaction     |


# TODO: add tests that cover bugs: 2, 3, 4
Feature: Login state after refresh
  Login state should match before and after refresh

  Scenario: Stays logged in after refresh
    Given user is logged in
    When I refresh current page
    Then user should be logged in

  Scenario: Stays logged out after refresh
    Given user is logged out
    When I refresh current page
    Then user should not be logged in


Feature: Secondary login
  After clicking one of the menu items in a logged out state, the same login form should appear, preventing access

  Background:
    Given user is logged out
    When I click "<function>" button
    Then login form should be open

  Scenario Outline: menu option clicked
    Given login credentials are filled with "valid" and "valid"
    When I click login button
    Then "<function>" page should be open

    Examples:
      | function        |
      | home            |
      | employee list   |
      | create employee |
      | transaction     |