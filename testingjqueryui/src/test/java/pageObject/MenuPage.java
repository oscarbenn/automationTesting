package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage {
    protected WebDriver driver = null;
    protected Actions actions = null;
    protected WebDriverWait wait;
    private List<WebElement> menu_elements, submenu_elements;
    private WebElement frame_element, menu, submenu;
    private By frame = By.tagName("iframe");
    private By menus = By.xpath("//ul[@id=\"menu\"]/li/div"); //*[@id=\"menu\"]/li
    //private By sub = By.xpath("//*[@id=\"menu\"]/li/ul/li");
    
    public MenuPage(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void switchToFrame(){
        frame_element = driver.findElement(frame);
        driver.switchTo().frame(frame_element);
    }

    public void getElements(){
        menu_elements = driver.findElements(menus);
    }

    public void chooseHover(String opsi) throws InterruptedException{
        for (int i = 0; i < menu_elements.size(); i++) {
            menu = menu_elements.get(i);
            String label = menu.getText();
            System.out.println(label);
            if (label.equalsIgnoreCase(opsi)) {
                menu.click();
                //actions.moveToElement(menu);
                //wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                //wait.until(ExpectedConditions.visibilityOfElementLocated(sub));
                submenu_elements = driver.findElements(By.xpath("//*[@id=\"menu\"]/li["+(i+1)+"]/ul/li/div"));
                System.out.println(submenu_elements.size());
                for (int j = 0; j < submenu_elements.size(); j++) {
                    submenu = submenu_elements.get(j);
                    System.out.println(submenu.getText());
                }
            }
        }
    }

    public int validate(){
        return submenu_elements.size();
    }






}
