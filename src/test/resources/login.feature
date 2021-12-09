Feature: Login
  In logged out state login is available, login not allowed unless valid username-password pair given

  Background:
    Given is on url
    And user is logged out

  Scenario: Valid login
    Given login credentials are filled with "valid" and "valid"
    When I click login button
    Then user should be logged in

  Scenario Outline: All functions are available
    Given user is logged in
    When I click "<function>" button
    Then "<function>" page should be open

    Examples:
      | function        |
      | home            |
      | employee list   |
      | create employee |
      | transaction     |

  Scenario Outline: menu option clicked
    When I click "<function>" button
    Given login credentials are filled with "valid" and "valid"
    When I click login button
    Then "<function>" page should be open

    Examples:
      | function        |
      | home            |
      | employee list   |
      | create employee |
      | transaction     |

  Scenario Outline: Empty username or password
    Given login credentials are filled with "<username>" and "<password>"
    When I click login button
    Then user should not be logged in
    And close login form

    Examples:
      | username  | password  |
      | empty     | valid     |
      | valid     | empty     |

  Scenario Outline: Invalid pair of username and password
    Given login credentials are filled with "<username>" and "<password>"
    When I click login button
    Then user should not be logged in

    Examples:
      | username  | password  |
      | invalid   | valid     |
      | valid     | invalid   |

  Scenario: Stays logged in after refresh
    Given user is logged in
    When I refresh current page
    Then user should be logged in

  Scenario: Stays logged out after refresh
    When I refresh current page
    Then user should not be logged in