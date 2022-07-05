package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SortablePage {

    protected WebDriver driver = null;
    protected Actions actions = null;
    private WebElement frame_element, element;
    private List<WebElement> sortable_elements;
    private By elements = By.xpath("//*[@id=\"sortable\"]/li");
    private By frame = By.tagName("iframe");


    public SortablePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void switchToFrame(){
        frame_element = driver.findElement(frame);
        driver.switchTo().frame(frame_element);
    }

    public void getElements(){
        sortable_elements = driver.findElements(elements);
    }

    public WebElement getElement(int index){
        return sortable_elements.get(index-1);
    }

    public void moveElementToTop(int index){
        element = sortable_elements.get(index-1);
        WebElement to = sortable_elements.get(0);
        actions.clickAndHold(element).moveToElement(to).release().build().perform();
    }

    public void checkSort(Integer index){

    }
}
