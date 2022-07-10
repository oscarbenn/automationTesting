package stepDefinitions;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.AutocompletePage;
import pageObject.CheckboxradioPage;
import pageObject.DatepickerPage;
import pageObject.DialoganimatedPage;
import pageObject.DraggablePage;
import pageObject.DroppablePage;
import pageObject.MenuPage;
import pageObject.ProgressbarPage;
import pageObject.ResizablePage;
import pageObject.SelectablePage;
import pageObject.SliderPage;
import pageObject.SortablePage;
import pageObject.SpinnerPage;
import pageObject.TooltipPage;

public class JqueryuiStep {

    public WebDriver driver = null;
    DraggablePage draggablePage;
    DroppablePage droppablePage;
    ResizablePage resizablePage;
    SelectablePage selectablePage;
    SortablePage sortablePage;
    AutocompletePage autocompletePage;
    CheckboxradioPage checkboxradioPage;
    DatepickerPage datepickerPage;
    DialoganimatedPage dialoganimatedPage;
    MenuPage menuPage;
    TooltipPage tooltipPage;
    ProgressbarPage progressbarPage;
    SpinnerPage spinnerPage;
    SliderPage sliderPage;

    Actions actions = null;
    Point positionFirst, positionLast;
    Point dropLocation, dragLocation;
    String ActualTitle, ExpectedTitle;
    WebElement element;

