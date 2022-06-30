package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    protected WebDriver driver;

    private By txt_email_login = By.name("email");
    private By txt_password_login = By.name("password");
    private By btn_login_login = By.xpath("//button[@class='btn btn-default btn-lg btn-block effect ladda-button waves-effect']");  //button[@class='btn btn-default btn-lg btn-block effect ladda-button waves-effect']

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email){
        driver.findElement(txt_email_login).sendKeys(email);
    }

    public void enterPassword(String password){
        driver.findElement(txt_password_login).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(btn_login_login).click();
    }
}
