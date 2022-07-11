package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectmenudefaultPage {
    protected WebDriver driver = null;
    protected Actions actions = null;
    private List<WebElement> option_speed;
    private WebElement frame_element, speed_btn, opsi; //selected_speed
    private By frame = By.tagName("iframe");
    private By speed = By.xpath("//*[@id=\"speed-button\"]");
    private By speed_option = By.xpath("//div/ul/li/div");
    //private By speed_selected = By.xpath("//*[@id=\"speed-button\"]/span[2]");

    
    public SelectmenudefaultPage(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void switchToFrame(){
        frame_element = driver.findElement(frame);
        driver.switchTo().frame(frame_element);
    }

    public void getElements(){
        speed_btn = driver.findElement(speed);
    }

    public void selectoptionspeed(String string) {
        speed_btn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(speed_option));
        option_speed = driver.findElements(speed_option);
        for (int i = 0; i < option_speed.size(); i++) {
            opsi = option_speed.get(i);
            String label = opsi.getText();
            if (label.equalsIgnoreCase(string)) {
                opsi.click();
                break;
            }
        }
    }

    public String validate() {
        return speed_btn.getText();
    }
}
