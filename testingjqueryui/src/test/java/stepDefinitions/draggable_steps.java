package stepDefinitions;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.DraggablePage;

public class draggable_steps {

    public WebDriver driver = null;
    DraggablePage draggablePage = null;   //new DraggablePage(driver);
    Point position_first, position_last;

    @Before
    public void browserSetup(){
        System.out.println("I am inside browserSetup");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    @After
    public void teardown(){
        System.out.println("I am inside tearDown");
        driver.close();
        driver.quit();
    }

    @Given("user is on draggable page")
    public void user_is_on_draggable_page() {
        driver.get("https://jqueryui.com/draggable/");
    }

    @Then("check if user is on draggable page")
    public void check_if_user_is_on_draggable_page() {
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Draggable | jQuery UI";
        assertEquals(ExpectedTitle, ActualTitle);
    }
    @Given("pointer get to draggable element")
    public void pointer_get_to_draggable_element() {
        draggablePage = new DraggablePage(driver);
        draggablePage.moveToElement();

    }
    @When("user action drag {int} to right")
    public void user_action_drag_to_right(Integer int1) {

    }
    @Then("element move {int} to right")
    public void element_move_to_right(Integer int1) {
        int x1 = position_first.getX();
        int x2 = position_last.getX();
        assertTrue(x2-x1==int1);
    }

}
