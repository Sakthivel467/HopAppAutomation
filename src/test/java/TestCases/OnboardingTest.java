package TestCases;

import DriverSetup.BaseTest;
import Utils.ExcelSetup;
import Utils.TakeSnap;
import extentReport.Constants;
import groovyjarjarantlr4.v4.parse.ToolANTLRLexer;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

public class OnboardingTest extends BaseTest {

    ExcelSetup ex = new ExcelSetup();

    @Test(priority = 1)
    public void TC001_SignUp_To_Hop_App() throws Exception {
        before("TC001- New_User_Signup_to_Hop_App");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.enterRandomPhoneNo();
        onboardingPage.enterEmailId("testkyc");
        onboardingPage.continueButton();
        onboardingPage.verifyAccountLabel();
        onboardingPage.enterInvalidOtp("999999");
        onboardingPage.enterOtp("123456");
        onboardingPage.validatePinLabel();
        onboardingPage.enterPin("1234");
        onboardingPage.validateConfirmPinLabel();
        onboardingPage.enterConfirmPin("1234");
        onboardingPage.validateUserIoOnSendMoneyScreen();
        onboardingPage.validateUserIoOnOneDaySettlement();
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("overseas education - university fees");
        sendMoneyPage.confirmButton();
        sendMoneyPage.setOnetimeVerificationButton();
        TakeSnap.captureScreenshot();
    }

    @Test(priority = 2)
    public void TC002_Old_User_Login_To_Hop_App() throws Exception {
        before("TC002- Old User Login to Hop App");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("7773335550");
        onboardingPage.enterIncorrectEmailId("sakthivel+550@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.validateEnterPinLabel();
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("family maintenance");
        sendMoneyPage.confirmButton();
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.recipient();
        sendMoneyPage.warningContinue();
        sendMoneyPage.selectSourceOfFunds();
        sendMoneyPage.clickSourceOfFunds("student loan");
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.completePayment();
        sendMoneyPage.selectPaymentMethod("netBanking");
        sendMoneyPage.addNewBank();


    }

    @Test(priority = 3)
    public void TC003_User_Login_Mobile_No_Already_Registered() throws Exception {
        before("TC003- Verify the user is not able to signup/signin with different Email Id if Mobile no. is already registered");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("7087087087");
        onboardingPage.enterIncorrectEmailId("testduplicateemail@moneyhop.com");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.setMobileNoAlreadyRegisteredError();
        TakeSnap.captureScreenshot();
    }

    @Test(priority = 4)
    public void TC004_User_Login_Email_Id_Already_Registered() throws Exception {
        before("TC004- Verify the user is not able to signup/signin with different Mobile no. if Email Id is already registered");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        TakeSnap.captureScreenshot();
        onboardingPage.getStarted();
        onboardingPage.incorrectEnterPhoneNo("7087087080");
        onboardingPage.enterOldEmailId("testduplicateemail@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.setEmailIdAlreadyRegistered();
        TakeSnap.captureScreenshot();
    }

    @Test(priority = 5)
    public void TC005_Reset_App_Pin() throws Exception {
        before("TC005_Reset_App_Pin");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("7087087087");
        onboardingPage.enterOldEmailId("testduplicateemail@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.setHavingTroubleLabel();
        onboardingPage.clickResetPin();
        onboardingPage.enterOtp("123456");
        onboardingPage.validateRestPinLabel();
        onboardingPage.enterPin("1234");
        onboardingPage.enterConfirmPin("1234");
        onboardingPage.validateEnterPinLabel();
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.validateUserIoOnSendMoneyScreen();
        TakeSnap.captureScreenshot();
    }
    @Test(priority = 6)
    public void TC006_Reset_App_Pin_Failure() throws Exception {
        before("TC006_Reset_App_Pin_Failure");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("7087087087");
        onboardingPage.enterOldEmailId("testduplicateemail@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.setHavingTroubleLabel();
        onboardingPage.clickResetPin();
        onboardingPage.enterOtp("123456");
        onboardingPage.enterPin("1234");
        onboardingPage.enterConfirmPin("1235");
        TakeSnap.captureScreenshot();

    }
    @Test(priority = 7)
    public void TC007_Incorrect_Pin_Old_User() throws Exception {
        before("TC007_Incorrect_Pin_Old_User");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("7087087087");
        onboardingPage.enterOldEmailId("testduplicateemail@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.validateEnterPinLabel();
        onboardingPage.oldUserEnterPin("1232");
        onboardingPage.verifyIncorrectPin();
        TakeSnap.captureScreenshot();
    }

    @Test(priority = 8)
    public void TC008_OTP_Validation_Hop_App() throws Exception {
        before("TC008_OTP_Validation_Hop_App");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.enterRandomPhoneNo();
        onboardingPage.enterMobileNum();
        onboardingPage.enterEmailId("testkyc");
        onboardingPage.continueButton();
        onboardingPage.verifyAccountLabel();
        onboardingPage.enterInvalidOtp("999999");
        onboardingPage.enterOtp("123456");
        TakeSnap.captureScreenshot();
    }

    @Test(priority = 9)
    public void TC009_Signup_TnC_Validation_Hop_App() throws Exception {
        before("TC009_Signup_TnC_Validation_Hop_App");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.termsAndConditions();
        onboardingPage.getStarted();
        onboardingPage.enterMobileNum();
        onboardingPage.enterPhoneNo("2773335550");
        onboardingPage.enterIncorrectEmailId("sakthivemoneyhop.co");
        onboardingPage.continueButton();
        TakeSnap.captureScreenshot();

    }
    @Test(priority = 10)
    public void TC010_Incorrect_Pin_New_User() throws Exception {
        before("TC007_Incorrect_Pin_new_User");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        onboardingPage.getStarted();
        onboardingPage.enterRandomPhoneNo();
        onboardingPage.enterEmailId("testkyc");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.enterPin("1234");
        onboardingPage.enterConfirmPin("1235");
        TakeSnap.captureScreenshot();
    }
}