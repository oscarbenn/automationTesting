package pageObject;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectmenuproductPage {
    
    protected WebDriver driver = null;
    protected Actions actions = null;
    private List<WebElement> option_radius, option_color;
    private List<String> validate;
    private WebElement frame_element, circle_element, radius_btn, color_btn, opsi; //selected_radius
    private By frame = By.tagName("iframe");
    private By circle = By.id("circle");
    private By radius = By.xpath("//*[@id=\"radius-button\"]");
    private By radius_option = By.xpath("//div/ul/li/div");//*[@id="ui-id-2"]
    private By color = By.xpath("//*[@id=\"color-button\"]");
    private By color_option = By.xpath("//div[4]/ul/li/div");//*[@id="ui-id-2"]
    
    public SelectmenuproductPage(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void switchToFrame(){
        frame_element = driver.findElement(frame);
        driver.switchTo().frame(frame_element);
    }

    public void getElements(){
        radius_btn = driver.findElement(radius);
        color_btn = driver.findElement(color);
        circle_element = driver.findElement(circle);
    }

    public void selectRadius(Integer radius) {
        radius_btn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(radius_option));
        option_radius = driver.findElements(radius_option);
        for (int i = 0; i < option_radius.size(); i++) {
            opsi = option_radius.get(i);
            String label = opsi.getText();
            if (label.equalsIgnoreCase(radius+"px")) {
                opsi.click();
                break;
            }
        }
    }

    public void selectColor(String color) {
        color_btn.click();
        option_color = driver.findElements(color_option);
        for (int i = 0; i < option_color.size(); i++) {
            opsi = option_color.get(i);
            String label = opsi.getText();
            if (label.equalsIgnoreCase(color)) {
                opsi.click();
                break;
            }
        }
    }

    public List<String> getRadiusCircle() {
        validate = new ArrayList<String>();
        validate.add(circle_element.getCssValue("width"));
        validate.add(circle_element.getCssValue("height"));
        validate.add(circle_element.getCssValue("background-color"));
        return validate;
    }

}
