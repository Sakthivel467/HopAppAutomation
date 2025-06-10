package TestCases;

import DriverSetup.BaseTest;
import Utils.TakeSnap;
import extentReport.Constants;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import Utils.ExcelSetup;

public class KycTest  extends BaseTest {

    ExcelSetup ex = new ExcelSetup();


    @Test(priority = 20)
    public void TC020_Label_Banner_Kyc_Homepage() throws Exception {
        before("TC020 - Verify the Labels and Banners on the Verify Your Documents Page");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("7087087087");
        onboardingPage.enterOldEmailId("testduplicateemail@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.enterPin("1918");
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("overseas education - university fees");
        sendMoneyPage.confirmButton();
        sendMoneyPage.setSendMoneyButton();

    }

    @Test(priority = 21)
    public void TC022_Upload_Pan_Card() throws Exception {
        before("TC021 - Verify the Labels and Banners on the 'Upload PAN Card' Page");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        onboardingPage.getStarted();
        onboardingPage.enterRandomPhoneNo();
        onboardingPage.enterEmailId("testkyc");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.enterPin("1234");
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("family maintenance");
        sendMoneyPage.confirmButton();
        sendMoneyPage.setOnetimeVerificationButton();
        onboardingPage.validateUserIsOnKYCDocsScreen();
        kycPage.uploadPhoto();
        kycPage.uploadPanCard();
        kycPage.viewUploadedPanDoc();

    }

    @Test(priority = 23)
    public void TC023_Upload_Random_Image_In_Pan_Card() throws Exception {
        before("TC023 - Upload a Random Image in the PAN Card Document Upload Section");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        onboardingPage.getStarted();
        onboardingPage.enterRandomPhoneNo();
        onboardingPage.enterEmailId("testkyc");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.enterPin("1234");
        onboardingPage.enterConfirmPin("1234");
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("family maintenance");
        sendMoneyPage.confirmButton();
        sendMoneyPage.setOnetimeVerificationButton();
        onboardingPage.validateUserIsOnKYCDocsScreen();
        kycPage.uploadPhoto();
        kycPage.uploadRandomImage();
    }

    @Test(priority = 24)
    public void TC024_Edit_Pan_Card_Details() throws Exception {
        before("TC024 - Verify Edit PAN Card Option by Entering Incorrect and Correct PAN No.");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("9999999999");
        onboardingPage.enterEmailId("testkyc");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.validatePinLabel();
        onboardingPage.enterPin("1390");
        onboardingPage.validateConfirmPinLabel();
        onboardingPage.enterConfirmPin("1234");
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.setSendMoneyButton();
        kycPage.clickContinueButton();
        kycPage.uploadPhoto();
        kycPage.uploadPanCard();
        kycPage.submitButton();
        kycPage.confirmPanDetails();
        kycPage.editPanDetails();
        kycPage.documentVerificationSuccess();
    }

    @Test(priority = 25)
    public void TC025_Pan_Card_KYC() throws Exception {
        before("TC025 - Verify User Successfully Completes the KYC of PAN Card");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("9999999999");
        onboardingPage.enterEmailId("testkyc");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.validatePinLabel();
        onboardingPage.enterPin("1390");
        onboardingPage.validateConfirmPinLabel();
        onboardingPage.enterConfirmPin("1234");
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.setSendMoneyButton();
        kycPage.clickContinueButton();
        kycPage.uploadPhoto();
        kycPage.uploadPanCard();
        kycPage.submitButton();
        kycPage.confirmPanDetails();
        kycPage.setYesItsMeButton();
        kycPage.documentVerificationSuccess();
    }

    @Test(priority = 26)
    public void TC026_Verify_Labels_Secondary_Documents() throws Exception {
        before("TC026 - Verify the Labels and All Secondary Document Options");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        onboardingPage.getStarted();
        onboardingPage.enterRandomPhoneNo();
        onboardingPage.enterEmailId("testkyc");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.validatePinLabel();
        onboardingPage.enterPin("1390");
        onboardingPage.validateConfirmPinLabel();
        onboardingPage.enterConfirmPin("1234");
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.setSendMoneyButton();
        kycPage.clickContinueButton();
        kycPage.uploadPhoto();
        kycPage.uploadPanCard();
        kycPage.submitButton();
        kycPage.confirmPanDetails();
        kycPage.setYesItsMeButton();
        kycPage.documentVerificationSuccess();
        kycPage.clickContinueButton();
        kycPage.verifyLabelAndLogoSecondaryDoc();
    }

    @Test(priority = 27)
    public void TC027_Verify_Labels_Upload_Aadhaar_Page() throws Exception {
        before("TC027 - Verify the Labels and Banners on the Upload Aadhaar Card Page");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("7082087084");
        onboardingPage.enterOldEmailId("testduplicateemail2@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.enterPin("1234");
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.confirmButton();
        sendMoneyPage.setOnetimeVerificationButton();
        onboardingPage.validateUserIsOnKYCDocsScreen();
        kycPage.uploadAadhaarBanner();
    }

    @Test(priority = 28)
    public void TC028_Upload_PassPort_Front_And_Back() throws Exception {
        before("TC028 - Upload the Aadhaar Card Front & Back and View the Uploaded Document");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        onboardingPage.getStarted();
        onboardingPage.enterRandomPhoneNo();
        onboardingPage.enterEmailId("testkyc");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.validatePinLabel();
        onboardingPage.enterPin("1234");
        onboardingPage.validateConfirmPinLabel();
        onboardingPage.enterConfirmPin("1234");
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("personal gift or donation");
        sendMoneyPage.confirmButton();
        sendMoneyPage.setOnetimeVerificationButton();
        onboardingPage.validateUserIsOnKYCDocsScreen();
        kycPage.uploadPhoto();
        kycPage.cancelButton();
        kycPage.uploadPhoto();
        kycPage.uploadPanCard();
        kycPage.clickSecDos();
        kycPage.PassPort();
        kycPage.PassPortFD();
        kycPage.cancelButton();
        kycPage.PassPortFD();
        kycPage.uploadFrontPassPort();
        kycPage.PassPortBD();
        kycPage.uploadBackPassPort();
        kycPage.signUpClick();
        kycPage.drawSignature();
        kycPage.signaturePadConfirm();
        sendMoneyPage.selectRecipientType("institution");
    }


    @Test(priority = 29)
    public void TC029_Upload_Random_Image_In_Aadhaar_Card() throws Exception {
        before("TC029 - Upload a Random Image in the Aadhaar Card Document Upload Section");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("7087087087");
        onboardingPage.enterOldEmailId("testduplicateemail@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("6");
        onboardingPage.enterPin("1918");
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.setSendMoneyButton();
        kycPage.clickContinueButton();
        kycPage.uploadPhoto();
        kycPage.uploadPanCard();
        kycPage.submitButton();
        kycPage.confirmPanDetails();
        kycPage.setYesItsMeButton();
        kycPage.documentVerificationSuccess();
        kycPage.clickContinueButton();
        kycPage.uploadRandomImage();
    }
}

