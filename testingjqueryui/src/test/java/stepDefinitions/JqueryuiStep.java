package stepDefinitions;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.DraggablePage;
import pageObject.DroppablePage;
import pageObject.ResizablePage;
import pageObject.SelectablePage;

public class JqueryuiStep {

    public WebDriver driver = null;
    DraggablePage draggablePage = null;
    DroppablePage droppablePage = null;
    ResizablePage resizablePage = null;
    SelectablePage selectablePage = null;
    Actions actions = null;
    Point positionFirst, positionLast;
    Point dropLocation, dragLocation;
    String ActualTitle, ExpectedTitle;

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
}
