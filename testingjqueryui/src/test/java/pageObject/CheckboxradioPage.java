package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CheckboxradioPage {

    protected WebDriver driver;
    protected Actions actions;
    private List<WebElement> boxes_elements, radios_element;
    private WebElement frame_element, boxes_element, boxes_choosen, radio__element, radio_choosen;
    private By frame = By.tagName("iframe");
    private By boxes = By.xpath("//input[@type=\"checkbox\"]");
    private By radios = By.name("radio-1");

    public CheckboxradioPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void switchToFrame(){
        frame_element = driver.findElement(frame);
        driver.switchTo().frame(frame_element);
    }

    public void getElements(){
        boxes_elements = driver.findElements(boxes);
    }

    public void choose(String opsi){
        for (int i = 0; i < boxes_elements.size(); i++) {
            String id = boxes_elements.get(i).getAttribute("id");
            boxes_element = driver.findElement(By.xpath("//label[@for=\'"+id+"\']"));
            String label = boxes_element.getText();

            if (label.equalsIgnoreCase(opsi)) {
                boxes_element.click();
                boxes_choosen = driver.findElement(By.xpath("//label[@for=\'"+id+"\']"));
            }
        }
    }

    public String colorOpsi(){
       String color = boxes_choosen.getCssValue("background-color");
       return color;
    }

    public void getRadios(){
        radios_element = driver.findElements(radios);
    }

    public void chooseRadio(String radio){
        for (int i = 0; i < radios_element.size(); i++) {
            String id = radios_element.get(i).getAttribute("id");
            radio__element = driver.findElement(By.xpath("//label[@for=\'"+id+"\']"));
            String label = radio__element.getText();
            if (label.equalsIgnoreCase("New York")) {
                radio__element.click();
                radio_choosen = driver.findElement(By.xpath("//label[@for=\'"+id+"\']"));
                break;
            }
        }
    }

    public String colorRadio(){
        String color = radio_choosen.getCssValue("background-color");
        return color;
    }
}
