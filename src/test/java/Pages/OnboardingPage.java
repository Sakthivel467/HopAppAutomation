package Pages;

import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Utils.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.Random;

import static extentReport.ExtentReportManager.test;


public class OnboardingPage {
    private final AppiumDriver driver;

    public OnboardingPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);

    }

    ExcelSetup ex = new ExcelSetup();

    @iOSXCUITFindBy(accessibility = "redbox-dismiss")
    private WebElement dismissButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Smarter. Faster.\n" +
            "Better. way to send money abroad\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Smarter. Faster.\n" +
            "Better. way to send money abroad\"]")
    private WebElement smarterTxt;
    @AndroidFindBy(className = "android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Smarter. Faster.\n" +
            "Better. way to send money abroad Get Started by continuing, I agree to theand Horizontal scroll bar, 1 page Toolbar\"])[6]/XCUIElementTypeOther[2]/XCUIElementTypeOther")
    private WebElement sendMoneyImage;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"IntroScreen_Get_Started_Button\"]")
    @iOSXCUITFindBy(accessibility = "Get Started")
    private WebElement getStarted;
    @AndroidFindBy(className = "com.horcrux.svg.PathView")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Enter your phone number and email'])[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private WebElement backButton;
    @AndroidFindBy(xpath = " //android.view.ViewGroup[@content-desc='TransactionDetail_Header_Text']/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView\n")
    private WebElement tranBackButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter your phone number and email']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Enter your phone number and email']")
    private WebElement labelPhoneNoAndEmail;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Signup_Phone_No\"]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Phone No.*\"])[2]")
    private WebElement phoneNo;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Signup_Email\"]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Email\"])[2]")
    private WebElement emailId;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Signup_Continue_Button\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Continue\"]")
    private WebElement continueButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Settings\"]")
    private WebElement clickSettingButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Phone No.*']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Phone No.*\"]")
    private WebElement phoneNoPlaceholder;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Email*']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Email\"]")
    private WebElement emailPlaceholder;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Verify your account\"]")
    private WebElement verifyAccountTxt;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"FX fees\"]")
    private WebElement PrimeUse;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"VerifyOtp_Header_Text\"]")
    //android.widget.TextView[@text='Enter the OTP sent to your phone number']
    private WebElement enterOtpTxt;
    //    @AndroidFindBy(accessibility = "otp-input-0")
