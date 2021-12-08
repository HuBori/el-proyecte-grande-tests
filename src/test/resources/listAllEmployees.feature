Feature: List All Employees

  Background: User is Logged In
    Given I navigate to the login page
    When I submit "username" and "password"
    Then I should be logged in

  Scenario: Check employees number
    Given I am on list all employees page
    # WARNING hardcoded number somehow make it automatic (maybe get actual database count? notice deleted status)
    And I have 23 of employees
    Then I should see 23 as total number of employees

  Scenario Outline: Filter All Employees By Name
    Given I am on list all employees page
    When I search for "<name>" in the search bar
    Then I should see the search results "<name>" "<valid>"

    Examples:
      | name            | valid |
      | Teszt Elek      | true  |
      | Minta Aladár    | true  |
      | Rex Middleton   | true  |
      | nonexistentname | false |

  Scenario Outline: Next button
        # WARNING hardcoded number somehow make it automatic (maybe get actual database count? notice deleted status)
    Given I have 23 of employees
    And 23 is bigger than "<People per page>"
    Then next button should be active
    When I press next button
    Then table content should change
    Examples:
      | People per page |
      | 20              |

  Scenario: Prev button
    Given next button should be active
    When I press next button
    Then prev button should be active
    When I press prev button
    Then table content should change


