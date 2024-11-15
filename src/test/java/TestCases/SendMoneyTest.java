package TestCases;

import DriverSetup.BaseTest;
import extentReport.Constants;
import org.testng.annotations.Test;
import Utils.ExcelSetup;

public class SendMoneyTest extends BaseTest {
    ExcelSetup ex = new ExcelSetup();

    @Test(priority = 8)
    public void TC008_Min_Max_INR_Amount() throws Exception {
        before("TC008- Validate the Minimum and Maximum INR Amount for the International Remittance");
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
        sendMoneyPage.validatePresetAmount();
        sendMoneyPage.inrCurrencyTextBox("4999");
        sendMoneyPage.minAmountValidation();
        sendMoneyPage.inrCurrencyTextBox("3000000");
        sendMoneyPage.maxAmountValidation();
    }

    @Test(priority = 9)
    public void TC009_Default_Currency_Symbols() throws Exception {
        before("TC009 - Verify Default Display of Indian and USD Currency with Symbols");
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
        sendMoneyPage.defaultCurrencies();
    }

    @Test(priority = 10)
    public void TC010_Foreign_Currency_Symbols() throws Exception {
        before("TC010 - Verify Selection of All Foreign Currencies with Correct Codes, Symbols, and Flags");
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
        sendMoneyPage.foreignCurrencies();
    }

    @Test(priority = 11)
    public void TC011_Transfer_Fees() throws Exception {
        before("TC011 - Validate Transfer Fee for All Amount Ranges");
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
        sendMoneyPage.expandTaxAndTransferFee();
        sendMoneyPage.inrCurrencyTextBox("79999");
        sendMoneyPage.validateTransferFee();
        sendMoneyPage.inrCurrencyTextBox("80000");
        sendMoneyPage.validateTransferFee();
        sendMoneyPage.inrCurrencyTextBox("199999");
        sendMoneyPage.validateTransferFee();
        sendMoneyPage.inrCurrencyTextBox("200000");
        sendMoneyPage.validateTransferFee();
        sendMoneyPage.inrCurrencyTextBox("399999");
        sendMoneyPage.validateTransferFee();
        sendMoneyPage.inrCurrencyTextBox("400000");
        sendMoneyPage.validateTransferFee();
    }

    @Test(priority = 12)
    public void TC012_GST_Amount() throws Exception {
        before("TC012 - Validate GST Amount for All Amount Ranges");
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
        sendMoneyPage.expandTaxAndTransferFee();
        sendMoneyPage.inrCurrencyTextBox("25000");
        sendMoneyPage.validateGST();
        sendMoneyPage.inrCurrencyTextBox("80000");
        sendMoneyPage.validateGST();
        sendMoneyPage.inrCurrencyTextBox("100000");
        sendMoneyPage.validateGST();
        sendMoneyPage.inrCurrencyTextBox("200000");
        sendMoneyPage.validateGST();
        sendMoneyPage.inrCurrencyTextBox("400000");
        sendMoneyPage.validateGST();
        sendMoneyPage.inrCurrencyTextBox("600000");
        sendMoneyPage.validateGST();
        sendMoneyPage.inrCurrencyTextBox("1000000");
        sendMoneyPage.validateGST();
        sendMoneyPage.inrCurrencyTextBox("1500000");
        sendMoneyPage.validateGST();
    }

    @Test(priority = 13)
    public void TC013_TCS_Amount() throws Exception {
        before("TC013 - Validate TCS Amount for All Amount Ranges");
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
        sendMoneyPage.expandTaxAndTransferFee();
        sendMoneyPage.inrCurrencyTextBox("700000");
        sendMoneyPage.validateTheTCSInCalculationsSectionBeforeSelectingThePurposeCode();
        sendMoneyPage.inrCurrencyTextBox("1100000");
        sendMoneyPage.validateTheTCSInCalculationsSectionBeforeSelectingThePurposeCode();
    }

    @Test(priority = 14)
    public void TC014_TaxAndTransferFee_And_TotalAmount() throws Exception {
        before("TC014 - Validate Tax & Transfer Fee and Total Amount Calculations");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("7087087087");
        onboardingPage.enterOldEmailId("testduplicateemail@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("6");
        onboardingPage.enterPin("1390");
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.expandTaxAndTransferFee();
    }
}
