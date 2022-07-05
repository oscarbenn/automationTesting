@smokeFeature
Feature: jqueryui

  @drag
  Scenario: check draggable functionality
    Given user is on draggable page
    Then check if user is on draggable page
    Given pointer get to draggable element
    When user action drag 100 to right and 50 to bottom
    Then element move 100 to right and 50 to bottom

  @drop
  Scenario: check droppable functionality
    Given user is on droppable page
    Then check if user is on droppable page
    Given pointer get to element
    When user action drag and drop draggable element to droppable element
    Then draggable element move in to droppable element

  @resize
  Scenario: check resizable functionality
    Given user is on resizable page
    Then check if user is on resizable page
    Given pointer get to resizable element
    When user action drag resizable element 100 to right and 50 to bottom
    Then object size is changed
