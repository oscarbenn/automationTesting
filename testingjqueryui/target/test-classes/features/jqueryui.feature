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

  @select
  Scenario: check selectable one functionality
    Given user is on selectable page
    Then check if user is on selectable page
    Given pointer get to selectable elements
    When user action click on element 1
    Then element 1 is colered "rgba(243, 152, 20, 1)"

  @select
  Scenario: check selectable many with ctrl key functionality
    Given user is on selectable page
    Then check if user is on selectable page
    Given pointer get to selectable elements
    When user action click on element 1 element 3 and element 5 with ctrl key
    Then element 1 element 3 and element 5 is colered "rgba(243, 152, 20, 1)"

  @select
  Scenario: check selectable many with swipe functionality
    Given user is on selectable page
    Then check if user is on selectable page
    Given pointer get to selectable elements
    When user action click and drag from element 2 to element 4
    Then element 2 element 3 and element 4 is colered "rgba(243, 152, 20, 1)"

  @sort
  Scenario: check sortable functionality
    Given user is on sortable page
    Then check if user is on sortable page
    Given pointer get to sortable elements
    When user action click and drag element 4 be first element
    Then element 4 is moved

  @autocomplete
  Scenario: check autocomplete functionality
    Given user is on autocomplete page
    Then check if user is on autocomplete page
    Given pointer get to autocomplete elements
    When user typing "Script" on element
    Then element give 3 opsi

  @checkbox
  Scenario: check checkbox functionality
    Given user is on checkbox page
    Then check if user is on checkbox page
    Given pointer get to checkbox elements
    When user click the "5 Star" option
    Then opsion is checked and colored "rgba(0, 127, 255, 1)"

