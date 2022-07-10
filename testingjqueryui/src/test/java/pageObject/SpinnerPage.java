package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpinnerPage {

    protected WebDriver driver = null;
    protected Actions actions = null;
    private WebElement frame_element,spinner_up,spinner_down,spinner_input;
    private By frame = By.tagName("iframe");
    private By up = By.xpath("//span/a[contains(@class,'ui-spinner-up')]");
    private By input = By.xpath("//span/input[@id='spinner']");
    private By down = By.xpath("//span/a[contains(@class,'ui-spinner-down')]");
    private String spinner_value;

    public SpinnerPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void switchToFrame(){
        frame_element = driver.findElement(frame);
        driver.switchTo().frame(frame_element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(input));
    }

    public void getElements(){
        spinner_up = driver.findElement(up);
        spinner_input = driver.findElement(input);
        spinner_down = driver.findElement(down);
    }

    public void clickUp(Integer n) {
        for (int i = 0; i < n; i++) {
            spinner_up.click();
        }
    }

    public String getValue() {
        spinner_value = spinner_input.getAttribute("aria-valuenow");
        return spinner_value;
    }

    public void clickDown(Integer n) {
        for (int i = 0; i < n; i++) {
            spinner_down.click();
        }
    }
}
