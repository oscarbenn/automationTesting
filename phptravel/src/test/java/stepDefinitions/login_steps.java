package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import pageObject.LoginPage;

public class login_steps {
    WebDriver driver = null;
    LoginPage loginPage = new LoginPage(driver);

    @Before
    public void browserSetup(){
        System.out.println("I am inside browserSetup");
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }

    @After
    public void teardown(){
        System.out.println("I am inside tearDown");
        driver.close();
        driver.quit();
    }

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver.get("https://www.phptravels.net/login");
    }

    @Then("check if user is on login page")
    public void check_if_user_is_on_login_page() {
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Login - PHPTRAVELS";
        assertEquals(ExpectedTitle, ActualTitle);
    }

    @When("^user enters (.*) and (.*)$")
    public void user_enters_email_and_password(String email, String password) {
        loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @And("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLogin();
    }

    @Then("user is navigated to dashboard")
    public void user_is_navigated_to_dashboard() {
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Dashboard - PHPTRAVELS";
        assertEquals(ExpectedTitle, ActualTitle);
        //assertTrue(driver.getTitle().equals("Dashboard - PHPTRAVELS"));
    }
    @Then("message error is displayed")
    public void message_error_is_displayed() {
        assertNotNull(driver.findElement(By.xpath("//div[@class='alert alert-danger failed']")));
    }
}
