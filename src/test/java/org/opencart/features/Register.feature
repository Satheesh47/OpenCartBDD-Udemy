Feature: Registration functionality

  Scenario: User creates an account only with mandatory fields
    Given User navigates to Register page
    And User enters the details into below fields
      | firstName | Abcdef              |
      | lastName  | Fedcba              |
      | telephone | 1234567890          |
      | password  | Tester@2024         |
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully

  Scenario:User creates an account only with all fields
    Given User navigates to Register page
    And User enters the details into below fields
      | firstName | Abcdef              |
      | lastName  | Fedcba              |
      | telephone | 1234567890          |
      | password  | Tester@2024         |
    And User selects Yes for Newsletter
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully

  Scenario:User creates a duplicate account
    Given User navigates to Register page
    And User enters the details into below fields with duplicate email
      | firstName | Abcdef                  |
      | lastName  | Fedcba                  |
      | email     | satheesh.it47@gmail.com |
      | telephone | 1234567890              |
      | password  | Tester@2024             |
    And User selects Yes for Newsletter
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User should get a proper warning about duplicate email

  Scenario: User creates an account without filling any details
    Given User navigates to Register page
    When User dont enter any details into fields
    And User clicks on Continue button
    Then User should get a proper warning messages for every mandatory field