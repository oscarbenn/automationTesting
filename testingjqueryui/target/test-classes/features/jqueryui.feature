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
    Given user is on checkboxradio page
    Then check if user is on checkboxradio page
    Given pointer get to checkbox elements
    When user click the "4 Star" option
    Then opsion is checked and colored "rgba(0, 127, 255, 1)"

  @radio
  Scenario: check radio functionality
    Given user is on checkboxradio page
    Then check if user is on checkboxradio page
    Given pointer get to radio elements
    When user click the "New York" radio option
    Then option is checked and colored "rgba(0, 127, 255, 1)"

  @datepicker
  Scenario: check datepicker functionality
    Given user is on datepicker page
    Then check if user is on datepicker page
    Given pointer get to datepicker elements
    When user click the datepicker element
    And user look for day "17" month "August" year "2023"
    Then date is checked and colored "rgba(0, 127, 255, 1)"

  @dialoganimated
  Scenario: check dialoganimated functionality
    Given user is on dialoganimated page
    Then check if user is on dialoganimated page
    Given pointer get to dialoganimated elements
    When user click the open dialog button
    Then dialog basic dialog is displayed

  @menu
  Scenario: check menu functionality
    Given user is on menu page
    Then check if user is on menu page
    Given pointer get to menu elements
    When user hover mouse to "Electronics" menu
    Then 3 sub-menu is displayed

  @selectmenu
  Scenario: check selectmenu functionality
    Given user is on selectmenu page
    Then check if user is on selectmenu page
    Given pointer get to selectmenu elements
    When user select speed as "Faster"
    Then "Faster" option is selected
  
  @selectmenuproduct
  Scenario: check selectmenuproduct radius functionality
    Given user is on selectmenuproduct page
    Then check if user is on selectmenuproduct page
    Given pointer get to select menu elements
    When user click select radius circle 250 px with color "Blue"
    Then circle size is changed to radius 250 px with color "rgba(0, 0, 255, 1)"

  @progressbar
  Scenario: check progressbar download functionality
    Given user is on progressbar download page
    Then check if user is on progressbar download page
    Given pointer get to  button dowloading elements
    When user click the button dowloading
    Then progressbar download is displayed until "Complete!"

  @spinner
    Scenario: check spinner functionality
      Given user is on spinner page
      Then check if user is on spinner page
      Given pointer get the elements
      When user click spinner up 8 times
      Then spinner value is 8
      When user click spinner down 5 times
      Then spinner value is 3

  @slider
  Scenario: check slider functionality
    Given user is on slider page
    Then check if user is on slider page
    Given pointer get the slider elements
    When user drag slider to 50%
    Then slider value is 50%

  @tooltip
  Scenario: check tooltip functionality
    Given user is on tooltip page
    Then check if user is on tooltip page
    Given pointer get the frame
    When user hover pointer to element input
    Then tooltip is displayed

