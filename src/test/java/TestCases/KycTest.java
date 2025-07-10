package TestCases;

import DriverSetup.BaseTest;
import Utils.TakeSnap;
import extentReport.Constants;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import Utils.ExcelSetup;

public class KycTest  extends BaseTest {

    ExcelSetup ex = new ExcelSetup();


    @Test(priority = 26)
    public void TC026_Validate_Banner_Kyc_Homepage_New_User() throws Exception {
        before("TC026 - Verify the Labels and Banners on the Verify Your Documents Page");
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
        sendMoneyPage.selectPurposeOfTransfer("overseas education - university fees");
        sendMoneyPage.confirmButton();
        sendMoneyPage.setOnetimeVerificationButton();
        onboardingPage.validateUserIsOnKYCDocsScreen();

    }

    @Test(priority = 27)
    public void TC027_Validate_New_User_able_to_Upload_Pan_Card() throws Exception {
        before("TC027 Validate New User able to Upload Pan Card");
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
        onboardingPage.skipGuide();
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

    @Test(priority = 28)
    public void TC028_Validate_Upload_Random_Image_In_Pan_Card() throws Exception {
        before("TC028 - Upload a Random Image in the PAN Card Document Upload Section");
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
        sendMoneyPage.selectPurposeOfTransfer("overseas education - living expenses");
        sendMoneyPage.confirmButton();
        sendMoneyPage.setOnetimeVerificationButton();
        onboardingPage.validateUserIsOnKYCDocsScreen();
        kycPage.uploadPhoto();
        kycPage.uploadRandomImage();
    }
//
//    @Test(priority = 29)
//    public void TC029_Edit_Pan_Card_Details() throws Exception {
//        before("TC024 - Verify Edit PAN Card Option by Entering Incorrect and Correct PAN No.");
//        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
//            onboardingPage.dismissButton();
//        }
//        onboardingPage.getStarted();
//        onboardingPage.enterRandomPhoneNo();
//        onboardingPage.enterEmailId("testkyc");
//        onboardingPage.continueButton();
//        onboardingPage.enterOtp("123456");
//        onboardingPage.enterPin("1234");
//        onboardingPage.validateUserIoOnSendMoneyScreen();
//        sendMoneyPage.selectPurposeCode();
//        sendMoneyPage.selectPurposeOfTransfer("personal gift or donation");
//        sendMoneyPage.confirmButton();
//        sendMoneyPage.setOnetimeVerificationButton();
//        onboardingPage.validateUserIsOnKYCDocsScreen();
//        kycPage.uploadPhoto();
//        kycPage.uploadPanCard();
//        kycPage.editPanDetails();
//        kycPage.documentVerificationSuccess();
//    }

    @Test(priority = 30)
    public void TC030_Validate_Labels_Secondary_Documents_KYC_page() throws Exception {
        before("TC026 - Verify the Labels and All Secondary Document Options");
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
        sendMoneyPage.selectPurposeOfTransfer("overseas education - living expenses");
        sendMoneyPage.confirmButton();
        sendMoneyPage.setOnetimeVerificationButton();
        onboardingPage.validateUserIsOnKYCDocsScreen();
        kycPage.uploadPhoto();
        kycPage.uploadPanCard();
        kycPage.validateSecondaryDocKYCTexts();
    }

    @Test(priority = 31)
    public void TC031_Verify_New_User_Able_To_Upload_AadharCard_Page() throws Exception {
        before("TC027 - Verify the Labels and Banners on the Upload Aadhaar Card Page");
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
        sendMoneyPage.selectPurposeOfTransfer("overseas education - university fees");
        sendMoneyPage.confirmButton();
        sendMoneyPage.setOnetimeVerificationButton();
        onboardingPage.validateUserIsOnKYCDocsScreen();
        kycPage.uploadPhoto();
        kycPage.uploadPanCard();
        kycPage.FrontImageUploadClick();
        kycPage.uploadFrontAadhaar();
        kycPage.BackImageUploadClick();
        kycPage.uploadBackAadhaar();
        kycPage.signUpClick();
        kycPage.drawSignature();
        kycPage.signaturePadConfirm();
        sendMoneyPage.selectRecipientType("institution");
        TakeSnap.captureScreenshot();
    }

    @Test(priority = 32)
    public void TC032_Upload_PassPort_Front_And_Back() throws Exception {
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
        kycPage.uploadPanCard();
        kycPage.clickSecDos();
        kycPage.selectKycDocumentType("passport");
        kycPage.FrontImageUploadClick();
        kycPage.uploadFrontPassPort();
        kycPage.BackImageUploadClick();
        kycPage.uploadBackPassPort();
        kycPage.signUpClick();
        kycPage.drawSignature();
        kycPage.signaturePadConfirm();
        sendMoneyPage.selectRecipientType("institution");

    }


    @Test(priority = 33)
    public void TC033_Upload_Random_Image_In_PassPort_FE() throws Exception {
        before("TC029 - Upload a Random Image in the Aadhaar Card Document Upload Section");
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
        kycPage.uploadPanCard();
        kycPage.clickSecDos();
        kycPage.selectKycDocumentType("passport");
        kycPage.FrontImageUploadClick();
        kycPage.cancelButton();
        kycPage.passPortUploadRandomImage();

    }
    @Test(priority = 32)
    public void TC032_Verify_New_User_Able_To_Upload_DrivingLicense_Page() throws Exception {
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
        sendMoneyPage.selectPurposeOfTransfer("overseas education - university fees");
        sendMoneyPage.confirmButton();
        sendMoneyPage.setOnetimeVerificationButton();
        onboardingPage.validateUserIsOnKYCDocsScreen();
        kycPage.uploadPhoto();
        kycPage.uploadPanCard();
        kycPage.clickSecDos();
        kycPage.selectKycDocumentType("driving license");
        kycPage.FrontImageUploadClick();
        kycPage.uploadFrontLicenseId();
        kycPage.BackImageUploadClick();
        kycPage.uploadBackLicenseId();
        kycPage.signUpClick();
        kycPage.drawSignature();
        kycPage.signaturePadConfirm();
        sendMoneyPage.selectRecipientType("institution");

    }

}

