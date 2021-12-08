Feature: List All Employees

  Background: User is Logged In
    Given I navigate to the login page
    When I submit "username" and "password"
    Then I should be logged in

  Scenario: Check employees number
    Given I am on list all employees page
    And I have "number" of employees
    Then I should see that "number" as total number of employees

  Scenario Outline: Filter Employees By Name
    Given I am on list all employees page
    When I search for "<String>" in the search bar
    Then I should see the search results "<valid>"

    Examples:
      | String          | valid |
      | Teszt Elek      | true  |
      | Minta Aladár    | true  |
      | Rex Middleton   | true  |
      | nonexistentname | false |

  Scenario Outline: Next button
    Given I have "number" of employees
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


