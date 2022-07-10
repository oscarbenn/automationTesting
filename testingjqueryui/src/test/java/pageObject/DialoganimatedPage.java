package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DialoganimatedPage {

    protected WebDriver driver = null;
    protected Actions actions = null;
    private WebElement frame_element, element, dialogElement;
    private By frame = By.tagName("iframe");
    private By buttonOpen = By.id("opener");
    private By dialog = By.id("dialog");

    public DialoganimatedPage(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void switchToFrame(){
        frame_element = driver.findElement(frame);
        driver.switchTo().frame(frame_element);
    }

    public void getElement() {
        element = driver.findElement(buttonOpen);
    }

    public void clickOpenDialog() throws InterruptedException {
        element.click();
        Thread.sleep(3000);
        dialogElement = driver.findElement(dialog);
    }

    public String validated(){
        return dialogElement.getCssValue("display");
    }



}
