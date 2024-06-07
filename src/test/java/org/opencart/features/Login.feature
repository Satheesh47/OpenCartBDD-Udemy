Feature: Login functionality

  Scenario Outline: Login with valid credentials
    Given User navigates to Login page
    When User enters valid email address <username> into email field
    And User enters valid password <password> into password field
    And User clicks on Login button
    Then User should get successfully logged in
    Examples:
      | username                | password    |
      | satheesh.it47@gmail.com | Tester@2024 |
      | satheesh.it48@gmail.com | Tester@2024 |
      | satheesh.it49@gmail.com | Tester@2024 |

  Scenario: Login with invalid credentials
    Given User navigates to Login page
    When User enters invalid email address into email field
    And User enters invalid password address "123456" into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch

  Scenario: Login with valid email and invalid password
    Given User navigates to Login page
    When User enters valid email address "satheesh.it47@gmail.com" into email field
    And User enters invalid password address "123456" into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch

  Scenario: Login with invalid email and valid password
    Given User navigates to Login page
    When User enters invalid email address into email field
    And User enters valid password "Tester@2024" into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch

  Scenario: Login without providing any credentials
    Given User navigates to Login page
    When User dont enter email address into email field
    And User dont enter password into password field
    And User clicks on Login button
    Then User should get a proper warning message about blank credentials