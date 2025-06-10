package Pages;

import com.aventstack.extentreports.Status;
import extentReport.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import Utils.CommonFunctions;
import Utils.ExcelSetup;
import Utils.TakeSnap;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static extentReport.ExtentReportManager.test;

public class KycPage {
    private final AppiumDriver driver;

    public KycPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
    }

    CommonFunctions comFun = new CommonFunctions();

    @AndroidFindBy(xpath = "//android.view.View[@text=\"Verify your documents\"]")
    private WebElement verifyDocLabel;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='We use this to make sure your personal details are correct.']")
    private WebElement docUsageLabel;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.GroupView[2]/com.horcrux.svg.GroupView/com.horcrux.svg.RectView[3]")
    private WebElement kycBanner;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Before you start, make sure']")
    private WebElement beforeYouStartLabel;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='You have your PAN card with you']")
    private WebElement primaryDocLabel;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/com.horcrux.svg.SvgView[1]/com.horcrux.svg.GroupView")
    private WebElement blueTickPrimaryLabel;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='You have your secondary document with you (Passport/ DL/ Aadhaar/ Voter ID)']")
    private WebElement secondaryDocLabel;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue ']")
    public WebElement continueButton;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/com.horcrux.svg.SvgView[2]")
    private WebElement blueTickSecondaryLabel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Upload PAN card']")
    private WebElement uploadPanLabel;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Upload or capture a photo of the front side of your PAN card']")
    private WebElement panDescriptionLabel;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.GroupView[2]/com.horcrux.svg.RectView[2]")
    private WebElement panBanner;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/com.horcrux.svg.SvgView[1]/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    private WebElement panFirstLabelBanner;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Upload the front side of your PAN card']")
    private WebElement panFirstLabel;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/com.horcrux.svg.SvgView[2]/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    private WebElement panSecondLabelBanner;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ensure all the details are readable in the photo you upload']")
    private WebElement panSecondLabel;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/com.horcrux.svg.SvgView[3]/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    private WebElement panThirdLabelBanner;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Place documents against a solid colored background']")
    private WebElement panThirdLabel;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    private WebElement uploadPhotoButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Upload the front side of your PAN card']")
    private WebElement uploadPanDescription;
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"])[1]")
    private WebElement uploadPanCardOption;
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"])[2]")
    private WebElement uploadPassPort1;
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"])[3]")
    private WebElement uploadPassPort2;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Confirm \"]")
    private WebElement panConfirm;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Front side uploaded']")
    private WebElement frontSideUploaded;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Back side uploaded']")
    private WebElement backSideUploaded;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PAN verification']")
    private WebElement panVerificationLabel;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Verify that all the details captured in the photo are clearly visible']")
    private WebElement viewDocDescription;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Make sure the details are clearly visible']")
    private WebElement detailsVisibleLabel;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Submit photo ']")
    private WebElement submitPhotoButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"View uploaded document\"]")
    private WebElement viewUploadedDocButton;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"View uploaded document\"])[2]")
    private WebElement viewBackSideUploadedDocButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='No Pancard detected']")
    private WebElement noPanDetectedError;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Submit ']")
    private WebElement submitButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='No, Edit Details']")
    private WebElement editDetailsButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Confirm your PAN card details to complete the verification']")
    private WebElement confirmPanDetails;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PAN number doesn't match the uploaded document. Please try again with a clearer document.']")
    private WebElement invalidPanNoError;
    @AndroidFindBy(xpath = "android.widget.ImageView")
    private WebElement successImage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Document verified']")
    private WebElement documentVerifiedLabel;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Click Continue to proceed to the next step']")
    private WebElement successLabelDescription;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select any one document for address proof']")
    private WebElement selectAddressProofLabel;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PAN No.*']")
    private WebElement panNoPlaceholder;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PAN No.*']/following-sibling::android.widget.EditText")
    private WebElement panNoTextbox;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Verify ']")
    private WebElement verifyButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Yes, It’s me ']")
    private WebElement yesItsMeButton;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[10]/android.view.ViewGroup/android.view.ViewGroup")
    private WebElement clickSec;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Passport\"]")
    private WebElement passPort;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[17]/android.view.ViewGroup[1]/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    private WebElement passPortFD;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[23]/android.view.ViewGroup[1]/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    private WebElement passPortBD;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Aadhaar card']/com.horcrux.svg.SvgView[1]/com.horcrux.svg.GroupView/com.horcrux.svg.RectView")
    private WebElement aadhaarLogo;
    //    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Aadhaar card']")
    @AndroidFindBy(xpath = "    /android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[10]/android.view.ViewGroup/android.view.ViewGroup\n")
    private WebElement aadhaarLabel;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Aadhaar card']/com.horcrux.svg.SvgView[2]/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    private WebElement aadhaarArrow;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Indian Passport']/com.horcrux.svg.SvgView[1]/com.horcrux.svg.GroupView/com.horcrux.svg.PathView[3]")
    private WebElement passportLogo;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Indian Passport']")
    private WebElement passportLabel;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Indian Passport']/com.horcrux.svg.SvgView[2]/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    private WebElement passportArrow;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Driver’s license']/com.horcrux.svg.SvgView[1]/com.horcrux.svg.GroupView/com.horcrux.svg.PathView[3]")
    private WebElement driverLicenseLogo;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Driver’s license']")
    private WebElement driverLicenseLabel;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Driver’s license']/com.horcrux.svg.SvgView[2]/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    private WebElement driverLicenseArrow;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Voter ID']/com.horcrux.svg.SvgView[1]/com.horcrux.svg.GroupView/com.horcrux.svg.PathView[2]")
    private WebElement voterLogo;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Voter ID']")
    private WebElement voterLabel;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Voter ID']/com.horcrux.svg.SvgView[2]/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    private WebElement voterArrow;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Upload Aadhaar card']")
    private WebElement uploadAadhaarLabel;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Upload or capture a photo of both sides of your Aadhaar card']")
    private WebElement aadhaarDescriptionLabel;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout")
    private WebElement aadhaarBanner;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/com.horcrux.svg.SvgView[1]/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    private WebElement aadhaarFirstLabelBanner;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Upload the front and back side of your Aadhaar card']")
    private WebElement aadhaarFirstLabel;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/com.horcrux.svg.SvgView[2]/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    private WebElement aadhaarSecondLabelBanner;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ensure all the details are readable in the photo you upload']")
    private WebElement aadhaarSecondLabel;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Upload the front and back side of your Aadhaar card']")
    private WebElement uploadAadhaarDescLabel;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Upload front side, Max file size 5 MB']/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    private WebElement uploadFrontSideButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Upload back side, Max file size 5 MB']/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    private WebElement uploadBackSideButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Aadhaar verification']")
    private WebElement aadhaarVerificationLabel;
    @AndroidFindBy(xpath = "//android.webkit.WebView")
    private WebElement signaturePad;
    @AndroidFindBy(xpath = "    //android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[31]/android.view.ViewGroup/android.view.ViewGroup\n")
    private WebElement signUPClick;
    @AndroidFindBy(xpath = " //android.view.ViewGroup[@content-desc=\"Submit \"]")
    private WebElement signaturePadConform;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Cancel\"]")
    private WebElement cancelButton;



    public void clickContinueButton() {
        continueButton.click();
    }
    public void signUpClick() {
        signUPClick.click();
    }
    public void signaturePadConfirm() throws InterruptedException{
        signaturePadConform.click();
        Thread.sleep(4000);
    }
    public void cancelButton() throws InterruptedException {
        cancelButton.click();
    }

    public void verifyDocumentsBanner() {
        comFun.wait(verifyDocLabel);
        TakeSnap.captureScreenshot();
        Assert.assertTrue(verifyDocLabel.isDisplayed());
        test.get().log(Status.PASS, "Label: '" + verifyDocLabel.getText() + "' is displayed correctly");

//        Assert.assertTrue(docUsageLabel.isDisplayed());
//        test.get().log(Status.PASS,"Label: '"+docUsageLabel.getText()+"' is displayed correctly");

        //Assert.assertTrue(kycBanner.isDisplayed());
        // test.get().log(Status.PASS,"Info: Banner is displayed correctly");

//        Assert.assertTrue(beforeYouStartLabel.isDisplayed());
//        test.get().log(Status.PASS,"Label: '"+beforeYouStartLabel.getText()+"' is displayed correctly");

//        Assert.assertTrue(primaryDocLabel.isDisplayed());
//        test.get().log(Status.PASS,"Label: '"+primaryDocLabel.getText()+"' is displayed correctly");

//        Assert.assertTrue(blueTickPrimaryLabel.isDisplayed());
//        test.get().log(Status.PASS,"Info: Blue Tick is displayed correctly for Primary Doc");

//        Assert.assertTrue(secondaryDocLabel.isDisplayed());
//        test.get().log(Status.PASS,"Label: '"+secondaryDocLabel.getText()+"' is displayed correctly");

//        Assert.assertTrue(blueTickSecondaryLabel.isDisplayed());
//        test.get().log(Status.PASS,"Info: Blue Tick is displayed correctly for Secondary Doc");

    }

    public void uploadPanCardBanner() {
        comFun.wait(panDescriptionLabel);
        TakeSnap.captureScreenshot();
        Assert.assertTrue(uploadPanLabel.isDisplayed());
        test.get().log(Status.PASS, "Label: '" + uploadPanLabel.getText() + "' is displayed correctly");

        Assert.assertTrue(panDescriptionLabel.isDisplayed());
        test.get().log(Status.PASS, "Label: '" + panDescriptionLabel.getText() + "' is displayed correctly");

//        Assert.assertTrue(panBanner.isDisplayed());
        test.get().log(Status.PASS, "Info: Pan Banner is displayed correctly");

        Assert.assertTrue(panFirstLabelBanner.isDisplayed());
        test.get().log(Status.PASS, "Info: Pan First Label Banner is displayed correctly");

        Assert.assertTrue(panFirstLabel.isDisplayed());
        test.get().log(Status.PASS, "Label: '" + panFirstLabel.getText() + "' is displayed correctly");

        Assert.assertTrue(panSecondLabelBanner.isDisplayed());
        test.get().log(Status.PASS, "Info: Pan Second Label Banner is displayed correctly");

        Assert.assertTrue(panSecondLabel.isDisplayed());
        test.get().log(Status.PASS, "Label: '" + panSecondLabel.getText() + "' is displayed correctly");

        Assert.assertTrue(panThirdLabelBanner.isDisplayed());
        test.get().log(Status.PASS, "Info: Pan Third Label Banner is displayed correctly");

        Assert.assertTrue(panThirdLabel.isDisplayed());
        test.get().log(Status.PASS, "Label: '" + panThirdLabel.getText() + "' is displayed correctly");
    }

    public void uploadPhoto() throws InterruptedException{
        Thread.sleep(2000);
        uploadPhotoButton.click();
    }

    public void uploadPanCard() throws IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        TakeSnap.captureScreenshot();

        // Load PanCard.jpg from resources (classpath-safe)
        URL resource = getClass().getClassLoader().getResource("Pancard.jpg");
        if (resource == null) {
            throw new FileNotFoundException("Pancard.jpg not found in resources!");
        }
        File file = new File(resource.getFile());

        // Push file to Android device (simulator or real device)
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("Android")) {
            AndroidDriver driver1 = (AndroidDriver) driver;

            // 🧹 Step 1: Delete existing file if present
            try {
                driver1.executeScript("mobile: shell", Map.of(
                        "command", "rm",
                        "args", List.of("/sdcard/Download/Pancard.jpg")
                ));
                System.out.println("Old file deleted from simulator.");
            } catch (Exception e) {
                System.out.println("No existing file to delete or deletion failed. Proceeding anyway.");
            }

            // Step 2: Push the fresh file
            driver1.pushFile("/sdcard/Download/Pancard.jpg", file);
        }

        //Step 3: Upload from UI
        uploadPanCardOption.click();

        // Optional Screenshot
        TakeSnap.captureScreenshot();

        // Step 4: Confirm Upload
        panConfirm.click();

        TakeSnap.captureScreenshot();
    }

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        TakeSnap.captureScreenshot();
//
//        // Load Pancard.jpg from resources (classpath-safe)
//        URL resource = getClass().getClassLoader().getResource("Pancard.jpg");
//        if (resource == null) {
//            throw new FileNotFoundException("Pancard.jpg not found in resources!");
//        }
//        File file = new File(resource.getFile());
//
//        // Push file to Android device (simulator or real device)
//        if (Constants.PLATFORM_NAME.equalsIgnoreCase("Android")) {
//            AndroidDriver driver1 = (AndroidDriver) driver;
//            driver1.pushFile("/sdcard/Download/Pancard.jpg", file);
//        }
//
//        // Open file picker in app
//        uploadPanCardOption.click();
//
//        // click confirm button
//        panConfirm.click();
//        TakeSnap.captureScreenshot();


    // Wait for the file picker and select the pushed file
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        WebElement fileToSelect = driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.google.android.providers.media.module:id/icon_thumbnail'])[1]"));
//        comFun.wait(fileToSelect); // Optional custom wait
//        TakeSnap.captureScreenshot();
//        fileToSelect.click();

    // Wait for the front side of the PAN card to upload
