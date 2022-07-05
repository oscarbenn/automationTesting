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

public class DraggableStep {

    public WebDriver driver = null;
    DraggablePage draggablePage = null;
    Actions actions = null;
    Point positionFirst, positionLast;
    String ActualTitle, ExpectedTitle;

    @Before
    public void browserSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        draggablePage = new DraggablePage(driver);

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

}
