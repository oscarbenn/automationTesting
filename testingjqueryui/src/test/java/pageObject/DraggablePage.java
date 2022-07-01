package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DraggablePage {
    protected WebDriver driver;

    private Actions actions = new Actions(driver);
    private WebElement frame_element = driver.findElement(By.tagName("iframe"));
    private WebElement draggable_element = driver.findElement(By.xpath("//div[@id='draggable']"));

    public DraggablePage(WebDriver driver){
        this.driver = driver;
    }

    public void switchToFrame(){
        driver.switchTo().frame(frame_element);
    }

    public Point locationBeforeDrag(){
        return draggable_element.getLocation();
    }

    public void moveToElement(){
        actions.moveToElement(draggable_element).perform();
    }








}