//        comFun.wait(frontSideUploaded); // Custom wait again
//        TakeSnap.captureScreenshot();
//              Oldlogic
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        TakeSnap.captureScreenshot();

    /// /        Assert.assertTrue(uploadPanLabel.isDisplayed());
    /// /        test.get().log(Status.PASS,"Label: '"+uploadPanLabel.getText()+"' is displayed correctly");
    /// /
    /// /        Assert.assertTrue(uploadPanDescription.isDisplayed());
    /// /        test.get().log(Status.PASS,"Label: '"+uploadPanDescription.getText()+"' is displayed correctly");
//
//
//        //Push Pancard image to Android simulator
//        // Correctly load the file from the resources folder
//        File file = new File("src/main/resources/Pancard.jpg");
//        if(Constants.PLATFORM_NAME.equals("Android")){
//            AndroidDriver driver1=(AndroidDriver) driver;
//            driver1.pushFile("/sdcard/Download/Pancard.jpg",file);
//        }
//        // Open the file picker in the app
//        uploadPanCardOption.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        // Interact with Android's file picker to select the pushed file
//         WebElement fileToSelect = driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"])[1]"));
//         comFun.wait(fileToSelect);
//         TakeSnap.captureScreenshot();
//         fileToSelect.click();
//         comFun.wait(frontSideUploaded);
//         TakeSnap.captureScreenshot();
    public void viewUploadedPanDoc() {
        viewUploadedDocButton.click();

//        Assert.assertTrue(viewUploadedDocButton.isDisplayed());
//        test.get().log(Status.PASS,"Label: '"+viewUploadedDocButton.getText()+"' is displayed correctly");
//
//        Assert.assertTrue(viewDocDescription.isDisplayed());
//        test.get().log(Status.PASS,"Label: '"+viewDocDescription.getText()+"' is displayed correctly");
//
//        Assert.assertTrue(detailsVisibleLabel.isDisplayed());
//        test.get().log(Status.PASS,"Label: '"+detailsVisibleLabel.getText()+"' is displayed correctly");

        TakeSnap.captureScreenshot();

//        submitPhotoButton.click();
//        test.get().log(Status.INFO,"Info: User clicked on Submit photo button");
//
//        TakeSnap.captureScreenshot();
    }

    public void uploadRandomImage() throws IOException, InterruptedException{
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        TakeSnap.captureScreenshot();

        // Load test.jpg from resources (classpath-safe)
        URL resource = getClass().getClassLoader().getResource("test1.jpg");
        if (resource == null) {
            throw new FileNotFoundException("test1.jpg not found in resources!");
        }

        File file = new File(resource.getFile());

        // Push file to Android device
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("Android")) {
            AndroidDriver androidDriver = (AndroidDriver) driver;
            androidDriver.pushFile("/sdcard/Download/test1.jpg", file);
        }

        // Trigger file picker (assumes UI element is present and ready)
        uploadPanCardOption.click();

        // Click confirm/continue after selecting the file
