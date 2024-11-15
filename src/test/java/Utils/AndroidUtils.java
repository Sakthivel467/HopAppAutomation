package Utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static DriverSetup.BaseTest.driver;


public class AndroidUtils {


    public AndroidUtils() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Function to pause the execution for the specified time period
     *
     * @param milliSeconds The wait time in milliseconds
     */
    public void waitFor(long milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Boolean objectExists(By by) {
        try {
            if (driver.findElements(by).size() == 0) {
                return false;
            } else {
                return true;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public boolean enterValueInTextBox(String text, By by) {
        boolean flag = false;
        try {
            if (driver.findElement(by).isDisplayed()) {
                driver.findElement(by).click();
                driver.findElement(by).clear();
                driver.findElement(by).sendKeys(text);
                //driver.hideKeyboard();
                flag = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * Function to get the text of an element. Ex : get title or header
     * throwing Exception if element is not visible
     */
    public String getElementText(By by) {
        if (driver.findElement(by).isDisplayed()) {
            return driver.findElement(by).getText();
        } else {
            return driver.findElement(by).getText();
        }
    }
    public static double extractCurrencyValue(String text) {
        // Define the regular expression to find the number
        String regex = "1 (\\w{3}) = (\\d+\\.\\d+) INR";
        // Compile the regular expression into a Pattern object
        Pattern pattern = Pattern.compile(regex);
        // Create a Matcher object to find matches in the input string
        Matcher matcher = pattern.matcher(text);

        // Check if the pattern matches and extract the number
        if (matcher.find()) {
            String numberStr = matcher.group(2); // Group 1 is the first group in the regex, i.e., the number
            return Double.parseDouble(numberStr); // Convert the string to a double
        }
        // Return a default value or throw an exception if no match is found
        return 0; // You might want to handle this case differently
    }

    public static int extractNumber(String text) {
        // Remove all non-digit characters from the string
        String numberStr = text.replaceAll("\\D+", "");
        // Parse the cleaned string to an integer
        return Integer.parseInt(numberStr);
    }
    public static double twoDecimalValues(double value) {
        DecimalFormat df = new DecimalFormat("###.##");
        return  Double.parseDouble(df.format(value));
    }
}
