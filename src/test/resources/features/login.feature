@TrackNinja
Feature: Validate sign up functionality

  @SignUp
  Scenario: User should be able to Create Account
    Given User click on sign in with your email button
    And   User click on create account Button on sign in page
    When  User enter valid email id password and confirm password on sign up page
      | email                       | password  | confirmPassword |
      | seasiaInfote4118@gmail.com | 987654321 | 987654321       |
    And   User click on create account Button on sign up page
    And User click on allow only while using this app to trackNinja to access this device's location
    Then verify Home text on home page

  @SignUpNewAccount
  Scenario: As a user I should be able to login with newly created account
    Given User click on sign in with your email button
    And   User click on create account Button on sign in page
    When  User enter random email id password and confirm password on sign up page
    And   User click on create account Button on sign up page
    Then verify Home text on home page

  @Login
  Scenario: Login successfully with valid credentials
    Given User click on sign in with your email button
    When User enter valid email id and password
      | email                         | password  |
      | seasiaInfoth63448@gmail.com | 987654321 |
    And User click on login button
    Then Validate user is navigated to home page and verify Home text
    Then User click on add your vehicle button
    And User is displayed "BASIC INFO" screen
    When User enter "2021" in YEAR field
    And User enter "BMW" in MAKE field
    And User enter "Z4" in MODEL field
    Then User Click on next button