//        panConfirm.click();
        Thread.sleep(2000);
        TakeSnap.captureScreenshot();
    }

//        File file = new File("src/main/resources/test1.jpg");
//        if(Constants.PLATFORM_NAME.equals("Android")){
//            AndroidDriver driver1=(AndroidDriver) driver;
//            driver1.pushFile("/sdcard/Download/test1.jpg",file);
//        }
//        // Open the file picker in the app
//        uploadPanCardOption.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        // Interact with Android's file picker to select the pushed file
//        WebElement fileToSelect = driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"])[1]"));
//        comFun.wait(fileToSelect);
//        TakeSnap.captureScreenshot();
//        fileToSelect.click();
//
//        comFun.wait(noPanDetectedError);
//        Assert.assertTrue(noPanDetectedError.isDisplayed());
//        test.get().log(Status.PASS,"Error Message: '"+noPanDetectedError.getText()+"' is displayed correctly");
//
//        TakeSnap.captureScreenshot();


    public void submitButton(){
        submitButton.click();
    }

    public void confirmPanDetails(){
        Assert.assertTrue(panVerificationLabel.isDisplayed());
        test.get().log(Status.PASS,"Label: '"+panVerificationLabel.getText()+"' is displayed correctly");

        Assert.assertTrue(confirmPanDetails.isDisplayed());
        test.get().log(Status.PASS,"Label: '"+confirmPanDetails.getText()+"' is displayed correctly");

        Assert.assertEquals(panNoTextbox.getText(),"IXQPS1780A");
        test.get().log(Status.PASS,"Info: '"+panNoTextbox.getText()+"' is displayed correctly");
        TakeSnap.captureScreenshot();
    }
    public void editPanDetails() throws InterruptedException {
        editDetailsButton.click();
        test.get().log(Status.PASS,"User clicked on No, Edit Details Button");

        panNoTextbox.clear();
        panNoTextbox.sendKeys("IXQPS2345G");
        test.get().log(Status.INFO,"User entered incorrect Pan no.");
        verifyButton.click();
        Thread.sleep(2000);
        TakeSnap.captureScreenshot();
        test.get().log(Status.PASS, "Error: Invalid Pan Error is displayed correctly");


        panNoTextbox.clear();
        panNoTextbox.sendKeys("IXQPS1780A");
        test.get().log(Status.INFO,"User entered correct Pan no.");
        TakeSnap.captureScreenshot();
        verifyButton.click();
    }

    public void documentVerificationSuccess(){
        comFun.wait(documentVerifiedLabel);

        Assert.assertTrue(documentVerifiedLabel.isDisplayed());
        test.get().log(Status.PASS,"Label: '"+documentVerifiedLabel.getText()+"' is displayed correctly");

        Assert.assertTrue(successLabelDescription.isDisplayed());
        test.get().log(Status.PASS,"Label: '"+successLabelDescription.getText()+"' is displayed correctly");
        TakeSnap.captureScreenshot();
    }

    public void setYesItsMeButton(){
        yesItsMeButton.click();
        test.get().log(Status.PASS,"User clicked on Yes, It's me Button");
    }
    public void clickSecDos(){
        clickSec.click();
    }
    public void PassPort() throws InterruptedException{
        Thread.sleep(2000);
        passPort.click();
    }
    public void PassPortFD() throws InterruptedException{
        Thread.sleep(2000);
        passPortFD.click();
    }
    public void PassPortBD() throws InterruptedException{
        Thread.sleep(2000);
        passPortBD.click();
    }

    public void verifyLabelAndLogoSecondaryDoc() {
        Assert.assertTrue(selectAddressProofLabel.isDisplayed());
        test.get().log(Status.PASS,"Label: '"+selectAddressProofLabel.getText()+"' is displayed correctly");

        Assert.assertTrue(aadhaarLogo.isDisplayed());
        Assert.assertTrue(aadhaarLabel.isDisplayed());
        Assert.assertTrue(aadhaarArrow.isDisplayed());
        test.get().log(Status.PASS,"Info: Aadhaar Logo, Label and Arrow is displayed correctly");

        Assert.assertTrue(passportLogo.isDisplayed());
        Assert.assertTrue(passportLabel.isDisplayed());
        Assert.assertTrue(passportArrow.isDisplayed());
        test.get().log(Status.PASS,"Info: Indian Passport Logo, Label and Arrow is displayed correctly");

        Assert.assertTrue(driverLicenseLogo.isDisplayed());
        Assert.assertTrue(driverLicenseLabel.isDisplayed());
        Assert.assertTrue(driverLicenseArrow.isDisplayed());
        test.get().log(Status.PASS,"Info: Driver License Logo, Label and Arrow is displayed correctly");

        Assert.assertTrue(voterLogo.isDisplayed());
        Assert.assertTrue(voterLabel.isDisplayed());
        Assert.assertTrue(voterArrow.isDisplayed());
        test.get().log(Status.PASS,"Info: Voter Id Logo, Label and Arrow is displayed correctly");
        TakeSnap.captureScreenshot();
    }

    public void uploadAadhaarBanner(){
        TakeSnap.captureScreenshot();
        aadhaarLabel.click();

        comFun.wait(aadhaarDescriptionLabel);
        TakeSnap.captureScreenshot();
        Assert.assertTrue(uploadAadhaarLabel.isDisplayed());
        test.get().log(Status.PASS,"Label: '"+uploadAadhaarLabel.getText()+"' is displayed correctly");

        Assert.assertTrue(aadhaarDescriptionLabel.isDisplayed());
        test.get().log(Status.PASS,"Label: '"+aadhaarDescriptionLabel.getText()+"' is displayed correctly");

        Assert.assertTrue(aadhaarBanner.isDisplayed());
        test.get().log(Status.PASS,"Info: Aadhaar Banner is displayed correctly");

        Assert.assertTrue(aadhaarFirstLabelBanner.isDisplayed());
        test.get().log(Status.PASS,"Info: Aadhaar First Label Banner is displayed correctly");

        Assert.assertTrue(aadhaarFirstLabel.isDisplayed());
        test.get().log(Status.PASS,"Label: '"+aadhaarFirstLabel.getText()+"' is displayed correctly");

        Assert.assertTrue(aadhaarSecondLabelBanner.isDisplayed());
        test.get().log(Status.PASS,"Info: Aadhaar Second Label Banner is displayed correctly");

        Assert.assertTrue(aadhaarSecondLabel.isDisplayed());
        test.get().log(Status.PASS,"Label: '"+aadhaarSecondLabel.getText()+"' is displayed correctly");
    }

    public void uploadFrontAadhaar() throws IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        TakeSnap.captureScreenshot();

        // Load Aadhar.jpg from resources (classpath-safe)
        URL resource = getClass().getClassLoader().getResource("Abh_PASSPORTFRont.jpg");
        if (resource == null) {
            throw new FileNotFoundException("Abh_PASSPORTFRont.jpg not found in resources!");
        }
        File file = new File(resource.getFile());

        // Push file to Android device (simulator or real device)
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("Android")) {
            AndroidDriver driver1 = (AndroidDriver) driver;
            driver1.pushFile("/sdcard/Download/Abh_PASSPORTFRont.jpg", file);
        }

        // Open file picker in app
        uploadPanCardOption.click();

        // click confirm button