//    private WebElement otpBox;
//    @AndroidFindBy(accessibility = "otp-input-1")
//    private WebElement otpBox1;
//    @AndroidFindBy(accessibility = "otp-input-2")
//    private WebElement otpBox2;
//    @AndroidFindBy(accessibility = "otp-input-3")
//    private WebElement otpBox3;
//    @AndroidFindBy(accessibility = "otp-input-4")
//    private WebElement otpBox4;
//    @AndroidFindBy(accessibility = "otp-input-5")
//    private WebElement otpBox5;
//    @AndroidFindBy(xpath = "//android.widget.EditText")
//    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"otp-input\"][1]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"otp-input-0\"]")
    private WebElement otpBox;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"otp-input-1\"]")
    private WebElement otpBox2;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"otp-input-2\"]")
    private WebElement otpBox3;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"otp-input-3\"]")
    private WebElement otpBox4;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"otp-input-4\"]")
    private WebElement otpBox5;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"otp-input-5\"]")
    private WebElement otpBox6;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Choose your App PIN\"]")
    private WebElement pinLabel;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"otp-input-0\"])[1]")
    private WebElement pinCode;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"otp-input-1\"])[1]")
    private WebElement pinCode2;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"otp-input-2\"])[1]")
    private WebElement pinCode3;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"otp-input-3\"])[1]")
    private WebElement pinCode4;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Confirm your PIN\"]")
    private WebElement confirmPinLabel;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"otp-input-0\"])[2]")
    private WebElement pinCode5;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"otp-input-1\"])[2]")
    private WebElement pinCode6;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"otp-input-2\"])[2]")
    private WebElement pinCode7;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"otp-input-3\"])[2]")
    private WebElement pinCode8;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"HOP Remit\"]")
    private WebElement sendMoneyLabel;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Live Rate\"]")
    private WebElement liveGoogleRate;
    @AndroidFindBy(xpath = "  //android.widget.TextView[@text=\"all fees included\"]")
    private WebElement allFees;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"1 day settlement\"]")
    private WebElement oneDay;
    @AndroidFindBy(xpath = "//android.view.View[@text=\"Verify your documents\"]")
    private WebElement kYCDocsScreenLabel;
    @AndroidFindBy(xpath = " //android.widget.TextView[@text=\"PAN Card\"]")
    private WebElement pancardLable;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Enter your app PIN\"]")
    private WebElement oldUserPinLabel;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"otp-input-0\"]")
    private WebElement oldUserPinCode;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"otp-input-1\"]")
    private WebElement oldUserPinCode2;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"otp-input-2\"]")
    private WebElement oldUserPinCode3;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"otp-input-3\"]")
    private WebElement oldUserPinCode4;


    @AndroidFindAll({
            @AndroidBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView"),
            @AndroidBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView")
    })
    private WebElement eyeButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Invalid Otp']")
    private WebElement invalidOtpError;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='The passcode you have entered does not match']")
    private WebElement pinNotMatched;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='+91']")
    private WebElement phoneNoCountryCode;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter your app Pin']")
    private WebElement enterAppPinLabel;
    @AndroidFindBy(xpath = " //android.widget.TextView[@text='Tap to login with device Biometric ID lock']")
    private WebElement biometricLabel;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mobile no is already registered.']")
    private WebElement mobileNoAlreadyRegistered;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Entered phoneNumber is already linked with ******\"]")
    private WebElement emailIdAlreadyRegistered;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Forgot your PIN? \"]")
    private WebElement havingTroubleLabel;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Enter your phone number and email\"]")
    private WebElement enterMobileNum;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Reset it here\"]")
    private WebElement resetPinButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Reset App Pin']")
    private WebElement resetPinLabel;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Failed to change app pin']")
    private WebElement failedToChangePin;
    @AndroidFindBy(xpath = "//android.widget.Toast[@text='Successfully changed app pin']")
    private WebElement successChangedPinMessage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Please choose your new 4-digit app pin']")
    private WebElement newPinLabel;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Invalid Otp\"]")
    private WebElement incorrectPin;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Skip Guide\"]")
    private WebElement skipGuide;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"HomeScreen_Exchange_Input_Country_Selection\"])[2]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    private WebElement SelectCurrency;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"United States Dollar\"]")
    private WebElement currencyUSD;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"British Pound Sterling\"]")
    private WebElement currencyGBP;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Euro\"]")
    private WebElement currencyEUR;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Australian Dollar\"]")
    private WebElement currencyAUD;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Canadian Dollar\"]")
    private WebElement currencyCAD;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Singapore Dollar\"]")
    private WebElement currencySGD;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Japanese Yen\"]")
    private WebElement currencyJPY;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"United Arab Emirates Dirham\"]")
    private WebElement currencyAED;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"New Zealand Dollar\"]")
    private WebElement currencyNZD;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Swiss Franc\"]")
    private WebElement currencyCHF;
    @AndroidFindBy(xpath = " //android.widget.TextView[@text=\"terms and conditions\"]")
    private WebElement termsAndConditions;
    @AndroidFindBy(xpath = "//com.horcrux.svg.PathView")
    private WebElement termsAndConditionsClose;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Reset App Pin\"]")
    private WebElement restPinLabel;
    @FindBy(xpath = " //android.widget.TextView[@text=\"Please choose your new 4-digit app pin\"]")
    private WebElement restConfirmPinLabel;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='IBAN']")
    private WebElement ibanLabel;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='RecipientAccount_SWIFT_IBAN_Input']")
    private WebElement ibanInput;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Verify']")
    private WebElement ibnVerifyButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='RecipientAccount1_Continue_Button']")
    private WebElement ibaContinueButton;


    public void dismissButton() throws Exception {
        dismissButton.click();
        if (dismissButton.isDisplayed()) {
            dismissButton.click();
        }
    }

    public void moneyHopMoto() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertTrue(smarterTxt.isDisplayed());
        test.get().log(Status.PASS, "Homepage message: " + smarterTxt.getText());
    }

    public void sendMoneyImage() {
        Assert.assertTrue(sendMoneyImage.isDisplayed());
        test.get().log(Status.PASS, "Send money Image is displayed on the Hop App");
        TakeSnap.captureScreenshot();
    }

    public void clickSvgOrGetStartedButton() {
        String primaryXPath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView[1]";
        String fallbackXPath = "//android.view.ViewGroup[@content-desc='IntroScreen_Get_Started_Button']";

        try {
            WebElement primaryElement = driver.findElement(By.xpath(primaryXPath));
            if (primaryElement.isDisplayed()) {
                primaryElement.click();
                System.out.println("Clicked on primary SVG element.");
                return;
            }
        } catch (NoSuchElementException e) {
            System.out.println("Primary SVG not found. Trying fallback.");
        }

        // Fallback click
        try {
            WebElement fallbackElement = driver.findElement(By.xpath(fallbackXPath));
            if (fallbackElement.isDisplayed()) {
                fallbackElement.click();
                System.out.println("Clicked on fallback Get Started button.");
            }
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Neither SVG nor Get Started button found.");
        }
    }


    public void getStarted() throws InterruptedException {
        Thread.sleep(1000);
        TakeSnap.captureScreenshot();
        getStarted.click();
//        test.get().log(Status.PASS,"User has clicked on Get Started Button");
    }

    public void termsAndConditions() throws InterruptedException {
        termsAndConditions.click();
        TakeSnap.captureScreenshot();
        Thread.sleep(2000);
        termsAndConditionsClose.click();

    }

    public void backButtonLoginPage() throws InterruptedException {

        backButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(smarterTxt.isDisplayed());
        test.get().log(Status.PASS, "User clicked the Back button on SignUp page is successfully navigated to the HOP App homepage");
        TakeSnap.captureScreenshot();
        getStarted.click();
    }

    public void setBackButton() throws InterruptedException {
        backButton.click();
        Thread.sleep(2000);
    }

    public void validateLabelPhoneNoAndEmail() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(labelPhoneNoAndEmail.isDisplayed());
        test.get().log(Status.INFO, "Label: " + labelPhoneNoAndEmail.getText());

    }

    public void enterPhoneNo(String phoneNoTxt) throws Exception {
        phoneNo.sendKeys(phoneNoTxt);
    }

    public void enterRandomPhoneNo() {
        Random random = new Random();
        StringBuilder mobileNumber = new StringBuilder("9");
        for (int i = 0; i < 9; i++) {
            mobileNumber.append(random.nextInt(10));
        }
        String phoneNoTxt = mobileNumber.toString();

// Wait for the input field to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement phoneInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//android.widget.EditText[@content-desc='Signup_Phone_No']")
        ));

