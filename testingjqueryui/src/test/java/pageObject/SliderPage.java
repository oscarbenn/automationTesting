package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SliderPage {

    protected WebDriver driver = null;
    protected Actions actions = null;
    private WebElement frame_element, slider_element, handle_element;
    private By frame = By.tagName("iframe");
    private By slider = By.id("slider");
    private By handle = By.xpath("//*[@id=\"slider\"]/span");

    public SliderPage(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void switchToFrame(){
        frame_element = driver.findElement(frame);
        driver.switchTo().frame(frame_element);
    }

    public void getElements() {
        slider_element = driver.findElement(slider);
        handle_element = driver.findElement(handle);
    }

    public void makeSlide(int int1) {
        Double a = 569.00/100.00*(double)int1;
        Double d = (double) ((569/100)*int1);
        int i=a.intValue();
        int xOff = (569/100)*int1;
        System.out.println(xOff);
        actions.dragAndDropBy(handle_element, i, 0).release().build().perform();
    }

    public String getValue() {
        String persen = handle_element.getAttribute("style");
        return persen;
    }

}
