  # - when logged out login function available
  # - invalid login when invalid or empty username or password
  # - valid login when valid username and password
  # - invalid login when username and password does not match
  # - stays logged in after page closed and reopened (but not when server restarted)
# Created by én at 2021. 12. 07.
Feature: Login
  In logged out state login is available, login not allowed unless valid username-password pair given

  Background:
    Given user should be logged out

  Scenario Outline: Empty username or password
    Given username and password should be "<username>" and "<password>"
    When click login button
    Then login is NOT successful

    Examples:
      | username  | password  |
      | empty     | valid     |
      | valid     | empty     |

  Scenario Outline: Invalid pair of username and password
    Given username and password should be "<username>" and "<password>"
    When click login button
    Then login is NOT successful

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
    Then login is successful


# TODO: add tests that cover bugs: 2, 3, 4
Feature: Login state after refresh
  Login state should match before and after refresh

  Scenario: Stays logged in after refresh
    Given user should be logged in
    When refresh current page
    Then login is successful

  Scenario: Stays logged out after refresh
    Given user should be logged out
    When refresh current page
    Then login is NOT successful