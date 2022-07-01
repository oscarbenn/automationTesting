@smokeFeature
Feature: draggable

  Background: browser is navigated to draggable page
    Given user is on draggable page
    Then check if user is on draggable page

  @smoke
  Scenario: check draggable functionality
    Given pointer get to draggable element
    When user action drag 100 to right
    Then element move 100 to right
