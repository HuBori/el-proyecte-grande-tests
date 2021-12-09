Feature: List All Employees

  Background: User is Logged In
    Given is on url
    When i click on all employees
    Then user is promted to log in

  Scenario: Check employees number
    # WARNING hardcoded number somehow make it automatic (maybe get actual database count? notice deleted status)
    Given I have x of employees
    Then I should see "number" as total number of employees

  Scenario Outline: employee data available by clicking their name
    Given employee "<name>" is present in the list
    When I click on "<name>"
    Then I should be redirected to "<URL>" and displayed "<name>" is valid
    Examples:
      | name       | URL |
      | Teszt Elek |   http://localhost:3000/employee/4f686345-c130-ef8c-ef96-d8874c3a9b9e  |

  Scenario Outline: Filter All Employees By Name
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
    Given I have x of employees
    And "number" is bigger than "<People per page>"
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


