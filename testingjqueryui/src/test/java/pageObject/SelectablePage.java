package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SelectablePage {

    protected WebDriver driver = null;
    protected Actions actions = null;
    private WebElement frame_element, element;
    private List<WebElement> selectable_elements;
    private By elements = By.xpath("//*[@id=\"selectable\"]/li");
    private By frame = By.tagName("iframe");


    public SelectablePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void switchToFrame(){
        frame_element = driver.findElement(frame);
        driver.switchTo().frame(frame_element);
    }

    public void getElements(){
        selectable_elements = driver.findElements(elements);
    }

    public void clickElement(int index){
        element = selectable_elements.get(index-1);
        actions.click(element).perform();
    }

    public void clickElements(int index1,int index2,int index3){
        actions.keyDown(Keys.CONTROL)
        .click(selectable_elements.get(index1-1))
        .click(selectable_elements.get(index2-1))
        .click(selectable_elements.get(index3-1))
        .keyUp(Keys.CONTROL)
        .build().perform();
    }

    public void selectSwipe(int index1, int index2){
        WebElement elementFirst = selectable_elements.get(index1-1);
        WebElement elementLast = selectable_elements.get(index2-1);
        actions.clickAndHold(elementFirst).moveToElement(elementLast).release().build().perform();
    }


    public String checkColor(int index){
        element = selectable_elements.get(index-1);
        return element.getCssValue("background-color");
    }

}
