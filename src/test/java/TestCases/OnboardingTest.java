package TestCases;

import DriverSetup.BaseTest;
import Utils.ExcelSetup;
import Utils.TakeSnap;
import extentReport.Constants;
import org.testng.annotations.Test;

public class OnboardingTest extends BaseTest {

ExcelSetup ex=new ExcelSetup();

    @Test(priority = 1)
    public void TC001_SignUp_To_Hop_App() throws Exception {
        before("TC001- New User Signup to Hop App");
        /*if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }*/
        onboardingPage.moneyHopMoto();
        onboardingPage.sendMoneyImage();
        onboardingPage.getStarted();
        onboardingPage.backButtonLoginPage();
        onboardingPage.validateLabelPhoneNoAndEmail();
        onboardingPage.validatePhoneNoCountryCode();
        onboardingPage.validatePhoneNoValidations();
        onboardingPage.validateEmailValidations();
        onboardingPage.continueButton();
        onboardingPage.verifyAccountLabel();
        onboardingPage.enterInvalidOtp();
        onboardingPage.enterOtp("6");
        onboardingPage.validatePinLabel();
        onboardingPage.enterPin("1390");
        onboardingPage.validateConfirmPinLabel();
        onboardingPage.enterConfirmPin();
        onboardingPage.validateUserIoOnSendMoneyScreen();
    }

    @Test(priority = 2)
    public void TC002_Old_User_Login_To_Hop_App() throws Exception {
        before("TC002- Old User Login to Hop App");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        //TakeSnap.captureScreenshot();
        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("9999999999");
        onboardingPage.enterOldEmailId(ex.getTestData("Email"));
        onboardingPage.continueButton();
        onboardingPage.enterOtp("6");
        onboardingPage.validateEnterPinLabelForOldUser();
        onboardingPage.enterPin("1390");
        onboardingPage.validateUserIoOnSendMoneyScreen();
    }

    @Test(priority = 3)
    public void TC003_User_Login_Mobile_No_Already_Registered() throws Exception {
        before("TC003- Verify the user is not able to signup/signin with different Email Id if Mobile no. is already registered");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        TakeSnap.captureScreenshot();
        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("7087087087");
        onboardingPage.enterIncorrectEmailId("testduplicateemail@moneyhop.com");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("6");
        onboardingPage.setMobileNoAlreadyRegisteredError();
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
        onboardingPage.enterOtp("6");
        onboardingPage.setEmailIdAlreadyRegistered();
    }

/*    @Test(priority = 5)
    public void TC005_Reset_App_Pin() throws Exception {
        before("TC005- Reset the App pin from Signin Page");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        TakeSnap.captureScreenshot();
        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("7087087087");
        onboardingPage.enterOldEmailId("testduplicateemail@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("6");
        onboardingPage.setHavingTroubleLabel();
        onboardingPage.clickResetPin();
        onboardingPage.verifyAccountLabel();
        onboardingPage.enterOtp("7");
        onboardingPage.resetAppPinLabel();
        onboardingPage.enterPin("1919");
        onboardingPage.verifyFailedToChangeAppPin();
        onboardingPage.setBackButton();
        onboardingPage.clickResetPin();
        onboardingPage.enterOtp("6");
        onboardingPage.enterPin("1918");
        //onboardingPage.verifySuccessToChangeAppPin();
        onboardingPage.enterPin("1918");
        onboardingPage.validateUserIoOnSendMoneyScreen();
    }*/

    @Test(priority = 6)
    public void TC006_Incorrect_Pin_Old_User() throws Exception {
        before("TC006- Validate that the user is unable to signin if incorrect Pin is entered");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        TakeSnap.captureScreenshot();
        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("7087087087");
        onboardingPage.enterOldEmailId("testduplicateemail@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("6");
        onboardingPage.enterPin("1917");
        onboardingPage.verifyIncorrectPin();
        TakeSnap.captureScreenshot();
    }

 /*   @Test(priority = 7)
    public void TC007_Terms_And_Condition() throws Exception {
        before("TC006- Validate that the user is unable to signin if incorrect Pin is entered");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        TakeSnap.captureScreenshot();

    }*/
}