package TestCases;

import DriverSetup.BaseTest;
import Utils.TakeSnap;
import extentReport.Constants;
import org.testng.annotations.Test;
import Utils.ExcelSetup;

public class SendMoneyTest extends BaseTest {
    ExcelSetup ex = new ExcelSetup();

    @Test(priority = 9)
    public void TC009_Min_Max_INR_Amount() throws Exception {
        before("TC008- Validate the Minimum and Maximum INR Amount for the International Remittance");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("6667778880");
        onboardingPage.enterOldEmailId("sakthivel+880@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.inrCurrencyTextBox("4999");
        sendMoneyPage.minAmountValidation();
        sendMoneyPage.inrCurrencyTextBox("3000000");
        sendMoneyPage.maxAmountValidation();
    }
    @Test(priority = 10)
    public void TC0010_Min_Max_FCY_Amount() throws Exception {
        before("TC008- Validate the Minimum and Maximum FCY Amount for the International Remittance");
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
        sendMoneyPage.fcyCurrencyTextBox("49");
        sendMoneyPage.minAmountValidation();
        sendMoneyPage.fcyCurrencyTextBox("23000");
        sendMoneyPage.maxAmountValidation();

    }


    @Test(priority = 10)
    public void TC0010_Default_Currency_Symbols() throws Exception {
        before("TC009 - Verify Default Display of Indian and USD Currency with Symbols");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.enterRandomPhoneNo();
        onboardingPage.enterEmailId("testkyc");
        onboardingPage.continueButton();
        onboardingPage.verifyAccountLabel();
        onboardingPage.enterOtp("123456");
        onboardingPage.validatePinLabel();
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.validateConfirmPinLabel();
        onboardingPage.enterConfirmPin("1234");
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.defaultCurrencies();
    }

    @Test(priority = 11)
    public void TC011_Foreign_Currency_Validation() throws Exception {
        before("TC010 - Verify Selection of All Foreign Currencies with Correct Codes, Symbols, and Flags");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.enterRandomPhoneNo();
        onboardingPage.enterEmailId("testkyc");
        onboardingPage.continueButton();
        onboardingPage.verifyAccountLabel();
        onboardingPage.enterOtp("123456");
        onboardingPage.validatePinLabel();
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.validateConfirmPinLabel();
        onboardingPage.enterConfirmPin("1234");
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.clickselectCurrency();
        sendMoneyPage.selectCurrencyByName("cad");
        sendMoneyPage.clickselectCurrency();
        sendMoneyPage.selectCurrencyByName("eur");
        sendMoneyPage.clickselectCurrency();
        sendMoneyPage.selectCurrencyByName("nzd");
        sendMoneyPage.inrCurrencyTextBox("1500000");
        sendMoneyPage.expandTaxAndTransferFee();
        sendMoneyPage.validateTotalFeesDynamically();
        TakeSnap.captureScreenshot();

    }

    @Test(priority = 12)
    public void TC012_Transfer_Fees() throws Exception {
        before("TC011 - Validate Transfer Fee for All Amount Ranges");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("7872434499");
        onboardingPage.enterOldEmailId("testing@gmail.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.inrCurrencyTextBox("50000");
        sendMoneyPage.expandTaxAndTransferFee();
        sendMoneyPage.validateTotalFeesDynamically();
    }

    @Test(priority = 12)
    public void TC012_GST_Amount() throws Exception {
        before("TC012 - Validate GST Amount for All Amount Ranges");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("7773335550");
        onboardingPage.enterIncorrectEmailId("sakthivel+550@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.inrCurrencyTextBox("80000");
        sendMoneyPage.expandTaxAndTransferFee();
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
        onboardingPage.enterOtp("123456");
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
        onboardingPage.enterRandomPhoneNo();
        onboardingPage.enterEmailId("testkyc");
        onboardingPage.continueButton();
        onboardingPage.verifyAccountLabel();
        onboardingPage.enterOtp("123456");
        onboardingPage.validatePinLabel();
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.validateConfirmPinLabel();
        onboardingPage.enterConfirmPin("1234");
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.clickselectCurrency();
        sendMoneyPage.selectCurrencyByName("cad");
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("personal gift or donation");
        sendMoneyPage.confirmButton();
        sendMoneyPage.inrCurrencyTextBox("1500000");
        sendMoneyPage.expandTaxAndTransferFee();
        sendMoneyPage.validateTotalFeesDynamically();
        TakeSnap.captureScreenshot();

    }

    @Test(priority = 2)
    public void TC070_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_Education_University_Fees_with_TCS() throws Exception {
        before("TC070 - Create a End to End International Remittance Transaction with the Purpose of \"Education - University Fees\" for new user");
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
        sendMoneyPage.clickselectCurrency();
        sendMoneyPage.selectCurrencyByName("Euro");
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("overseas education - university fees");
        sendMoneyPage.confirmButton();
        sendMoneyPage.inrCurrencyTextBox("10000");
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.recipient();
        sendMoneyPage.warningContinue();
        sendMoneyPage.selectSourceOfFunds();
        sendMoneyPage.clickSourceOfFunds("salary or wages");
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.completePayment();
        sendMoneyPage.selectPaymentMethod("upi");
        sendMoneyPage.enterAccountDetailsAndClickVerify("sakthivel145@okaxis", "1234567890", "HDFC0001234");
        TakeSnap.captureScreenshot();

    }

    @Test(priority =10)
    public void TC070_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_living_expenses_Fees_with_TCS() throws Exception {
        before("TC070 - Create a End to End International Remittance Transaction with the Purpose of \"Education - University Fees\" for new user");
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
        sendMoneyPage.clickselectCurrency();
        sendMoneyPage.selectCurrencyByName("gbp");
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("overseas education - living expenses");
        sendMoneyPage.confirmButton();
        sendMoneyPage.inrCurrencyTextBox("100000");
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.recipient();
        sendMoneyPage.warningContinue();
        sendMoneyPage.selectSourceOfFunds();
        sendMoneyPage.clickSourceOfFunds("investments");
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.completePayment();
        sendMoneyPage.selectPaymentMethod("upi");
        sendMoneyPage.enterAccountDetailsAndClickVerify("sakthivel145@okaxis", "1234567890", "HDFC0001234");
        TakeSnap.captureScreenshot();

    }
    @Test(priority = 2)
    public void TC070_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_Family_Maintenance_with_TCS() throws Exception {
        before("TC070 - Create a End to End International Remittance Transaction with the Purpose of \"Education - University Fees\" for new user");
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
        sendMoneyPage.clickselectCurrency();
        sendMoneyPage.selectCurrencyByName("aud");
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("family maintenance");
        sendMoneyPage.confirmButton();
        sendMoneyPage.inrCurrencyTextBox("80000");
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.recipient();
        sendMoneyPage.warningContinue();
        sendMoneyPage.selectSourceOfFunds();
        sendMoneyPage.clickSourceOfFunds("personal savings");
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.completePayment();
        sendMoneyPage.selectPaymentMethod("neft");
        sendMoneyPage.validateBankDetailsAndClickContinue();
        sendMoneyPage.transactionScreen();
        TakeSnap.captureScreenshot();

    }
    @Test(priority = 2)
    public void TC070_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_personal_gift_or_donation_with_TCS() throws Exception {
        before("TC070 - Create a End to End International Remittance Transaction with the Purpose of \"Education - University Fees\" for new user");
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
        sendMoneyPage.clickselectCurrency();
        sendMoneyPage.selectCurrencyByName("cad");
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("personal gift or donation");
        sendMoneyPage.confirmButton();
        sendMoneyPage.inrCurrencyTextBox("850000");
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.recipient();
        sendMoneyPage.warningContinue();
        sendMoneyPage.selectSourceOfFunds();
        sendMoneyPage.clickSourceOfFunds("personal savings");
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.completePayment();
        sendMoneyPage.selectPaymentMethod("neft");
        sendMoneyPage.validateBankDetailsAndClickContinue();
        sendMoneyPage.transactionScreen();
        TakeSnap.captureScreenshot();

    }
}