// Optionally scroll into view if needed
// driver.findElement(AppiumBy.androidUIAutomator(
//     "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" +
//     "new UiSelector().description(\"Signup_Phone_No\"))"
// ));

        phoneInput.sendKeys(phoneNoTxt);
        System.out.println("Phone number entered: " + phoneNoTxt);

//        emailId.clear();
//        Random randomGenerator = new Random();
//        int randomInt = randomGenerator.nextInt(99999);
//        phoneNo.sendKeys(phoneNoTxt+ randomInt);
//        test.get().log(Status.PASS, "User entered the Valid Phone No.");
//        phoneNo.sendKeys(phoneNoTxt);
    }

    public void incorrectEnterPhoneNo(String phoneNoTxt) throws Exception {
        phoneNo.sendKeys(phoneNoTxt);
    }

    public void validatePhoneNoCountryCode() {
        Assert.assertTrue(phoneNoCountryCode.isDisplayed());
        test.get().log(Status.INFO, "Label: '" + phoneNoCountryCode.getText() + "' is correctly displayed");
    }

    public void enterEmailId(String email) throws Exception {
        emailId.clear();
        Random randomGenerator = new Random();

        int randomInt = randomGenerator.nextInt(100000);
        emailId.sendKeys(email + randomInt + "@moneyhop.com");
        Thread.sleep(2000);
        test.get().log(Status.PASS, "User entered the Valid Email Id");
        TakeSnap.captureScreenshot();
//        emailId.clear();
//
//        Random randomGenerator = new Random();
//        int randomInt = randomGenerator.nextInt(100000);
//
//        generatedEmail = emailPrefix + randomInt + "@moneyhop.com";
//        emailId.sendKeys(generatedEmail);
//
//        test.get().log(Status.PASS, "Entered Email: " + generatedEmail);
//        TakeSnap.captureScreenshot();
    }

    public void enterOldEmailId(String email) {
        emailId.sendKeys(email);
        test.get().log(Status.PASS, "User entered the Email Id");
    }

    public void enterIncorrectEmailId(String email) {
        emailId.sendKeys(email);
        test.get().log(Status.PASS, "User entered the Incorrect Email Id");
    }

    public void validatePhoneNoAndEmailPlaceholder() {
        Assert.assertTrue(phoneNoPlaceholder.isDisplayed());
        Assert.assertTrue(emailPlaceholder.isDisplayed());
        test.get().log(Status.PASS, "Placeholder for Phone No. and Email is displayed correctly");
        TakeSnap.captureScreenshot();
    }

    public void validatePhoneNoFieldOnlyAcceptsNumericCharacters() throws Exception {
        phoneNo.sendKeys("ffffffffff");
        enterEmailId(ex.getTestData("Email"));

        Assert.assertFalse(continueButton.isEnabled());
        test.get().log(Status.PASS, "User cannot proceed further after entering numeric characters in Phone no. field");
        TakeSnap.captureScreenshot();
    }

    public void validatePhoneNoWillBeOf10Digits() throws InterruptedException {
        phoneNo.clear();
        phoneNo.sendKeys("895556512");
        Assert.assertFalse(continueButton.isEnabled());
        test.get().log(Status.PASS, "User cannot proceed further because entered Phone no. is only of 9 digits");
        TakeSnap.captureScreenshot();

        //phoneNo.sendKeys(Keys.chord(Keys.CONTROL, "a"), ""); // Select all and replace with empty
        phoneNo.clear();
        phoneNo.sendKeys("89555651223");
        Assert.assertFalse(continueButton.isEnabled());
        test.get().log(Status.PASS, "User cannot proceed further because entered Phone no. is of 11 digits");
        TakeSnap.captureScreenshot();
    }

    public void validatePhoneNoDoesNotAcceptSpecialCharacter() {
        phoneNo.clear();
        phoneNo.sendKeys("895556512%");
        Assert.assertFalse(continueButton.isEnabled());
        test.get().log(Status.PASS, "User cannot proceed further because entered Phone no. contains Special character");
        TakeSnap.captureScreenshot();
    }

    public void validatePhoneNoDoesNotAcceptSpaces() {
        phoneNo.clear();
        phoneNo.sendKeys("89555 6512");
        Assert.assertFalse(continueButton.isEnabled());
        test.get().log(Status.PASS, "User cannot proceed further because entered Phone no. contains spaces");
        TakeSnap.captureScreenshot();
    }

    public void validatePhoneNoDoesNotAcceptNullValue() {
        phoneNo.clear();
        phoneNo.sendKeys("");
        Assert.assertFalse(continueButton.isEnabled());
        test.get().log(Status.PASS, "User cannot proceed further because entered Phone no. contains NULL value");
        TakeSnap.captureScreenshot();
    }

    public void validatePhoneNoValidations() throws Exception {
        validatePhoneNoAndEmailPlaceholder();
        validatePhoneNoFieldOnlyAcceptsNumericCharacters();
        validatePhoneNoWillBeOf10Digits();
        validatePhoneNoDoesNotAcceptSpecialCharacter();
        validatePhoneNoDoesNotAcceptSpaces();
        validatePhoneNoDoesNotAcceptNullValue();
        phoneNo.sendKeys("9999999999");
    }

    public void validateEmailLeadingAndTrailingSpaces() {
        emailId.clear();
        emailId.sendKeys(" ");
        Assert.assertFalse(continueButton.isEnabled());
        test.get().log(Status.PASS, "User cannot proceed further because entered Email Id contains NULL value");
        TakeSnap.captureScreenshot();

        emailId.clear();
        emailId.sendKeys(" himanshu@mo.co");
        Assert.assertFalse(continueButton.isEnabled());
        test.get().log(Status.PASS, "User cannot proceed further because entered Email Id contains Leading spaces");
        TakeSnap.captureScreenshot();

        emailId.clear();
        emailId.sendKeys("himanshu@mo.co ");
        Assert.assertFalse(continueButton.isEnabled());
        test.get().log(Status.PASS, "User cannot proceed further because entered Email Id contains Trailing spaces");
        TakeSnap.captureScreenshot();
    }

    public void validateEmailAddressWithDots() {
        emailId.clear();
        emailId.sendKeys("himanshu.sharma@mo.co");
        Assert.assertTrue(continueButton.isEnabled());
        test.get().log(Status.PASS, "User can proceed further because Email Id can handle dots");
        TakeSnap.captureScreenshot();
    }

    public void validateEmailAddressWithPlusSign() {
        emailId.clear();
        emailId.sendKeys("himanshu.sharma+12@mo.co");
        Assert.assertTrue(continueButton.isEnabled());
        test.get().log(Status.PASS, "User can proceed further because Email Id can handle plus sign");
        TakeSnap.captureScreenshot();
    }

    public void validateEmailAddressWithUppercaseLetter() {
        emailId.clear();
        emailId.sendKeys("Himanshu.sharma@mo.co");
        Assert.assertTrue(continueButton.isEnabled());
        test.get().log(Status.PASS, "User can proceed further because Email Id can handle Uppercase Letter");
        TakeSnap.captureScreenshot();
    }

    public void validateEmailAddressWithoutAtTheRateSign() {
        emailId.clear();
        emailId.sendKeys("Himanshumo.co");
        Assert.assertFalse(continueButton.isEnabled());
        test.get().log(Status.PASS, "User can't proceed further because Email Id doesn't have @ sign in the address");
        TakeSnap.captureScreenshot();
    }

    public void validateLeadingTrailingDotsAreNotAllowed() {
        emailId.clear();
        emailId.sendKeys(".himanshu@mo.co");
        Assert.assertFalse(continueButton.isEnabled());
        test.get().log(Status.PASS, "User can't proceed further because Email Id have leading dot in the address");
        TakeSnap.captureScreenshot();

        emailId.clear();
        emailId.sendKeys("himanshu@mo.co.");
        Assert.assertFalse(continueButton.isEnabled());
        test.get().log(Status.PASS, "User can't proceed further because Email Id  have trailing dot in the address");
        TakeSnap.captureScreenshot();

        emailId.clear();
        emailId.sendKeys("himan..shu@mo.co");
        Assert.assertFalse(continueButton.isEnabled());
        test.get().log(Status.PASS, "User can't proceed further because Email Id  have multiple dots in the address");
        TakeSnap.captureScreenshot();
    }

    public void validateEmailValidations() throws Exception {
        validateEmailLeadingAndTrailingSpaces();
        validateEmailAddressWithDots();
        validateEmailAddressWithPlusSign();
        validateEmailAddressWithUppercaseLetter();
        validateEmailAddressWithoutAtTheRateSign();
        validateLeadingTrailingDotsAreNotAllowed();
        enterEmailId(ex.getTestData("Email"));
    }

    public void continueButton() throws InterruptedException {
        Thread.sleep(100);
        TakeSnap.captureScreenshot();
//        if (continueButton.isEnabled()) {
        continueButton.click();
//            test.get().log(Status.PASS, "User clicked the Continue Button");
//        }
    }
    public void clickSettingButton()  {
        clickSettingButton.click();
    }


    //android.widget.TextView[@text="FX fees"]
    public void verifyAccountLabel() {
        Assert.assertTrue(verifyAccountTxt.isDisplayed());
        test.get().log(Status.PASS, "Label: '" + verifyAccountTxt.getText() + "' is displayed correctly");

        Assert.assertTrue(enterOtpTxt.isDisplayed());
        test.get().log(Status.PASS, "Label: '" + enterOtpTxt.getText() + "' is displayed correctly");
    }

    public void validatePrimeUser() {
        Assert.assertTrue(PrimeUse.isDisplayed());
        test.get().log(Status.PASS, "Label: '" + PrimeUse.getText() + "' is displayed correctly");
    }

    public void enterInvalidOtp(String number) throws InterruptedException {
        String invalidOtp = "999999";

        otpBox.click(); // Tap to focus

        AndroidDriver androidDriver = (AndroidDriver) driver;

        for (char digit : invalidOtp.toCharArray()) {
            AndroidKey key = AndroidKey.valueOf("DIGIT_" + digit);
            androidDriver.pressKey(new KeyEvent(key));
            Thread.sleep(200); // small delay to simulate typing
        }

        TakeSnap.captureScreenshot();
        // Optionally, log or assert error message for invalid OTP
        System.out.println("Entered invalid OTP: " + invalidOtp);
//        otpBox.sendKeys("123457");
//        Assert.assertTrue(invalidOtpError.isDisplayed());
//        test.get().log(Status.PASS,"Error Message: '"+ invalidOtpError.getText()+"' is displayed correctly");
//        TakeSnap.captureScreenshot();
    }

