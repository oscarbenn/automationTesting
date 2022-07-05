package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DroppablePage {

    protected WebDriver driver;
    protected Actions actions;
    private WebElement frame_element, draggable_element, droppable_element;
    private By frame = By.tagName("iframe");
    private By draggable = By.xpath("//*[@id=\"draggable\"]");
    private By droppable = By.xpath("//*[@id=\"droppable\"]");

    public DroppablePage(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void switchToFrame(){
        frame_element = driver.findElement(frame);
        driver.switchTo().frame(frame_element);
    }

    public void foundElement(){
        draggable_element = driver.findElement(draggable);
        droppable_element = driver.findElement(droppable);
    }

    public Point getDragLocation(){
        return draggable_element.getLocation();
    }

    public Point getDropLocation(){
        return droppable_element.getLocation();
    }

    public void moveToTarget(){
        actions.clickAndHold(draggable_element).moveToElement(droppable_element).release().build().perform();
    }

    public String isElementDropped(){
        return driver.findElement(By.xpath("//*[@id=\"droppable\"]/p")).getText();
    }

}


