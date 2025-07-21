package TestCases;

import DriverSetup.BaseTest;
import Utils.TakeSnap;
import extentReport.Constants;
import org.testng.annotations.Test;
import Utils.ExcelSetup;

public class SendMoneyTest extends BaseTest {
    ExcelSetup ex = new ExcelSetup();

    @Test(priority = 14)
    public void TC014_Validate_Min_Max_INR_Amount() throws Exception {
        before("TC0014- Validate the Minimum and Maximum INR Amount for the International Remittance");
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
        sendMoneyPage.inrCurrencyTextBox("4999");
        sendMoneyPage.minAmountValidation();
        sendMoneyPage.inrCurrencyTextBox("3000000");
        sendMoneyPage.maxAmountValidation();
    }
    @Test(priority = 15)
    public void TC0015_Validate_Min_Max_FCY_Amount() throws Exception {
        before("TC0015- Validate the Minimum and Maximum FCY Amount for the International Remittance");
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
        sendMoneyPage.fcyCurrencyTextBox("49");
        sendMoneyPage.minAmountValidation();
        sendMoneyPage.fcyCurrencyTextBox("23000");
        sendMoneyPage.maxAmountValidation();

    }


    @Test(priority = 16)
    public void TC0016_Validate_Default_Currency_Symbols() throws Exception {
        before("TC0016 - Verify Default Display of Indian and USD Currency with Symbols");
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
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.defaultCurrencies();
    }

    @Test(priority = 17)
    public void TC017_Validate_Foreign_Currency() throws Exception {
        before("TC017 - Verify Selection of All Foreign Currencies with Correct Codes, Symbols, and Flags");
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
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("cad");
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("eur");
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("nzd");
        sendMoneyPage.inrCurrencyTextBox("1500000");
        sendMoneyPage.expandTaxAndTransferFee();
        sendMoneyPage.validateTotalFeesDynamically();
        TakeSnap.captureScreenshot();

    }

