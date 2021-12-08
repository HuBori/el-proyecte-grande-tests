# TODO: implement test steps

  # - when logged out login function available
  # - invalid login when invalid or empty username or password
  # - valid login when valid username and password
  # - invalid login when username and password does not match
  # - stays logged in after page closed and reopened (but not when server restarted)

Feature: Login
  In logged out state login is available, login not allowed unless valid username-password pair given

  Background:
    Given user should be logged out

  Scenario Outline: Empty username or password
    Given username and password should be "<username>" and "<password>"
    When click login button
    Then user is logged in: "false"

    Examples:
      | username  | password  |
      | empty     | valid     |
      | valid     | empty     |

  Scenario Outline: Invalid pair of username and password
    Given username and password should be "<username>" and "<password>"
    When click login button
    Then user is logged in: "false"

    # TODO: pair values to keys: valid, invalid, other (for both username and password)
    Examples:
      | username  | password  |
      | invalid   | valid     |
      | valid     | invalid   |
      | other     | valid     |
      | valid     | other     |

  Scenario: Valid login
    Given user should be logged out
    Given username and password should be "<username>" and "<password>"
    When click login button
    Then user is logged in: "true"

  Scenario Outline: All functions are available
    Given user should be logged in
    When click "<function>" button
    Then the availability of "<function>" is set to "true"

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
    Given user should be logged in
    When refresh current page
    Then user is logged in: "true"

  Scenario: Stays logged out after refresh
    Given user should be logged out
    When refresh current page
    Then user is logged in: "false"


Feature: Secondary login
  After clicking one of the menu items in a logged out state, the same login form should appear, preventing access

  Background:
    Given user should be logged out
    When click "<function>" button
    Then login form is open

  Scenario Outline: menu option clicked
    Given username and password should be "valid" and "valid"
    When click login button
    Then "<function>" page should be open

    Examples:
      | function        |
      | home            |
      | employee list   |
      | create employee |
      | transaction     |