    @Before
    public void browserSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }

    @After
    public void teardown(){
        driver.close();
        driver.quit();
    }

    @Given("user is on draggable page")
    public void user_is_on_draggable_page() {
        driver.get("https://jqueryui.com/draggable/");
    }

    @Then("check if user is on draggable page")
    public void check_if_user_is_on_draggable_page() {
        draggablePage = new DraggablePage(driver);
        ActualTitle = driver.getTitle();
        ExpectedTitle = "Draggable | jQuery UI";
        assertEquals(ExpectedTitle, ActualTitle);
    }

    @Given("pointer get to draggable element")
    public void pointer_get_to_draggable_element() {
        draggablePage.switchToFrame();
        draggablePage.moveToElement();
    }

    @When("user action drag {int} to right and {int} to bottom")
    public void user_action_drag_to_right(Integer x, Integer y) {
        positionFirst = draggablePage.getLocation();
        draggablePage.move(x, y);
    }

    @Then("element move {int} to right and {int} to bottom")
    public void element_move_to_right(Integer x, Integer y) {
        positionLast = draggablePage.getLocation();
        int x1 = positionFirst.getX();
        int y1 = positionFirst.getY();
        int x2 = positionLast.getX();
        int y2 = positionLast.getY();
        assertTrue(x2-x1==x);
        assertTrue(y2-y1==y);
    }

    @Given("user is on droppable page")
    public void user_is_on_droppable_page() {
        driver.get("https://jqueryui.com/droppable/");
    }
    @Then("check if user is on droppable page")
    public void check_if_user_is_on_droppable_page() {
        droppablePage = new DroppablePage(driver);
        ActualTitle = driver.getTitle();
        ExpectedTitle = "Droppable | jQuery UI";
        assertEquals(ExpectedTitle, ActualTitle);
    }
    @Given("pointer get to element")
    public void pointer_get_to_element() {
        droppablePage.switchToFrame();
        droppablePage.foundElement();
    }
    @When("user action drag and drop draggable element to droppable element")
    public void user_action_drag_and_drop_draggable_element_to_droppable_element() {
        dropLocation = droppablePage.getDropLocation();
        droppablePage.moveToTarget();
        dragLocation = droppablePage.getDragLocation();
    }
    @Then("draggable element move in to droppable element")
    public void draggable_element_move_in_to_droppable_element() {
        String ActualText = droppablePage.isElementDropped();
        String ExpectedText = "Dropped!";
        assertEquals(ExpectedText, ActualText);
    }

    @Given("user is on resizable page")
    public void user_is_on_resizable_page() {
        driver.get("https://jqueryui.com/resizable/");
    }
    @Then("check if user is on resizable page")
    public void check_if_user_is_on_resizable_page() {
        resizablePage = new ResizablePage(driver);
        ActualTitle = driver.getTitle();
        ExpectedTitle = "Resizable | jQuery UI";
        assertEquals(ExpectedTitle, ActualTitle);

    }
    @Given("pointer get to resizable element")
    public void pointer_get_to_resizable_element() {
        resizablePage.switchToFrame();
        resizablePage.moveToElement();
    }
    @When("user action drag resizable element {int} to right and {int} to bottom")
    public void user_action_drag_resizable_element_to_right_and_to_bottom(Integer int1, Integer int2) {
        resizablePage.move(int1, int2);
    }
    @And("object size is changed")
    public void object_size_is_changed() {
        resizablePage.isSizeChange();
    }

    @Given("user is on selectable page")
    public void user_is_on_selectable_page() {
        driver.get("https://jqueryui.com/selectable/");
    }
    @Then("check if user is on selectable page")
    public void check_if_user_is_on_selectable_page() {
        selectablePage = new SelectablePage(driver);
        ActualTitle = driver.getTitle();
        ExpectedTitle = "Selectable | jQuery UI";
        assertEquals(ExpectedTitle, ActualTitle);
    }
    @Given("pointer get to selectable elements")
    public void pointer_get_to_selectable_elements() {
        selectablePage.switchToFrame();
        selectablePage.getElements();
    }
    @When("user action click on element {int}")
    public void user_action_click_on_element(Integer index) {
        selectablePage.clickElement(index);
    }
    @Then("element {int} is colered {string}")
    public void element_is_colered(Integer index, String color) {
        String colorActual = selectablePage.checkColor(index);
        String colorExpected = color;
        assertEquals(colorExpected, colorActual);
    }

    @When("user action click on element {int} element {int} and element {int} with ctrl key")
    public void user_action_click_on_element_element_and_element_with_ctrl_key(Integer index1, Integer index2, Integer index3) {
        selectablePage.clickElements(index1, index2, index3);
    }
    @Then("element {int} element {int} and element {int} is colered {string}")
    public void element_element_and_element_is_colered(Integer index1, Integer index2, Integer index3, String color) {
        String colorActual = selectablePage.checkColor(index1);
        String colorExpected = color;
        assertEquals(colorExpected, colorActual);
        colorActual = selectablePage.checkColor(index2);
        assertEquals(colorExpected, colorActual);
        colorActual = selectablePage.checkColor(index3);
        assertEquals(colorExpected, colorActual);
    }

    @When("user action click and drag from element {int} to element {int}")
    public void user_action_click_and_drag_from_element_to_element(Integer index1, Integer index2) {
        selectablePage.selectSwipe(index1, index2);
    }

    @Given("user is on sortable page")
    public void user_is_on_sortable_page() {
        driver.get("https://jqueryui.com/sortable/");
    }
    @Then("check if user is on sortable page")
    public void check_if_user_is_on_sortable_page() {
        sortablePage = new SortablePage(driver);
        ActualTitle = driver.getTitle();
        ExpectedTitle = "Sortable | jQuery UI";
        assertEquals(ExpectedTitle, ActualTitle);
    }
    @Given("pointer get to sortable elements")
    public void pointer_get_to_sortable_elements() {
        sortablePage.switchToFrame();
        sortablePage.getElements();
    }
    @When("user action click and drag element {int} be first element")
    public void user_action_click_and_drag_element_be_first_element(Integer index) {
        element = sortablePage.getElement(index);
        sortablePage.moveElementToTop(index);
    }
    @Then("element {int} is moved")
    public void element_is_moved(Integer index) {
        sortablePage.getElements();
        WebElement unexpectedElement = element;
        WebElement actualElement = sortablePage.getElement(index);
        assertNotEquals(unexpectedElement, actualElement);
    }

    @Given("user is on autocomplete page")
    public void user_is_on_autocomplete_page() {
        driver.get("https://jqueryui.com/autocomplete/");
    }
    @Then("check if user is on autocomplete page")
    public void check_if_user_is_on_autocomplete_page() {
        autocompletePage = new AutocompletePage(driver);
        ActualTitle = driver.getTitle();
        ExpectedTitle = "Autocomplete | jQuery UI";
        assertEquals(ExpectedTitle, ActualTitle);
    }
    @Given("pointer get to autocomplete elements")
    public void pointer_get_to_autocomplete_elements() {
        autocompletePage.switchToFrame();
    }
    @When("user typing {string} on element")
    public void user_typing_on_element(String word) {
        autocompletePage.typing(word);
        autocompletePage.getElements();
    }
    @Then("element give {int} opsi")
    public void element_give_opsi(Integer number) {
        assertTrue(autocompletePage.numberElement()==number);
    }

    @Given("user is on checkboxradio page")
    public void user_is_on_checkboxradio_page() {
        driver.get("https://jqueryui.com/checkboxradio/");
    }
    @Then("check if user is on checkboxradio page")
    public void check_if_user_is_on_checkboxradio_page() {
        checkboxradioPage = new CheckboxradioPage(driver);
        ActualTitle = driver.getTitle();
        ExpectedTitle = "Checkboxradio | jQuery UI";
        assertEquals(ExpectedTitle, ActualTitle);
    }
    @Given("pointer get to checkbox elements")
    public void pointer_get_to_checkbox_elements() {
        checkboxradioPage.switchToFrame();
        checkboxradioPage.getElements();
    }
    @When("user click the {string} option")
    public void user_click_the_option(String opsi) {
        checkboxradioPage.choose(opsi);
    }
    @Then("opsion is checked and colored {string}")
    public void opsion_is_checked_and_colored(String color) {
        assertEquals(color, checkboxradioPage.colorOpsi());
    }

    @Given("pointer get to radio elements")
    public void pointer_get_to_radio_elements() {
        checkboxradioPage.switchToFrame();
        checkboxradioPage.getRadios();
    }
    @When("user click the {string} radio option")
    public void user_click_the_radio_option(String radio) {
        checkboxradioPage.chooseRadio(radio);
    }
    @Then("option is checked and colored {string}")
    public void option_is_checked_and_colored(String color) {
        assertEquals(color, checkboxradioPage.colorRadio());
    }

    @Given("user is on datepicker page")
    public void user_is_on_datepicker_page() {
        driver.get("https://jqueryui.com/datepicker/");
    }
    @Then("check if user is on datepicker page")
    public void check_if_user_is_on_datepicker_page() {
        datepickerPage = new DatepickerPage(driver);
        ActualTitle = driver.getTitle();
        ExpectedTitle = "Datepicker | jQuery UI";
        assertEquals(ExpectedTitle, ActualTitle);
    }
    @Given("pointer get to datepicker elements")
    public void pointer_get_to_datepicker_elements() {
        datepickerPage.switchToFrame();
        datepickerPage.getElement();
    }
    @When("user click the datepicker element")
    public void user_click_the_datepicker_element() {
        datepickerPage.clickDatepicker();
    }
    @And("user look for day {string} month {string} year {string}")
    public void user_look_for_day_month_year(String day, String month, String year) {
        datepickerPage.selectDate(day, month, year);
    }
    @Then("date is checked and colored {string}")
    public void date_is_checked_and_colored(String color) {
        assertEquals(color, datepickerPage.colorDate());
    }

    @Given("user is on dialoganimated page")
    public void user_is_on_dialoganimated_page() {
        driver.get("https://jqueryui.com/dialog/#animated");
    }
    @Then("check if user is on dialoganimated page")
    public void check_if_user_is_on_dialoganimated_page() {
        dialoganimatedPage = new DialoganimatedPage(driver);
        ActualTitle = driver.getTitle();
        ExpectedTitle = "Dialog | jQuery UI";
        assertEquals(ExpectedTitle, ActualTitle);
    }
    @Given("pointer get to dialoganimated elements")
    public void pointer_get_to_dialoganimated_elements() {
        dialoganimatedPage.switchToFrame();
        dialoganimatedPage.getElement();
    }
    @When("user click the open dialog button")
    public void user_click_the_open_dialog_button() throws InterruptedException {
        dialoganimatedPage.clickOpenDialog();
    }
    @Then("dialog basic dialog is displayed")
    public void dialog_basic_dialog_is_displayed() {
        String display = dialoganimatedPage.validated();
        System.out.println(display);
        assertNotEquals("none", display);
    }

    @Given("user is on menu page")
    public void user_is_on_menu_page() {
        driver.get("https://jqueryui.com/menu/");
    }
    @Then("check if user is on menu page")
    public void check_if_user_is_on_menu_page() {
        menuPage = new MenuPage(driver);
        ActualTitle = driver.getTitle();
        ExpectedTitle = "Menu | jQuery UI";
        assertEquals(ExpectedTitle, ActualTitle);
    }
    @Given("pointer get to menu elements")
    public void pointer_get_to_menu_elements() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user hover mouse to {string} menu")
    public void user_hover_mouse_to_menu(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("sub-menu is displayed")
    public void sub_menu_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }




    @Given("user is on progressbar download page")
    public void user_is_on_progressbar_download_page() {
        driver.get("https://jqueryui.com/progressbar/#download");
    }
    @Then("check if user is on progressbar download page")
    public void check_if_user_is_on_progressbar_download_page() {
        progressbarPage = new ProgressbarPage(driver);
        ActualTitle = driver.getTitle();
        ExpectedTitle = "Progressbar | jQuery UI";
        assertEquals(ExpectedTitle, ActualTitle);
    }
    @Given("pointer get to  button dowloading elements")
    public void pointer_get_to_button_dowloading_elements() {
        progressbarPage.switchToFrame();
        progressbarPage.getElements();
    }
    @When("user click the button dowloading")
    public void user_click_the_button_dowloading() {
        progressbarPage.clickDownload();
    }
    @Then("progressbar download is displayed until {string}")
    public void progressbar_download_is_displayed_until(String label) {
        String actual = progressbarPage.validate();
        String Expected = label;
        assertEquals(Expected, actual);
    }


    @Given("user is on slider page")
    public void user_is_on_slider_page() {
        driver.get("https://jqueryui.com/slider/#default");
    }
    @Then("check if user is on slider page")
    public void check_if_user_is_on_slider_page() {
        sliderPage = new SliderPage(driver);
        ActualTitle = driver.getTitle();
        ExpectedTitle = "Slider | jQuery UI";
        assertEquals(ExpectedTitle, ActualTitle);
    }
    @Given("pointer get the slider elements")
    public void pointer_get_the_slider_elements() {
        sliderPage.switchToFrame();
        sliderPage.getElements();
    }
    @When("user drag slider to {int}%")
    public void user_drag_slider_to(Integer int1) {
        sliderPage.makeSlide(int1);
    }
    @Then("slider value is {int}%")
    public void slider_value_is(Integer int1) {
        String expected = "left: "+int1+"%;";
        String actual = sliderPage.getValue();
        assertEquals(expected, actual);
    }

    @Given("user is on spinner page")
    public void user_is_on_spinner_page() {
        driver.get("https://jqueryui.com/spinner/");
    }
    @Then("check if user is on spinner page")
    public void check_if_user_is_on_spinner_page() {
        spinnerPage = new SpinnerPage(driver);
        ActualTitle = driver.getTitle();
        ExpectedTitle = "Spinner | jQuery UI";
        assertEquals(ExpectedTitle, ActualTitle);
    }
    @Given("pointer get the elements")
    public void pointer_get_the_elements() {
        spinnerPage.switchToFrame();
        spinnerPage.getElements();
    }
    @When("user click spinner up {int} times")
    public void user_click_spinner_up_times(Integer n) {
        spinnerPage.clickUp(n);
    }
    @Then("spinner value is {int}")
    public void spinner_value_is(Integer int1) {
        String actual = spinnerPage.getValue();
        String expected = int1.toString();
        assertEquals(expected, actual);
    }
    @When("user click spinner down {int} times")
    public void user_click_spinner_down_times(Integer n) {
        spinnerPage.clickDown(n);
    }

    @Given("user is on tooltip page")
    public void user_is_on_tooltip_page() {
        driver.get("https://jqueryui.com/tooltip/");
    }
    @Then("check if user is on tooltip page")
    public void check_if_user_is_on_tooltip_page() {
        tooltipPage = new TooltipPage(driver);
        ActualTitle = driver.getTitle();
        ExpectedTitle = "Tooltip | jQuery UI";
        assertEquals(ExpectedTitle, ActualTitle);
    }
    @Given("pointer get the frame")
    public void pointer_get_the_frame() {
        tooltipPage.switchToFrame();
    }
    @When("user hover pointer to element input")
    public void user_hover_pointer_to_element_input() {
        tooltipPage.hoverToElement();
    }
    @Then("tooltip is displayed")
    public void tooltip_is_displayed() {
        String content = "We ask for your age only for statistical purposes.";
        assertEquals(content, tooltipPage.validated());
    }
}
