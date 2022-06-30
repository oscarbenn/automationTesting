@smokeFeature
Feature: login

  Background: browser is navigated to login page
    Given user is on login page
    Then check if user is on login page

  @smoke @loginvalid
  Scenario: Check login is successful with valid credentials
    When user enters graes14@gmail.com and soeta97
    And user clicks on login button
    Then user is navigated to dashboard

  @smoke @logininvalid
  Scenario: Check login with invalid credentials
    When user enters graes15@gmail.com and pasweut98
    And user clicks on login button
    Then message error is displayed
