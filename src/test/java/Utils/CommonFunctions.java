package Utils;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.text.DecimalFormat;
import java.time.Duration;

import static DriverSetup.BaseTest.driver;
import static extentReport.ExtentReportManager.test;

public class CommonFunctions  {


    public String removeDelimiter(String text){
        return (text.replaceAll(",", ""));
    }
    public void wait(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    //Constructor to initialise the Webelements
    public double twoDecimalValues(double value) {
        DecimalFormat df = new DecimalFormat("###.##");
        return  Double.parseDouble(df.format(value));
    }
    public void jClick(WebElement element, String message){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
        test.get().log(Status.PASS,message);
    }

    public void jScroll(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void jClear(WebElement element,String message){
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='';",element);
        test.get().log(Status.PASS,message);
    }
    public void keyClear(WebElement element){
        element.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }

    public void clickElement(WebElement element, String message) {
        element.click();
        test.get().log(Status.PASS,message);
    }

    public void clearElement(WebElement element, String message) {
        element.clear();
        test.get().log(Status.PASS,message);
    }

    public void sendText(WebElement element, String text,String message) {
        keyClear(element);
        element.sendKeys(text);
        test.get().log(Status.PASS,message);
    }

    public void getTextFromElement(WebElement element,String message) {
        element.getText();
        test.get().log(Status.INFO,message);
    }

    public boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }

    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    public void selectViaVisibleText(WebElement element, String text) {
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(text);
    }

    public void selectByValue(WebElement element, String value) {
        Select dropDown = new Select(element);
        dropDown.selectByValue(value);
    }

    public void hoverOverElement(WebElement element) {
        Actions hover = new Actions(driver);
        hover.moveToElement(element).build().perform();
    }

    public void clickOnHoveredElement(WebElement element) {
        Actions hover = new Actions(driver);
        hover.moveToElement(element).click().build().perform();
    }
}

