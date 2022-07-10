package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TooltipPage {

    protected WebDriver driver = null;
    protected Actions actions = null;
    private WebElement input_element, tooltip_element;
    //private By frame = By.tagName("iframe");
    private By input = By.id("age");
    private By tooltip = By.xpath("//*[@role=\"tooltip\"]");

    public TooltipPage(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void switchToFrame(){
        //frame_element = driver.findElement(frame);
        driver.switchTo().frame(0);
    }

    public void hoverToElement(){
        input_element = driver.findElement(input);
        actions.moveToElement(input_element);
    }

    public String validated(){
        tooltip_element = driver.findElement(tooltip);
        return tooltip_element.getText();
    }

}
