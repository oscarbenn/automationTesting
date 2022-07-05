package pageObject;

import java.util.List;
import java.util.function.BooleanSupplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AutocompletePage {

    protected WebDriver driver = null;
    protected Actions actions = null;
    private WebElement frame_element, search_element;
    private List<WebElement> auto_elements;
    private By search = By.xpath("//*[@id=\"tags\"]");
    private By frame = By.tagName("iframe");
    private By autos = By.xpath("//*[@id=\"ui-id-1\"]/li");


    public AutocompletePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void switchToFrame(){
        frame_element = driver.findElement(frame);
        driver.switchTo().frame(frame_element);
    }

    public void typing(String word){
        search_element = driver.findElement(search);
        search_element.sendKeys(word);
    }

    public void getElements(){
        auto_elements = driver.findElements(autos);
    }

    public int numberElement() {
        return auto_elements.size();
    }
}