//    public void enterOtp(String otp, AndroidDriver driver) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        for (int i = 0; i < otp.length(); i++) {
//            String xpath = String.format("//android.view.ViewGroup[@content-desc='otp-input-%d']", i);
//            WebElement box = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
//            box.click();  // Focus the input
//
//            // Send digit using key event
//            char digit = otp.charAt(i);
//            AndroidKey key = AndroidKey.valueOf("DIGIT_" + digit);
//            driver.pressKey(new KeyEvent());
//        }
//
//        TakeSnap.captureScreenshot(); // optional
//    }

    public void enterOtp(String otp) throws InterruptedException {
        // Tap on the first OTP box to activate input
        TakeSnap.captureScreenshot();
        otpBox.click();

        // Enter OTP digits one-by-one
        for (char digit : otp.toCharArray()) {
            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.valueOf("DIGIT_" + digit)));
        }
    }
//        Thread.sleep(2000);

    /// /        otpBox.click();
//        otpBox.sendKeys("1");
//        TakeSnap.captureScreenshot();
//        otpBox.sendKeys(otp);
//    }
    public void validatePinLabel() {
        Assert.assertTrue(pinLabel.isDisplayed());
        test.get().log(Status.PASS, "Label: '" + pinLabel.getText() + "' is displayed correctly");
    }

    public void validateRestPinLabel() {
        Assert.assertTrue(restPinLabel.isDisplayed());
        test.get().log(Status.PASS, "Label: '" + pinLabel.getText() + "' is displayed correctly");
        Assert.assertTrue(restConfirmPinLabel.isDisplayed());
        test.get().log(Status.PASS, "Label: '" + restConfirmPinLabel.getText() + "' is displayed correctly");
    }

    public void enterPin(String pin) {
        // Click on the first OTP box to activate keyboard input
        pinCode.click();

        AndroidDriver androidDriver = (AndroidDriver) driver;

        for (char digit : pin.toCharArray()) {
            AndroidKey key = AndroidKey.valueOf("DIGIT_" + digit);
            androidDriver.pressKey(new KeyEvent(key));
        }

        TakeSnap.captureScreenshot();
    }

    //        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOf(otpBox));
