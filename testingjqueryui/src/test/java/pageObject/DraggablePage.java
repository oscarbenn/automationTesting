package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DraggablePage {

    protected WebDriver driver = null;
    protected Actions actions = null;
    private WebElement frame_element, draggable_element;
    private By frame = By.tagName("iframe");
    private By draggable = By.xpath("//div[@id='draggable']");

    public DraggablePage(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void switchToFrame(){
        frame_element = driver.findElement(frame);
        driver.switchTo().frame(frame_element);
    }

    public void moveToElement(){
        draggable_element = driver.findElement(draggable);
        actions.moveToElement(draggable_element).perform();
    }

    public Point getLocation(){
        return draggable_element.getLocation();
    }

    public void move(int x, int y){
        actions.clickAndHold(draggable_element).moveByOffset(x, y).release().build().perform();
    }
}
