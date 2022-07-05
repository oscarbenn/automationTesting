package pageObject;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ResizablePage {

    protected WebDriver driver = null;
    protected Actions actions = null;
    private WebElement frame_element, resizable_element, handle_element;
    private By frame = By.tagName("iframe");
    private By resizable = By.xpath("//div[@id='resizable']");
    private By handle = By.xpath("//*[@id=\"resizable\"]/div[3]");
    String size = "width: 150px; height: 150px;";
    String size_resizable_element;


    public ResizablePage(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void switchToFrame(){
        frame_element = driver.findElement(frame);
        driver.switchTo().frame(frame_element);
    }

    public void moveToElement(){
        handle_element = driver.findElement(handle);
        actions.moveToElement(handle_element).perform();
    }

    public Point getLocation(){
        return handle_element.getLocation();
    }

    public void move(int x, int y){
        actions.clickAndHold(handle_element).moveByOffset(x, y).release().build().perform();
    }

    public void getResizable(){
        resizable_element = driver.findElement(resizable);
        size_resizable_element = resizable_element.getAttribute("style");
    }

    public void isSizeChange(){
        assertNotEquals(size, size_resizable_element);
    }
}