//        otpBox.sendKeys("139");
//        eyeButton.click();
//        Assert.assertEquals(otpBox.getText(),"139");
//        test.get().log(Status.PASS,"Label: '"+otpBox.getText()+"' is displayed correctly after clicking on eye button");
//        TakeSnap.captureScreenshot();
//        otpBox.clear();
//        otpBox.sendKeys(pin);
//    }
    public void oldUserEnterPin(String pin) {
        // Click on the first OTP box to activate keyboard input
        pinCode.click();

        AndroidDriver androidDriver = (AndroidDriver) driver;

        for (char digit : pin.toCharArray()) {
            AndroidKey key = AndroidKey.valueOf("DIGIT_" + digit);
            androidDriver.pressKey(new KeyEvent(key));
        }

        TakeSnap.captureScreenshot();
    }

    public void validateEnterPinLabel() {
        Assert.assertTrue(oldUserPinLabel.isDisplayed());
        test.get().log(Status.PASS, "Label: '" + oldUserPinLabel.getText() + "' is displayed correctly");
    }


    public void validateConfirmPinLabel() {
        Assert.assertTrue(confirmPinLabel.isDisplayed());
        test.get().log(Status.PASS, "Label: '" + confirmPinLabel.getText() + "' is displayed correctly");
    }

    public void enterConfirmPin(String pin) {
        // Click on the first OTP box to activate keyboard input
        pinCode5.click();

        AndroidDriver androidDriver = (AndroidDriver) driver;

        for (char digit : pin.toCharArray()) {
            AndroidKey key = AndroidKey.valueOf("DIGIT_" + digit);
            androidDriver.pressKey(new KeyEvent(key));
        }

        TakeSnap.captureScreenshot();
    }

    //
