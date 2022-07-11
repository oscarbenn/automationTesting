package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgressbarPage {

    protected WebDriver driver = null;
    protected Actions actions = null;
    private WebElement frame_element, download_button;
    private By frame = By.tagName("iframe");
    private By button_download = By.id("downloadButton");
    private By bar = By.id("progressbar");
    private By label = By.className("progress-label");


    public ProgressbarPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void switchToFrame(){
        frame_element = driver.findElement(frame);
        driver.switchTo().frame(frame_element);
    }

    public void getElements(){
        download_button = driver.findElement(button_download);
    }

    public void clickDownload() {
        download_button.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.attributeToBe(bar, "aria-valuenow", "100"));
    }

    public String validate() {
        return driver.findElement(label).getText();
    }
}