    @Test(priority = 18)
    public void TC018_Validate_The_Bank_And_Convenience_Fees_ForAD2() throws Exception {
        before("TC018 - Validate The Bank And Convenience Fees ForAD2 for All Amount Ranges");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("7872434499");
        onboardingPage.enterOldEmailId("testing@gmail.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("overseas education - university fees");
        sendMoneyPage.confirmButton();
        sendMoneyPage.inrCurrencyTextBox("1500000");
        sendMoneyPage.expandTaxAndTransferFee();
        sendMoneyPage.validateAd2BankAndConvenienceFee();
       sendMoneyPage.validateTotalFeesDynamically();
    }
    @Test(priority = 19)
    public void TC019_Validate_The_Bank_And_Convenience_Fees_ForAD1() throws Exception {
        before("TC019 - Validate The Bank And Convenience Fees ForAD1 for All Amount Ranges");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("7872434499");
        onboardingPage.enterOldEmailId("testing@gmail.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("family maintenance");
        sendMoneyPage.confirmButton();
        sendMoneyPage.inrCurrencyTextBox("1000000");
        sendMoneyPage.expandTaxAndTransferFee();
        sendMoneyPage.validateAd1BankAndConvenienceFee();
        sendMoneyPage.validateTotalFeesDynamically();
    }

    @Test(priority = 18)
    public void TC018_Validate_The_Total_Fees_With_TCS_ForAD2() throws Exception {
        before("TC018 - Validate The Bank And Convenience Fees ForAD2 for All Amount Ranges");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("7872434499");
        onboardingPage.enterOldEmailId("testing@gmail.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("overseas education - university fees");
        sendMoneyPage.toggleSwitch();
        sendMoneyPage.confirmButton();
        sendMoneyPage.inrCurrencyTextBox("1100000");
        sendMoneyPage.expandTaxAndTransferFee();
        sendMoneyPage.validateAd2BankAndConvenienceFee();
        sendMoneyPage.validateTotalFeesDynamically();
    }

    @Test(priority = 20)
    public void TC020_Validate_GST_Amount() throws Exception {
        before("TC020 - Validate GST Amount for All Amount Ranges");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("7773335550");
        onboardingPage.enterIncorrectEmailId("sakthivel+550@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.inrCurrencyTextBox("80000");
        sendMoneyPage.expandTaxAndTransferFee();
        sendMoneyPage.validateGST();

    }

    @Test(priority = 21)
    public void TC021_Validate_The_Bank_And_Convenience_Fees_And_Total_Feel_ForAD1_WithoutTCS() throws Exception {
        before("TC021 - Validate The Bank And Convenience Fees And Total Feel ForAD1 WithoutKYC for All Amount Ranges");
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
        sendMoneyPage.inrCurrencyTextBox("1000000");
        sendMoneyPage.expandTaxAndTransferFee();
        sendMoneyPage.validateAd1BankAndConvenienceFee();
        sendMoneyPage.validateTotalFeesDynamically();

    }


    @Test(priority = 22)
    public void TC022_Validate_TCS_Amount() throws Exception {
        before("TC022 - Validate TCS Amount for All Amount Ranges");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("7087087087");
        onboardingPage.enterOldEmailId("testduplicateemail@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.enterPin("1918");
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.expandTaxAndTransferFee();
        sendMoneyPage.inrCurrencyTextBox("700000");
        sendMoneyPage.validateTheTCSInCalculationsSectionBeforeSelectingThePurposeCode();
        sendMoneyPage.inrCurrencyTextBox("1100000");
        sendMoneyPage.validateTheTCSInCalculationsSectionBeforeSelectingThePurposeCode();
    }

    @Test(priority = 23)
    public void TC023_TaxAndTransferFee_And_TotalAmount() throws Exception {
        before("TC023 - Validate Tax & Transfer Fee and Total Amount Calculations");
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
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("cad");
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("family maintenance");
        sendMoneyPage.confirmButton();
        sendMoneyPage.inrCurrencyTextBox("1500000");
        sendMoneyPage.expandTaxAndTransferFee();
        sendMoneyPage.validateTotalFeesDynamically();
        TakeSnap.captureScreenshot();

    }

    @Test(priority = 24)
    public void TC023_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_Education_University_Fees_without_TCS_Apply_CouponCode() throws Exception {
        before("TC024 Create a End to End International Remittance Transaction with the Purpose of Education University Fees without TCS Apply Coupon Code");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("7773335550");
        onboardingPage.enterIncorrectEmailId("sakthivel+550@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("cad");
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("overseas education - university fees");
        sendMoneyPage.toggleSwitch();
        sendMoneyPage.confirmButton();
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.clickFirstAvailableRecipient();
        sendMoneyPage.warningContinue();
        sendMoneyPage.applyCouponCode("ASHISH500");
        sendMoneyPage.selectSourceOfFunds("salary or wages");
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.transactionScreen();
        TakeSnap.captureScreenshot();

    }
    @Test(priority = 25)
    public void TC025_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_Overseas_Education_Living_Expenses_without_TCS_Apply_CouponCoin() throws Exception {
        before("TC025 Create a End to End International Remittance Transaction with the Purpose of Overseas Education Living Expenses without TCS Apply Coupon Coin");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("7773335550");
        onboardingPage.enterIncorrectEmailId("sakthivel+550@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("chf");
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("overseas education - living expenses");
        sendMoneyPage.toggleSwitch();
        sendMoneyPage.confirmButton();
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.clickFirstAvailableRecipient();
        sendMoneyPage.warningContinue();
        sendMoneyPage.redeemHopCoins("200");
        sendMoneyPage.selectSourceOfFunds("investments");
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.transactionScreen();
        TakeSnap.captureScreenshot();

    }


    @Test(priority = 26)
    public void TC026_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_Education_University_Fees_with_TCS() throws Exception {
        before("TC026 - Create a End to End International Remittance Transaction with the Purpose of \"Education - University Fees\" for Old user");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("8886663330");
        onboardingPage.enterIncorrectEmailId("sakthivel+330@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.validateEnterPinLabel();
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("Euro");
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("overseas education - university fees");
        sendMoneyPage.confirmButton();
        sendMoneyPage.inrCurrencyTextBox("10000");
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.clickFirstAvailableRecipient();
        sendMoneyPage.warningContinue();
        sendMoneyPage.selectSourceOfFunds("personal savings");
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.completePayment();
        sendMoneyPage.selectPaymentMethod("upi");
        sendMoneyPage.enterAccountDetailsAndClickVerify("sakthivel145@okaxis", "1234567890", "HDFC0001234");
        TakeSnap.captureScreenshot();

    }

    @Test(priority =27)
    public void TC027_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_living_expenses_Fees_with_TCS() throws Exception {
        before("TC027 - Create a End to End International Remittance Transaction with the Purpose of \"living_expenses_Fees\" for Old User");
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
        sendMoneyPage.selectCurrencyByName("gbp");
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("overseas education - living expenses");
        sendMoneyPage.confirmButton();
        sendMoneyPage.inrCurrencyTextBox("500000");
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.clickFirstAvailableRecipient();
        sendMoneyPage.warningContinue();
        sendMoneyPage.selectSourceOfFunds("investments");
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.completePayment();
        sendMoneyPage.selectPaymentMethod("netBanking");
        sendMoneyPage.addNewBank();
        TakeSnap.captureScreenshot();

    }
    @Test(priority = 28)
    public void TC028_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_Family_Maintenance() throws Exception {
        before("TC028 - Create a End to End International Remittance Transaction with the Purpose of \"Family_Maintenance\" for Old user");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("8886663330");
        onboardingPage.enterIncorrectEmailId("sakthivel+330@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.validateEnterPinLabel();
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("aud");
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("family maintenance");
        sendMoneyPage.confirmButton();
        sendMoneyPage.inrCurrencyTextBox("180000");
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.clickFirstAvailableRecipient();
        sendMoneyPage.warningContinue();
        sendMoneyPage.selectSourceOfFunds("personal savings");
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.completePayment();
        sendMoneyPage.selectPaymentMethod("neft");
        sendMoneyPage.validateBankDetailsAndClickContinue();
        sendMoneyPage.transactionScreen();
        TakeSnap.captureScreenshot();

    }
    @Test(priority = 29)
    public void TC029_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_personal_gift_or_donation() throws Exception {
        before("TC029 - Create a End to End International Remittance Transaction with the Purpose of \"personal_gift_or_donation\" for Old user");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("7773335550");
        onboardingPage.enterIncorrectEmailId("sakthivel+550@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("nzd");
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("personal gift or donation");
        sendMoneyPage.confirmButton();
        sendMoneyPage.inrCurrencyTextBox("850000");
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.clickFirstAvailableRecipient();
        sendMoneyPage.warningContinue();
        sendMoneyPage.selectSourceOfFunds("personal savings");
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.completePayment();
        sendMoneyPage.selectPaymentMethod("neft");
        sendMoneyPage.validateBankDetailsAndClickContinue();
        sendMoneyPage.transactionScreen();
        onboardingPage.clickBackButton();
        TakeSnap.captureScreenshot();

    }

    @Test(priority = 30)
    public void TC030_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_personal_gift_or_donation_Prime_User() throws Exception {
        before("TC030 - Create a End to End International Remittance Transaction with the Purpose of \"personal_gift_or_donation\" for Old user");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("6667778880");
        onboardingPage.enterIncorrectEmailId("sakthivel+880@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("nzd");
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("personal gift or donation");
        sendMoneyPage.confirmButton();
        sendMoneyPage.inrCurrencyTextBox("850000");
        sendMoneyPage.expandTaxAndTransferFee();
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.clickFirstAvailableRecipient();
        sendMoneyPage.warningContinue();
        sendMoneyPage.selectSourceOfFunds("personal savings");
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.completePayment();
        sendMoneyPage.selectPaymentMethod("neft");
        sendMoneyPage.validateBankDetailsAndClickContinue();
        sendMoneyPage.transactionScreen();
        TakeSnap.captureScreenshot();

    }
    @Test(priority = 31)
    public void TC031_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_Overseas_Education_Living_Expenses_Recipient_flow () throws Exception {
        before("TC031 - Create a End to End International Remittance Transaction with the Purpose of \"overseas education - living expenses\" for Old user");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("6667778880");
        onboardingPage.enterIncorrectEmailId("sakthivel+880@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.clickRecipientSvgIcon();
        sendMoneyPage.clickFirstAvailableRecipient();
        sendMoneyPage.recipientSendMoneyButton();
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("overseas education - living expenses");
        sendMoneyPage.confirmButton();
        sendMoneyPage.inrCurrencyTextBox("1550000");
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.selectSourceOfFunds("personal savings");
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.completePayment();
        sendMoneyPage.selectPaymentMethod("neft");
        sendMoneyPage.validateBankDetailsAndClickContinue();
        sendMoneyPage.transactionScreen();
        onboardingPage.clickBackButton();
        TakeSnap.captureScreenshot();

    }
}

