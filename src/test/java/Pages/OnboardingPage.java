package Pages;

import com.aventstack.extentreports.Status;
import extentReport.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Utils.*;

import java.time.Duration;
import java.util.Random;

import static extentReport.ExtentReportManager.test;



public class OnboardingPage  {
    private final AppiumDriver driver;

    public OnboardingPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);

    }

     ExcelSetup ex=new ExcelSetup();

   @iOSXCUITFindBy(accessibility = "redbox-dismiss")
    private WebElement dismissButton;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Smarter. Faster.\n" +
           "Better. way to send money abroad\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Smarter. Faster.\n" +
            "Better. way to send money abroad\"]")
    private WebElement smarterTxt;
    @AndroidFindBy(className = "android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Smarter. Faster.\n" +
                    "Better. way to send money abroad Get Started by continuing, I agree to theand Horizontal scroll bar, 1 page Toolbar\"])[6]/XCUIElementTypeOther[2]/XCUIElementTypeOther" )
    private WebElement sendMoneyImage;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Get started']")
    @iOSXCUITFindBy(accessibility = "Get Started" )
    private WebElement getStarted;
    @AndroidFindBy(className = "com.horcrux.svg.PathView")
    @iOSXCUITFindBy(xpath ="(//XCUIElementTypeOther[@name='Enter your phone number and email'])[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private WebElement backButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter your phone number and email']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Enter your phone number and email']")
    private WebElement labelPhoneNoAndEmail;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Phone No.*\"])[2]")
    private WebElement phoneNo;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Email\"])[2]")
    private WebElement emailId;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Continue']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Continue\"]")
    private WebElement continueButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Phone No.*']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Phone No.*\"]")
    private WebElement phoneNoPlaceholder;
      @AndroidFindBy(xpath = "//android.widget.TextView[@text='Email*']")
      @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Email\"]")
    private WebElement emailPlaceholder;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Verify your account']")
    private WebElement verifyAccountTxt;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter the OTP sent to your phone number']")
    private WebElement enterOtpTxt;
    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement otpBox;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[2]")
    private WebElement otpBox2;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[3]")
    private WebElement otpBox3;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[4]")
    private WebElement otpBox4;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[5]")
    private WebElement otpBox5;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[6]")
    private WebElement otpBox6;
    @FindBy(xpath = "//android.widget.TextView[@text='Please choose your 4-digit app pin']")
    private WebElement pinLabel;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Confirm your 4-digit app pin']")
    private WebElement confirmPinLabel;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Send Money']")
    private WebElement sendMoneyLabel;

    @AndroidFindAll({
            @AndroidBy(xpath="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView"),
            @AndroidBy(xpath="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView")
    })
    private WebElement eyeButton;
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Invalid Otp']")
    private WebElement invalidOtpError;
    @AndroidFindBy(xpath="//android.widget.TextView[@text='The passcode you have entered does not match']")
    private WebElement pinNotMatched;
    @AndroidFindBy(xpath="//android.widget.TextView[@text='+91']")
    private WebElement phoneNoCountryCode;
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Enter your App Pin']")
    private WebElement enterAppPinLabel;
    @AndroidFindBy(xpath=" //android.widget.TextView[@text='Tap to login with device Biometric ID lock']")
    private WebElement biometricLabel;
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Mobile no is already registered.']")
    private WebElement mobileNoAlreadyRegistered;
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Entered phoneNumber is already linked with ******']")
    private WebElement emailIdAlreadyRegistered;
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Having trouble? ']")
    private WebElement havingTroubleLabel;
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Reset Pin']")
    private WebElement resetPinButton;
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Reset App Pin']")
    private WebElement resetPinLabel;
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Failed to change app pin']")
    private WebElement failedToChangePin;
    @AndroidFindBy(xpath="//android.widget.Toast[@text='Successfully changed app pin']")
    private WebElement successChangedPinMessage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Please choose your new 4-digit app pin']")
    private WebElement newPinLabel;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Incorrect Pin']")
    private WebElement incorrectPin;

    public void dismissButton() throws Exception {
        dismissButton.click();
        if(dismissButton.isDisplayed()){
            dismissButton.click();
        }
    }
    public void moneyHopMoto() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertTrue(smarterTxt.isDisplayed());
        test.get().log(Status.PASS,"Homepage message: "+smarterTxt.getText());
    }
    public void sendMoneyImage(){
        Assert.assertTrue(sendMoneyImage.isDisplayed());
        test.get().log(Status.PASS,"Send money Image is displayed on the Hop App");
        TakeSnap.captureScreenshot();
    }

    public void getStarted() throws InterruptedException {
        getStarted.click();
        test.get().log(Status.PASS,"User has clicked on Get Started Button");
        Thread.sleep(1000);
        TakeSnap.captureScreenshot();
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
        test.get().log(Status.INFO,"Label: "+labelPhoneNoAndEmail.getText());

    }
    public void enterPhoneNo(String phoneNoTxt) throws Exception {
        phoneNo.sendKeys(phoneNoTxt);
    }
    public void enterRandomPhoneNo(String phoneNoTxt){
        emailId.clear();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(99999);
        phoneNo.sendKeys(phoneNoTxt+ randomInt);
        test.get().log(Status.PASS, "User entered the Valid Phone No.");
        phoneNo.sendKeys(phoneNoTxt);
    }

    public void incorrectEnterPhoneNo(String phoneNoTxt) throws Exception {
        phoneNo.sendKeys(phoneNoTxt);
    }

    public void validatePhoneNoCountryCode(){
        Assert.assertTrue(phoneNoCountryCode.isDisplayed());
        test.get().log(Status.INFO,"Label: '"+phoneNoCountryCode.getText()+"' is correctly displayed");
    }

    public void enterEmailId(String email) throws Exception {
        emailId.clear();
        Random randomGenerator = new Random();

        int randomInt = randomGenerator.nextInt(100000);
        emailId.sendKeys(email+ randomInt +"@moneyhop.com");
        Thread.sleep(2000);
        test.get().log(Status.PASS, "User entered the Valid Email Id");
        TakeSnap.captureScreenshot();
    }
    public void enterOldEmailId(String email){
        emailId.sendKeys(email);
        test.get().log(Status.PASS, "User entered the Email Id");
    }

    public void enterIncorrectEmailId(String email){
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

    public void validatePhoneNoDoesNotAcceptSpecialCharacter(){
        phoneNo.clear();
        phoneNo.sendKeys("895556512%");
        Assert.assertFalse(continueButton.isEnabled());
        test.get().log(Status.PASS, "User cannot proceed further because entered Phone no. contains Special character");
        TakeSnap.captureScreenshot();
    }

    public void validatePhoneNoDoesNotAcceptSpaces(){
        phoneNo.clear();
        phoneNo.sendKeys("89555 6512");
        Assert.assertFalse(continueButton.isEnabled());
        test.get().log(Status.PASS, "User cannot proceed further because entered Phone no. contains spaces");
        TakeSnap.captureScreenshot();
    }

    public void validatePhoneNoDoesNotAcceptNullValue(){
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

    public void validateEmailLeadingAndTrailingSpaces(){
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

    public void validateEmailAddressWithDots(){
        emailId.clear();
        emailId.sendKeys("himanshu.sharma@mo.co");
        Assert.assertTrue(continueButton.isEnabled());
        test.get().log(Status.PASS, "User can proceed further because Email Id can handle dots");
        TakeSnap.captureScreenshot();
    }

    public void validateEmailAddressWithPlusSign(){
        emailId.clear();
        emailId.sendKeys("himanshu.sharma+12@mo.co");
        Assert.assertTrue(continueButton.isEnabled());
        test.get().log(Status.PASS, "User can proceed further because Email Id can handle plus sign");
        TakeSnap.captureScreenshot();
    }

    public void validateEmailAddressWithUppercaseLetter(){
        emailId.clear();
        emailId.sendKeys("Himanshu.sharma@mo.co");
        Assert.assertTrue(continueButton.isEnabled());
        test.get().log(Status.PASS, "User can proceed further because Email Id can handle Uppercase Letter");
        TakeSnap.captureScreenshot();
    }

    public void validateEmailAddressWithoutAtTheRateSign(){
        emailId.clear();
        emailId.sendKeys("Himanshumo.co");
        Assert.assertFalse(continueButton.isEnabled());
        test.get().log(Status.PASS, "User can't proceed further because Email Id doesn't have @ sign in the address");
        TakeSnap.captureScreenshot();
    }

    public void validateLeadingTrailingDotsAreNotAllowed(){
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
        Thread.sleep(2000);
        TakeSnap.captureScreenshot();
        if (continueButton.isEnabled()) {
            continueButton.click();
            test.get().log(Status.PASS, "User clicked the Continue Button");
        }
    }

    public void verifyAccountLabel(){
        Assert.assertTrue(verifyAccountTxt.isDisplayed());
        test.get().log(Status.PASS,"Label: '"+verifyAccountTxt.getText()+"' is displayed correctly");

        Assert.assertTrue(enterOtpTxt.isDisplayed());
        test.get().log(Status.PASS,"Label: '"+ enterOtpTxt.getText()+"' is displayed correctly");
    }

    public void enterInvalidOtp(){
        otpBox.sendKeys("123457");
        Assert.assertTrue(invalidOtpError.isDisplayed());
        test.get().log(Status.PASS,"Error Message: '"+ invalidOtpError.getText()+"' is displayed correctly");
        TakeSnap.captureScreenshot();
    }

    public void enterOtp(String otp) throws InterruptedException {
        Thread.sleep(2000);
        otpBox.clear();
        otpBox.sendKeys("12345");
        TakeSnap.captureScreenshot();
        otpBox.sendKeys(otp);
    }

    public void validatePinLabel(){
        Assert.assertTrue(pinLabel.isDisplayed());
        test.get().log(Status.PASS,"Label: '"+pinLabel.getText()+"' is displayed correctly");
    }

    public void enterPin(String pin){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(otpBox));
        otpBox.sendKeys("139");
        eyeButton.click();
        Assert.assertEquals(otpBox.getText(),"139");
        test.get().log(Status.PASS,"Label: '"+otpBox.getText()+"' is displayed correctly after clicking on eye button");
        TakeSnap.captureScreenshot();
        otpBox.clear();
        otpBox.sendKeys(pin);
    }

    public void validateConfirmPinLabel(){
        Assert.assertTrue(confirmPinLabel.isDisplayed());
        test.get().log(Status.PASS,"Label: '"+confirmPinLabel.getText()+"' is displayed correctly");
    }

    public void enterConfirmPin() throws InterruptedException {
        TakeSnap.captureScreenshot();
        otpBox.sendKeys("1392");
        Assert.assertTrue(pinNotMatched.isDisplayed());
        test.get().log(Status.PASS,"Error Message: '"+pinNotMatched.getText()+"' is displayed correctly");
        TakeSnap.captureScreenshot();
        otpBox.clear();
        otpBox.sendKeys("1390");
    }

    public void validateUserIoOnSendMoneyScreen() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(sendMoneyLabel));
        Thread.sleep(2000);
        TakeSnap.captureScreenshot();
        test.get().log(Status.PASS,"Label: Send Money Page is displayed correctly");
    }

    public void validateEnterPinLabelForOldUser(){
        Assert.assertTrue(enterAppPinLabel.isDisplayed());
        test.get().log(Status.PASS,"Error Message: '"+enterAppPinLabel.getText()+"' is displayed correctly");
        Assert.assertTrue(biometricLabel.isDisplayed());
        test.get().log(Status.PASS,"Error Message: '"+biometricLabel.getText()+"' is displayed correctly");
    }

    public void setMobileNoAlreadyRegisteredError(){
        Assert.assertTrue(mobileNoAlreadyRegistered.isDisplayed());
        test.get().log(Status.PASS,"Error Message: '"+mobileNoAlreadyRegistered.getText()+"' is displayed correctly");
        TakeSnap.captureScreenshot();
    }
    public void setEmailIdAlreadyRegistered(){
        Assert.assertTrue(emailIdAlreadyRegistered.isDisplayed());
        test.get().log(Status.PASS,"Error Message: '"+emailIdAlreadyRegistered.getText()+"' is displayed correctly");
        TakeSnap.captureScreenshot();
    }
    public void setHavingTroubleLabel(){
        Assert.assertTrue(havingTroubleLabel.isDisplayed());
        test.get().log(Status.PASS,"Label: '"+havingTroubleLabel.getText()+"' is displayed correctly");
    }
    public void clickResetPin(){
        resetPinButton.click();
    }
    public void resetAppPinLabel(){
        Assert.assertTrue(resetPinLabel.isDisplayed());
        test.get().log(Status.PASS,"Label: '"+resetPinLabel.getText()+"' is displayed correctly");
        Assert.assertTrue(newPinLabel.isDisplayed());
        test.get().log(Status.PASS,"Label: '"+newPinLabel.getText()+"' is displayed correctly");
    }
    public void verifyFailedToChangeAppPin(){
        Assert.assertTrue(failedToChangePin.isDisplayed());
        test.get().log(Status.PASS,"Error Message: '"+failedToChangePin.getText()+"' is displayed correctly");
    }
    public void verifySuccessToChangeAppPin() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(successChangedPinMessage.isDisplayed());
        test.get().log(Status.PASS,"Success Message: '"+successChangedPinMessage.getText()+"' is displayed correctly");
    }
    public void verifyIncorrectPin(){
        Assert.assertTrue(incorrectPin.isDisplayed());
        test.get().log(Status.PASS,"Success Message: '"+incorrectPin.getText()+"' is displayed correctly");
    }
        }

