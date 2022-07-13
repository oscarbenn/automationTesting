package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatepickerPage {

    protected WebDriver driver = null;
    protected Actions actions = null;
    private WebElement frame_element, element, date_choosen;
    private By frame = By.tagName("iframe");
    private By calendar = By.id("ui-datepicker-div");
    private By datepicker = By.id("datepicker");
    private By calendarTitle = By.className("ui-datepicker-title");
    private By calendarNext = By.xpath("//a[@title='Next']");
    private By calendarPrev = By.xpath("//a[@title='Prev']");
    

    public DatepickerPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void switchToFrame(){
        frame_element = driver.findElement(frame);
        driver.switchTo().frame(frame_element);
    }

    public void getElement(){
        element = driver.findElement(datepicker);
    }

    public void clickDatepicker(){
        element.click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
        .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(calendar));
    }

    public String[] getMonthYear(String monthYearVal){
        return monthYearVal.split(" ");
    }

    public void selectDate(String day, String month, String year){
        String monthYearVal = driver.findElement(calendarTitle).getText();
        int monthval = monthValue(month);
        int yearval = Integer.parseInt(year);
        int nowmonthval = monthValue(getMonthYear(monthYearVal)[0]);
        int nowyearval = Integer.parseInt(getMonthYear(monthYearVal)[1]);

        if (yearval>nowyearval) {
            while (!(getMonthYear(monthYearVal)[0].equals(month) && getMonthYear(monthYearVal)[1].equals(year))) {
                driver.findElement(calendarNext).click();
                monthYearVal = driver.findElement(calendarTitle).getText();
            }
        }
        else if (yearval == nowyearval) {
            if (monthval>nowmonthval) {
                while (!(getMonthYear(monthYearVal)[0].equals(month) && getMonthYear(monthYearVal)[1].equals(year))) {
                    driver.findElement(calendarNext).click();
                    monthYearVal = driver.findElement(calendarTitle).getText();
                }
            } else if (monthval<nowmonthval) {
                while (!(getMonthYear(monthYearVal)[0].equals(month) && getMonthYear(monthYearVal)[1].equals(year))) {
                    driver.findElement(calendarPrev).click();
                    monthYearVal = driver.findElement(calendarTitle).getText();
                }
            }
        } else {
            while (!(getMonthYear(monthYearVal)[0].equals(month) && getMonthYear(monthYearVal)[1].equals(year))) {
                driver.findElement(calendarPrev).click();
                monthYearVal = driver.findElement(calendarTitle).getText();
            }
        }

        driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
        element.click();
        date_choosen = driver.findElement(By.xpath("//a[text()='"+day+"']"));
    }

    public String colorDate(){
        String color = date_choosen.getCssValue("background-color");
        return color;
    }

    public int monthValue(String m){
        switch (m) {
            case "January":
                return 1;
            case "February":
                return 2;
            case "March":
                return 3;
            case "April":
                return 4;
            case "May":
                return 5;
            case "June":
                return 6;
            case "July":
                return 7;
            case "August":
                return 8;
            case "September":
                return 9;
            case "October":
                return 10;
            case "November":
                return 11;
            case "December":
                return 12;
            default:
                return 0;
        }
    }
}
