package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void getElements(){
        search_element = driver.findElement(search);
        // List<WebElement> elements = driver.findElements(autos);
        // auto_elements = elements;
    }


    public void typing(String word){
        search_element.sendKeys(word);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(autos));
        auto_elements = driver.findElements(autos);
    }

    public int numberElement() {
        auto_elements = driver.findElements(autos);
        return auto_elements.size();
    }

    public void choose(String string) {
        for (int i = 0; i < auto_elements.size(); i++) {
            WebElement element = auto_elements.get(i);
            String opsi = element.getText();
            if (opsi.equals(string)) {
                element.click();
                break;
                
            }
        }
    }

    public void typingafter(String word) {
        search_element.click();
        search_element.sendKeys(word);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(autos));
        auto_elements = driver.findElements(autos);
    }

    public String cekValidate() {
        return search_element.getAttribute("value");
    }
}