//        TakeSnap.captureScreenshot();
//        otpBox.sendKeys("1234");
//        Assert.assertTrue(pinNotMatched.isDisplayed());
//        test.get().log(Status.PASS,"Error Message: '"+pinNotMatched.getText()+"' is displayed correctly");
//        TakeSnap.captureScreenshot();
//        otpBox.clear();
//        otpBox.sendKeys("1234");
//    }
    public void skipGuide() throws InterruptedException {
        Thread.sleep(50);
        skipGuide.click();
    }

    public void SelectFCYCurrency() throws InterruptedException {
        Thread.sleep(50);
        SelectCurrency.click();
    }

    public void selectCurrency(String currencyName) throws InterruptedException {
        switch (currencyName.toLowerCase()) {
            case "united states dollar":
                currencyUSD.click();
                break;
            case "british pound sterling":
                currencyGBP.click();
                break;
            case "euro":
                currencyEUR.click();
                break;
            case "australian dollar":
                currencyAUD.click();
                break;
            case "canadian dollar":
                currencyCAD.click();
                break;
            case "singapore dollar":
                currencySGD.click();
                break;
            case "japanese yen":
                currencyJPY.click();
                break;
            case "united arab emirates dirham":
                currencyAED.click();
                break;
            case "new zealand dollar":
                currencyNZD.click();
                break;
            case "swiss franc":
                currencyCHF.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid currency: " + currencyName);
        }
        TakeSnap.captureScreenshot();
        Thread.sleep(1000); // Prefer WebDriverWait in real usage
    }

    public void validateUserIoOnSendMoneyScreen() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(sendMoneyLabel));
        wait.until(ExpectedConditions.visibilityOf(liveGoogleRate));
        wait.until(ExpectedConditions.visibilityOf(allFees));
        Thread.sleep(2000);
        TakeSnap.captureScreenshot();
        test.get().log(Status.PASS, "Label: Send Money Page is displayed correctly");
    }

    public void validateUserIoOnOneDaySettlement() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(oneDay));
        Thread.sleep(2000);
        TakeSnap.captureScreenshot();
        test.get().log(Status.PASS, "Label: Send Money Page is displayed correctly");
    }

    public void validateUserIsOnKYCDocsScreen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
        wait.until(ExpectedConditions.visibilityOf(kYCDocsScreenLabel));
        wait.until(ExpectedConditions.visibilityOf(pancardLable));
        TakeSnap.captureScreenshot();
        test.get().log(Status.PASS, "Label: KYC Docs Page is displayed correctly");
        test.get().log(Status.PASS, "Label: PAN is displayed correctly");
    }


    public void validateEnterPinLabelForOldUser() {
        Assert.assertTrue(enterAppPinLabel.isDisplayed());
        test.get().log(Status.PASS, "Error Message: '" + enterAppPinLabel.getText() + "' is displayed correctly");
        Assert.assertTrue(biometricLabel.isDisplayed());
        test.get().log(Status.PASS, "Error Message: '" + biometricLabel.getText() + "' is displayed correctly");
    }

    public void setMobileNoAlreadyRegisteredError() {
        Assert.assertTrue(mobileNoAlreadyRegistered.isDisplayed());
        test.get().log(Status.PASS, "Error Message: '" + mobileNoAlreadyRegistered.getText() + "' is displayed correctly");
        TakeSnap.captureScreenshot();
    }

    public void setEmailIdAlreadyRegistered() {
        Assert.assertTrue(emailIdAlreadyRegistered.isDisplayed());
        test.get().log(Status.PASS, "Error Message: '" + emailIdAlreadyRegistered.getText() + "' is displayed correctly");
        TakeSnap.captureScreenshot();
    }

    public void setHavingTroubleLabel() {
        Assert.assertTrue(havingTroubleLabel.isDisplayed());
        test.get().log(Status.PASS, "Label: '" + havingTroubleLabel.getText() + "' is displayed correctly");
    }

    public void enterMobileNum() {
        Assert.assertTrue(enterMobileNum.isDisplayed());
        test.get().log(Status.PASS, "Label: '" + enterMobileNum.getText() + "' is displayed correctly");
    }

    public void clickResetPin() {
        resetPinButton.click();
    }

    public void resetAppPinLabel() {
        Assert.assertTrue(resetPinLabel.isDisplayed());
        test.get().log(Status.PASS, "Label: '" + resetPinLabel.getText() + "' is displayed correctly");
        Assert.assertTrue(newPinLabel.isDisplayed());
        test.get().log(Status.PASS, "Label: '" + newPinLabel.getText() + "' is displayed correctly");
    }

    public void verifyFailedToChangeAppPin() {
        Assert.assertTrue(failedToChangePin.isDisplayed());
        test.get().log(Status.PASS, "Error Message: '" + failedToChangePin.getText() + "' is displayed correctly");
    }

    public void verifySuccessToChangeAppPin() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(successChangedPinMessage.isDisplayed());
        test.get().log(Status.PASS, "Success Message: '" + successChangedPinMessage.getText() + "' is displayed correctly");
    }

    public void verifyIncorrectPin() {
        Assert.assertTrue(incorrectPin.isDisplayed());
        test.get().log(Status.PASS, "Success Message: '" + incorrectPin.getText() + "' is displayed correctly");
    }

    public void enterIbanAndProceed(String iban) throws InterruptedException {
        // Validate "IBAN" label is displayed
        if (!ibanLabel.isDisplayed()) {
            throw new IllegalStateException("IBAN label is not visible!");
        }

        // Enter IBAN
        ibanInput.sendKeys(iban);

        // Hide keyboard if visible
        driver.network();

        // Click Verify
        ibnVerifyButton.click();

        // Optional: Wait for verification to complete
        Thread.sleep(2000);

        // Click Continue
        ibaContinueButton.click();
    }

    public void clickBackButton() {
        tranBackButton.click();
    }

    public void clickLogout(boolean confirmLogout) throws InterruptedException {
        // Click on the Logout button
        WebElement logoutButton = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Logout\"]"));
        logoutButton.click();

        // Wait for the confirmation modal
        Thread.sleep(1000); // Optional - better to use WebDriverWait if needed

        if (confirmLogout) {
            // Click on "Yes" in modal
            WebElement yesBtn = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Logout_Modal_Test_Yes\"]"));
            yesBtn.click();
            System.out.println("Logout confirmed.");
        } else {
            // Click on "No" in modal
            WebElement noBtn = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Logout_Modal_Test_No\"]"));
            noBtn.click();
            System.out.println("Logout cancelled.");
        }
    }

    public void scrollFullPage() {
        boolean canScrollMore = true;

        while (canScrollMore) {
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                HashMap<String, Object> scrollParams = new HashMap<>();
                scrollParams.put("direction", "down");
                scrollParams.put("strategy", "class name");
                scrollParams.put("selector", "android.widget.ScrollView"); // You can change if needed
                canScrollMore = (Boolean) js.executeScript("mobile: scrollGesture", scrollParams);
            } catch (Exception e) {
                System.out.println("Scrolling failed: " + e.getMessage());
                break;
            }
        }

        System.out.println("Finished scrolling to the bottom.");
    }

    public void validatePaymentTexts() {
        // XPath for first message
        String expectedText1 = "Successfully paid fees to 600+ universities";
        WebElement textElement1 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Successfully paid fees to 600+ universities\"]"));
        Assert.assertTrue(textElement1.isDisplayed(), "Expected text 1 is not displayed!");
        System.out.println("Text 1 validated: " + textElement1.getText());

        // XPath for second message
        String expectedText2 = "Self transfers are not allowed. Only close blood relatives (Parents and Siblings) can send money under this purpose.";
        WebElement textElement2 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Self transfers are not allowed. Only close blood relatives (Parents and Siblings) can send money under this purpose.\"]"));
        Assert.assertTrue(textElement2.isDisplayed(), "Expected text 2 is not displayed!");
        System.out.println(" Text 2 validated: " + textElement2.getText());
    }
    public void validateRemittanceInfoTexts() {
        // Text 1: Validation
        String expectedText1 = "Self transfers are not allowed. Only close blood relatives (Parents and Siblings) can send money under this purpose.";
        WebElement restrictionText = driver.findElement(By.xpath(" //android.widget.TextView[@text=\"Self transfers are not allowed. Only close blood relatives (Parents and Siblings) can send money under this purpose.\"]"));
        Assert.assertTrue(restrictionText.isDisplayed(), "Restriction info text is not displayed!");
        System.out.println(" Restriction text validated: " + restrictionText.getText());

        // Text 2: Validation
        String expectedText2 = "₹1.8 Cr saved by Indian students last month";
        WebElement savingsText = driver.findElement(By.xpath("//android.widget.TextView[@text=\"₹1.8 Cr saved by Indian students last month\"]"));
        Assert.assertTrue(savingsText.isDisplayed(), "Savings info text is not displayed!");
        System.out.println(" Savings text validated: " + savingsText.getText());
    }

    public void validateTransferInfoTexts() {
        // 1. Text: Successfully remitted to 12,000+ families...
        String expectedText1 = "Successfully remitted to 12,000+ families in last 3 months";
        WebElement remittedText = driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + expectedText1 + "\"]"));
        Assert.assertTrue(remittedText.isDisplayed(), "Remittance info text not displayed!");
        System.out.println(" Validated: " + remittedText.getText());

        // 2. Text: The minimum amount you can send is INR 17,000...
        String expectedText2 = "The minimum amount you can send is INR 17,000. Only close blood relatives (parents, siblings or spouse) can send money under this purpose. Self-transfers are not allowed.";
        WebElement minAmtText = driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + expectedText2 + "\"]"));
        Assert.assertTrue(minAmtText.isDisplayed(), "Minimum amount + relationship rule text not displayed!");
        System.out.println(" Validated: " + minAmtText.getText());

        // 3. Text: NOSTRO charges...
        String expectedText3 = "NOSTRO charges will be charged to the beneficiary and the final receivable amount will slightly vary.";
        WebElement nostroText = driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + expectedText3 + "\"]"));
        Assert.assertTrue(nostroText.isDisplayed(), "NOSTRO charges info text not displayed!");
        System.out.println(" Validated: " + nostroText.getText());
    }

    public void validateGiftRemittanceTexts() {
        // 1. Validate minimum amount and self-transfer restriction text
        String expectedText1 = "The minimum amount you can send is INR 17,000. Under this purpose code, self-transfers are not allowed.";
        WebElement text1 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + expectedText1 + "\"]"));
        Assert.assertTrue(text1.isDisplayed(), " Minimum amount & self-transfer info not displayed!");
        System.out.println("Validated: " + text1.getText());

        // 2. Validate gift remittance count info
        String expectedText2 = "28,000+ gift remittances sent in the last 1 month";
        WebElement text2 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + expectedText2 + "\"]"));
        Assert.assertTrue(text2.isDisplayed(), " Gift remittance count text not displayed!");
        System.out.println(" Validated: " + text2.getText());

        // 3. Validate NOSTRO charges text
        String expectedText3 = "NOSTRO charges will be charged to the beneficiary and the final receivable amount will slightly vary.";
        WebElement text3 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + expectedText3 + "\"]"));
        Assert.assertTrue(text3.isDisplayed(), " NOSTRO charges text not displayed!");
        System.out.println(" Validated: " + text3.getText());
    }
    public void validatePaymentMethodTexts() {
        // 1. Validate UPI text
        String expectedText1 = "UPI";
        WebElement text1 = driver.findElement(By.xpath("//android.widget.TextView[@text='" + expectedText1 + "']"));
        Assert.assertTrue(text1.isDisplayed(), "UPI option not displayed!");
        System.out.println("Validated: " + text1.getText());

        // 2. Validate Netbanking text
        String expectedText2 = "Netbanking";
        WebElement text2 = driver.findElement(By.xpath("//android.widget.TextView[@text='" + expectedText2 + "']"));
        Assert.assertTrue(text2.isDisplayed(), "Netbanking option not displayed!");
        System.out.println("Validated: " + text2.getText());

        // 3. Validate Transfer via NEFT text
        String expectedText3 = "Transfer via NEFT";
        WebElement text3 = driver.findElement(By.xpath("//android.widget.TextView[@text='" + expectedText3 + "']"));
        Assert.assertTrue(text3.isDisplayed(), "NEFT option not displayed!");
        System.out.println("Validated: " + text3.getText());

        // 4. Validate PAN name match warning
        String expectedText4 = "Your name in the bank account (which you will use to make the payment) must match with the name in your PAN details uploaded";
        WebElement text4 = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='" + expectedText4 + "']"));
        Assert.assertTrue(text4.isDisplayed(), "PAN name match warning not displayed!");
        System.out.println("Validated: " + text4.getText());
    }


}

