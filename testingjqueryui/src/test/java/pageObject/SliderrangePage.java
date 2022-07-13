package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SliderrangePage {
    
    protected WebDriver driver = null;
    protected Actions actions = null;
    private WebElement frame_element, handleMin_element, handleMax_element, slider_element, range_element; //slider_element
    private By frame = By.tagName("iframe");
    private By slider = By.id("slider-range");
    private By handleMin = By.xpath("//*[@id=\"slider-range\"]/span[1]");
    private By handleMax = By.xpath("//*[@id=\"slider-range\"]/span[2]");
    private By range = By.xpath("//*[@id=\"slider-range\"]/div");
    private Integer size;

    public SliderrangePage(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void switchToFrame(){
        frame_element = driver.findElement(frame);
        driver.switchTo().frame(frame_element);
    }

    public void getElements() {
        slider_element = driver.findElement(slider);
        handleMin_element = driver.findElement(handleMin);
        handleMax_element = driver.findElement(handleMax);
        range_element = driver.findElement(range);

        size = slider_element.getSize().getWidth();
    }

    public void setMinMax(){
        actions.dragAndDropBy(handleMin_element, -(handleMin_element.getLocation().getX() + 6), 0)
        .release().build().perform();
        actions.dragAndDropBy(handleMax_element, size - handleMax_element.getLocation().getX(), 0)
        .release().build().perform();
    }
    public void makeSlideMin(int int1) {
        Double a = (double)(int1*size/100.00);
        int i=a.intValue();
        actions.dragAndDropBy(handleMin_element, i, 0).release().build().perform();
    }

    public void makeSlideMax(int int1) { 
        Double a = (double)((100-int1)*size/100.00);
        int i=a.intValue();
        actions.dragAndDropBy(handleMax_element, -i, 0).release().build().perform();
    }

    public String getMinValue() {
        String value = handleMin_element.getAttribute("style");
        return value;
    }

    public String getMaxValue() {
        String value = handleMax_element.getAttribute("style");
        return value;
    }
}
