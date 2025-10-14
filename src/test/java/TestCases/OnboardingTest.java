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
    public void TC001_New_User_SignUp_To_Hop_App() throws Exception {
        before("TC001- New User Signup to Hop App");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.validateLabelPhoneNoAndEmail();
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
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        onboardingPage.validatePromoMessage();
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
        onboardingPage.validateLabelPhoneNoAndEmail();
        onboardingPage.enterPhoneNo("7773335550");
        onboardingPage.enterIncorrectEmailId("sakthivel+550@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.validateEnterPinLabel();
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        onboardingPage.validatePromoMessage();
        sendMoneyPage.validateRemittanceSummary();
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("overseas education - university fees");
        sendMoneyPage.confirmButton();
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.clickFirstAvailableRecipient();
        sendMoneyPage.warningContinue();
        sendMoneyPage.selectSourceOfFunds("student loan");
        sendMoneyPage.swipeVertical();
        sendMoneyPage.scrollPage();
        sendMoneyPage.proceedToPayment();
        TakeSnap.captureScreenshot();


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

    @Test(priority = 5,enabled = false)
    public void TC005_Verify_User_Able_to_Reset_App_Pin() throws Exception {
        before("TC005 Verify User Able to Reset App Pin");
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
        onboardingPage.enterPin("1235");
        onboardingPage.enterConfirmPin("1235");
        onboardingPage.validateEnterPinLabel();
        onboardingPage.oldUserEnterPin("1235");
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        onboardingPage.validatePromoMessage();
        TakeSnap.captureScreenshot();
    }
    @Test(priority = 6)
    public void TC006_Reset_App_Pin_Failure() throws Exception {
        before("TC006 Reset App Pin Failure");
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
        before("TC007 Incorrect Pin Old User");
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
        TakeSnap.captureScreenshot();
    }

    @Test(priority = 8)
    public void TC008_OTP_Validation_Hop_App() throws Exception {
        before("TC008 OTP Validation Hop App");
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
        before("TC009 Signup TnC Validation Hop App");
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
        before("TC0010 Incorrect Pin new User");
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
    @Test(priority = 11)
    public void TC0011_Validation_Purpose_Of_Transfer_Text() throws Exception {
        before("TC0011- Validation Purpose Of TransferText");
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
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("overseas education - university fees");
        onboardingPage.validatePaymentTexts();
        sendMoneyPage.selectPurposeOfTransfer("overseas education - living expenses");
        onboardingPage.validateRemittanceInfoTexts();
        sendMoneyPage.selectPurposeOfTransfer("family maintenance");
        onboardingPage.validateTransferInfoTexts();
        sendMoneyPage.selectPurposeOfTransfer("personal gift or donation");
        onboardingPage.validateGiftRemittanceTexts();
        sendMoneyPage.confirmButton();
        TakeSnap.captureScreenshot();

    }
    @Test(priority =12)
    public void TC0012_Validation_Payment_Method_ForAD1() throws Exception {
        before("TC0012 - Validation Payment Method zForAD1");
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
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("chf");
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("overseas education - living expenses");
        sendMoneyPage.confirmButton();
        sendMoneyPage.fcyCurrencyTextBox("604.99");
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.clickFirstAvailableRecipient();
        sendMoneyPage.warningContinue();
        sendMoneyPage.selectSourceOfFunds("retirement funds");
        sendMoneyPage.swipeVertical();
        sendMoneyPage.scrollPage();
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.completePayment();
        onboardingPage.validatePaymentMethodTexts();

    }

    @Test(priority = 40)
    public void TC040_Validate_IBR_Rate_Target_Currency_Selection() throws Exception {
        before("TC0040-Validate IBR Rate Currency for the International Remittance");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("8886663330");
        onboardingPage.enterOldEmailId("sakthivel+330@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.validateIBRChangesOnTargetCurrencySelection("British Pound Sterling", "GBP");
        sendMoneyPage.validateIBRChangesOnTargetCurrencySelection("New Zealand Dollar", "NZD");
        sendMoneyPage.validateIBRChangesOnTargetCurrencySelection("Australian Dollar", "AUD");
        sendMoneyPage.validateIBRChangesOnTargetCurrencySelection("Japanese Yen", "JPY");
        sendMoneyPage.validateIBRChangesOnTargetCurrencySelection("United Arab Emirates Dirham", "AED");
        TakeSnap.captureScreenshot();

    }


    @Test(priority = 40)
    public void TC041_Validate_IBR_Rate_Target_Currency_Selection() throws Exception {
        before("TC0041-Validate IBR Rate Currency for the International Remittance");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("8886663330");
        onboardingPage.enterOldEmailId("sakthivel+330@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.validateIBRChangesOnTargetCurrencySelection("Canadian Dollar", "CAD");
        sendMoneyPage.validateIBRChangesOnTargetCurrencySelection("Euro", "EUR");
        sendMoneyPage.validateIBRChangesOnTargetCurrencySelection("United States Dollar", "USD");
        sendMoneyPage.validateIBRChangesOnTargetCurrencySelection("Swiss Franc", "CHF");
        sendMoneyPage.validateIBRChangesOnTargetCurrencySelection("Singapore Dollar", "SGD");
        TakeSnap.captureScreenshot();

    }
    @Test(priority = 42)
    public void TC0042_Validate_New_User_Default_Amount_And_Fees() throws Exception {
        before("TC001- Validate New User Default Amount And Fees");
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
        sendMoneyPage.validateRemittanceSummary();
        sendMoneyPage.validateRemittanceActual();
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("overseas education - university fees");
        sendMoneyPage.confirmButton();
        sendMoneyPage.inrCurrencyTextBox("794560.88");
        sendMoneyPage.validateRemittanceActual();
        TakeSnap.captureScreenshot();

    }

    @Test(priority =13,enabled = false)
    public void TC0013_Validation_Logout_Flow() throws Exception {
        before("TC013 - Validation Logout Flow");
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
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        onboardingPage.clickSettingButton();
        onboardingPage.clickLogout();
        onboardingPage.selectLogoutConfirmation("no");
        onboardingPage.clickLogout();
        onboardingPage.selectLogoutConfirmation("yes");
        TakeSnap.captureScreenshot();


    }
}