//        panConfirm.click();
//        TakeSnap.captureScreenshot();

//        comFun.wait(aadhaarLabel);
//        TakeSnap.captureScreenshot();
//        aadhaarLabel.click();
//
//        TakeSnap.captureScreenshot();
//        uploadPhoto();
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        TakeSnap.captureScreenshot();
//        Assert.assertTrue(uploadAadhaarLabel.isDisplayed());
//        test.get().log(Status.PASS, "Label: '" + uploadAadhaarLabel.getText() + "' is displayed correctly");
//
//        Assert.assertTrue(uploadAadhaarDescLabel.isDisplayed());
//        test.get().log(Status.PASS, "Label: '" + uploadAadhaarDescLabel.getText() + "' is displayed correctly");
//
//
//        //Push Aadhaar image to Android simulator
//        File file = new File("src/main/resources/Aadhaarcard.jpg");
//        AndroidDriver driver1 = null;
//        if (Constants.PLATFORM_NAME.equals("Android")) {
//            driver1 = (AndroidDriver) driver;
//            driver1.pushFile("/sdcard/Download/Aadhaarcard.jpg", file);
//        }
//        // Open the file picker in the app
//        uploadFrontSideButton.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        // Interact with Android's file picker to select the pushed file
//        WebElement fileToSelect = driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"])[1]"));
//        comFun.wait(fileToSelect);
//        TakeSnap.captureScreenshot();
//        fileToSelect.click();
//        comFun.wait(frontSideUploaded);
//        TakeSnap.captureScreenshot();
//        test.get().log(Status.PASS, "Label: Aadhaar Front Side Uploaded Successfully");
//        //Push Aadhaar image to Android simulator;
//        File file1 = new File("src/main/resources/AadhaarCardBack.jpg");
//        driver1.pushFile("/sdcard/Download/AadhaarCardBack.jpg", file1);
//
//        // Open the file picker in the app
//        uploadBackSideButton.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        // Interact with Android's file picker to select the pushed file
//        WebElement fileToSelect1 = driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"])[1]"));
//        comFun.wait(fileToSelect1);
//        TakeSnap.captureScreenshot();
//        fileToSelect1.click();
//        comFun.wait(frontSideUploaded);
//        test.get().log(Status.PASS, "Label: Aadhaar Back Side Uploaded Successfully");
//        TakeSnap.captureScreenshot();
    }
    public void uploadBackAadhaar() throws IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        TakeSnap.captureScreenshot();

        // Load Aadhar.jpg from resources (classpath-safe)
        URL resource = getClass().getClassLoader().getResource("Abh_PASSPORTFRont.jpg");
        if (resource == null) {
            throw new FileNotFoundException("Abh_PASSPORTFRont.jpg not found in resources!");
        }
        File file = new File(resource.getFile());

        // Push file to Android device (simulator or real device)
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("Android")) {
            AndroidDriver driver1 = (AndroidDriver) driver;
            driver1.pushFile("/sdcard/Download/Abh_PASSPORTFRont.jpg", file);
        }

        // Open file picker in app
        uploadPanCardOption.click();

        // click confirm button
        panConfirm.click();
        TakeSnap.captureScreenshot();
    }

    public void uploadFrontPassPort() throws IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        TakeSnap.captureScreenshot();

        // Load passport.jpg from resources (classpath-safe)
        URL resource = getClass().getClassLoader().getResource("Abh_PASSPORTFRont.jpg");
        if (resource == null) {
            throw new FileNotFoundException("Abh_PASSPORTFRont.jpg not found in resources!");
        }
        File file = new File(resource.getFile());

        // Push file to Android device (simulator or real device)
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("Android")) {
            AndroidDriver driver1 = (AndroidDriver) driver;
            driver1.pushFile("/sdcard/Download/Abh_PASSPORTFRont.jpg", file);
        }

        // Open file picker in app
        uploadPanCardOption.click();
    }

    public void uploadBackPassPort() throws IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        TakeSnap.captureScreenshot();

        // Load passport.jpg from resources (classpath-safe)
        URL resource = getClass().getClassLoader().getResource("abh_PASSPORTBACK.jpg");
        if (resource == null) {
            throw new FileNotFoundException("abh_PASSPORTBACK.jpg not found in resources!");
        }
        File file = new File(resource.getFile());

        // Push file to Android device (simulator or real device)
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("Android")) {
            AndroidDriver driver1 = (AndroidDriver) driver;
            driver1.pushFile("/sdcard/Download/abh_PASSPORTBACK.jpg", file);
        }

        // Open file picker in app
        uploadPanCardOption.click();

        // click confirm button
        panConfirm.click();
        TakeSnap.captureScreenshot();
    }
    public void uploadFrontVoterId() throws IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        TakeSnap.captureScreenshot();

        // Load voterId.jpg from resources (classpath-safe)
        URL resource = getClass().getClassLoader().getResource("supriya voter front.jpg");
        if (resource == null) {
            throw new FileNotFoundException("supriya voter front.jpg not found in resources!");
        }
        File file = new File(resource.getFile());

        // Push file to Android device (simulator or real device)
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("Android")) {
            AndroidDriver driver1 = (AndroidDriver) driver;
            driver1.pushFile("/sdcard/Download/supriya voter front.jpg", file);
        }

        // Open file picker in app
        uploadPanCardOption.click();
    }
    public void uploadBackVoterId() throws IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        TakeSnap.captureScreenshot();

        // Load voterId.jpg from resources (classpath-safe)
        URL resource = getClass().getClassLoader().getResource("supriya voter back.jpg");
        if (resource == null) {
            throw new FileNotFoundException("supriya voter back.jpg not found in resources!");
        }
        File file = new File(resource.getFile());

        // Push file to Android device (simulator or real device)
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("Android")) {
            AndroidDriver driver1 = (AndroidDriver) driver;
            driver1.pushFile("/sdcard/Download/supriya voter back.jpg", file);
        }

        // Open file picker in app
        uploadPanCardOption.click();

        // click confirm button
        panConfirm.click();
        TakeSnap.captureScreenshot();
    }

    public void viewUploadedFrontSideAadhaarDoc(){
        viewUploadedDocButton.click();
        Assert.assertTrue(aadhaarVerificationLabel.isDisplayed());
        test.get().log(Status.PASS,"Label: '"+aadhaarVerificationLabel.getText()+"' is displayed correctly");

        Assert.assertTrue(viewDocDescription.isDisplayed());
        test.get().log(Status.PASS,"Label: '"+viewDocDescription.getText()+"' is displayed correctly");

        Assert.assertTrue(detailsVisibleLabel.isDisplayed());
        test.get().log(Status.PASS,"Label: '"+detailsVisibleLabel.getText()+"' is displayed correctly");

        TakeSnap.captureScreenshot();

        submitPhotoButton.click();
        test.get().log(Status.INFO,"Info: User clicked on Submit photo button");

        comFun.wait(frontSideUploaded);
        TakeSnap.captureScreenshot();
        test.get().log(Status.INFO,"Info: User is able to view Front side of the Uploaded Aadhaar");
    }

    public void viewUploadedBackSideAadhaarDoc(){
        viewBackSideUploadedDocButton.click();
        Assert.assertTrue(aadhaarVerificationLabel.isDisplayed());
        test.get().log(Status.PASS,"Label: '"+aadhaarVerificationLabel.getText()+"' is displayed correctly");

        Assert.assertTrue(viewDocDescription.isDisplayed());
        test.get().log(Status.PASS,"Label: '"+viewDocDescription.getText()+"' is displayed correctly");

        Assert.assertTrue(detailsVisibleLabel.isDisplayed());
        test.get().log(Status.PASS,"Label: '"+detailsVisibleLabel.getText()+"' is displayed correctly");

        TakeSnap.captureScreenshot();

        submitPhotoButton.click();
        test.get().log(Status.INFO,"Info: User clicked on Submit photo button");
        comFun.wait(frontSideUploaded);
        TakeSnap.captureScreenshot();
        test.get().log(Status.INFO,"Info: User is able to view Back side of the Uploaded Aadhaar");
    }

    public void drawSignature()  throws InterruptedException{
           // Get element location and size
            org.openqa.selenium.Point location = signaturePad.getLocation();
            Dimension size = signaturePad.getSize();

            int startX = (int) (location.getX() + size.getWidth() / 4);
             int startY = (int) (location.getY() + size.getHeight() / 2);
            int endX = startX + 200;
            int endY = startY + 100;

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence drawPath = new Sequence(finger, 1);

            drawPath.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
            drawPath.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            drawPath.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, endY));
            drawPath.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(drawPath));
    }

    }


