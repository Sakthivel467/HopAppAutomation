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
        sendMoneyPage.validateRemittanceSummary();
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("cad");
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("family maintenance");
        sendMoneyPage.confirmButton();
        sendMoneyPage.validateNetRemittance();
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("eur");
        sendMoneyPage.validateNetRemittance();
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("nzd");
        sendMoneyPage.validateNetRemittance();
        sendMoneyPage.expandTaxAndTransferFee();
        sendMoneyPage.validateTotalFeesDynamically();
        TakeSnap.captureScreenshot();

    }

    @Test(priority = 18)
    public void TC018_Validate_The_Bank_And_Convenience_Fees_And_TotalFees_ForAD2() throws Exception {
        before("TC018 - Validate The Bank And Convenience Fees and TotalFees without TCS ForAD2 for");
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
        sendMoneyPage.inrCurrencyTextBox("1500000");
        sendMoneyPage.validateNetRemittance();
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
        sendMoneyPage.inrCurrencyTextBox("100000");
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("family maintenance");
        sendMoneyPage.confirmButton();
        sendMoneyPage.validateNetRemittance();
        sendMoneyPage.expandTaxAndTransferFee();
        sendMoneyPage.validateAd1BankAndConvenienceFee();
        sendMoneyPage.validateTotalFeesDynamically();
    }

    @Test(priority = 20)
    public void TC020_Validate_The_Total_Fees_With_TCS_ForAD2() throws Exception {
        before("TC020 - Validate The Bank And Convenience Fees ForAD2 for All Amount Ranges");
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
        sendMoneyPage.validateNetRemittance();
        sendMoneyPage.expandTaxAndTransferFee();
        sendMoneyPage.validateAd2BankAndConvenienceFee();
        sendMoneyPage.validateTotalFeesDynamically();
    }

    @Test(priority = 21)
    public void TC021_Validate_The_User_Received_AMt_WithoutTCS_ForAD2() throws Exception {
        before("TC021 -Validate The User Received AMt WithoutTCS ForAD2");
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
        sendMoneyPage.inrCurrencyTextBox("1006000.93");
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("cad");
        sendMoneyPage.validateNetRemittance();
        sendMoneyPage.expandTaxAndTransferFee();
        TakeSnap.captureScreenshot();
    }

    @Test(priority = 22)
    public void TC022_Validate_The_User_Received_AMt_WithTCS_ForAD1() throws Exception {
        before("TC022 -Validate The User Received AMt WithTCS ForAD1");
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
        sendMoneyPage.inrCurrencyTextBox("350575.22");
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("cad");
        sendMoneyPage.validateNetRemittance();
        sendMoneyPage.expandTaxAndTransferFee();
        TakeSnap.captureScreenshot();
    }

    @Test(priority = 23)
    public void TC023_Create_a_End_to_End_International_Remittance_Transaction_FYC_amount_with_the_Purpose_of_Overseas_EducationLiving_expenses_with_TCS_Apply_CouponCode_CHF_currency() throws Exception {
        before("TC023 - Create a End to End International Remittance Transaction FYC amount with the Purpose of overseas education - living expenses without TCS Apply CouponCode_CHF_currency");
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
        sendMoneyPage.confirmButton();
        sendMoneyPage.fcyCurrencyTextBox("4204.33");
        sendMoneyPage.validateNetRemittance();
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.clickFirstAvailableRecipient();
        sendMoneyPage.warningContinue();
        sendMoneyPage.selectSourceOfFunds("salary or wages");
        sendMoneyPage.applyCouponCode("ASHISH500");
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.transactionScreen();
        onboardingPage.clickBackButton();
        TakeSnap.captureScreenshot();
    }

    @Test(priority = 24)
    public void TC024_Validate_The_Bank_And_Convenience_Fees_And_Total_Feel_ForAD1_WithoutTCS() throws Exception {
        before("TC024 - Validate The Bank And Convenience Fees And Total Feel ForAD1 WithoutKYC for All Amount Ranges");
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
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("aed");
        sendMoneyPage.fcyCurrencyTextBox("20000.45");
        sendMoneyPage.validateNetRemittance();
        sendMoneyPage.expandTaxAndTransferFee();
        sendMoneyPage.validateAd1BankAndConvenienceFee();
        sendMoneyPage.validateTotalFeesDynamically();
        TakeSnap.captureScreenshot();
    }

    @Test(priority = 25)
    public void TC025_Validate_FYC_Amount_For_New_User() throws Exception {
        before("TC025 -Validate FYC Amount For New user All Amount Ranges");
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
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.fcyCurrencyTextBox("7500.22");
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("gbp");
        sendMoneyPage.validateNetRemittance();
        sendMoneyPage.fcyCurrencyTextBox("13044.56");
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("eur");
        sendMoneyPage.validateRemittanceSummary();
        sendMoneyPage.validateRemittanceActual();
        sendMoneyPage.fcyCurrencyTextBox("15829.56");
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("nzd");
        sendMoneyPage.validateRemittanceSummary();
        sendMoneyPage.validateRemittanceActual();
        TakeSnap.captureScreenshot();

    }

    @Test(priority = 26)
    public void TC026_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_Education_University_Fees_without_TCS_Apply_CouponCode_USD_Currency() throws Exception {
        before("TC026 Create a End to End International Remittance Transaction with the Purpose of Education University Fees without TCS Apply Coupon Code USD Currency");
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
        sendMoneyPage.validateRemittanceSummary();
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("overseas education - university fees");
        sendMoneyPage.toggleSwitch();
        sendMoneyPage.confirmButton();
        sendMoneyPage.inrCurrencyTextBox("1802970");
        sendMoneyPage.validateNetRemittance();
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.clickFirstAvailableRecipient();
        sendMoneyPage.warningContinue();
        sendMoneyPage.applyCouponCode("ASHISH500");
        sendMoneyPage.selectSourceOfFunds("salary or wages");
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.transactionScreen();
        TakeSnap.captureScreenshot();

    }
    @Test(priority = 27)
    public void TC027_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_Education_University_Fees_with_TCS_Apply_CouponCode_USD_Currency() throws Exception {
        before("TC027 Create a End to End International Remittance Transaction with the Purpose of Education University Fees with TCS Apply Coupon Code USD Currency");
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
        sendMoneyPage.validateRemittanceSummary();
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("overseas education - university fees");
        sendMoneyPage.confirmButton();
        sendMoneyPage.inrCurrencyTextBox("400293.22");
        sendMoneyPage.validateNetRemittance();
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.clickFirstAvailableRecipient();
        sendMoneyPage.warningContinue();
        sendMoneyPage.applyCouponCode("ASHISH500");
        sendMoneyPage.selectSourceOfFunds("salary or wages");
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.transactionScreen();
        TakeSnap.captureScreenshot();

    }
    @Test(priority = 28)
    public void TC028_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_Overseas_Education_Living_Expenses_without_TCS_Apply_CouponCoin_USD_Currency() throws Exception {
        before("TC028 Create a End to End International Remittance Transaction with the Purpose of Overseas Education Living Expenses without TCS Apply Coupon Coin USD Currency");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }
        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("7773335550");
        onboardingPage.enterIncorrectEmailId("sakthivel+550@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.oldUserEnterPin("1111");
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.validateNetRemittance();
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("chf");
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("overseas education - living expenses");
        sendMoneyPage.toggleSwitch();
        sendMoneyPage.confirmButton();
        sendMoneyPage.inrCurrencyTextBox("897679.99");
        sendMoneyPage.validateNetRemittance();
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.clickFirstAvailableRecipient();
        sendMoneyPage.warningContinue();
        sendMoneyPage.redeemHopCoins("200");
        sendMoneyPage.selectSourceOfFunds("investments");
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.transactionScreen();
        TakeSnap.captureScreenshot();

    }


    @Test(priority = 29)
    public void TC029_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_family_maintenance_with_TCS_USD_Currency_ADII() throws Exception {
        before("TC029 - Create a End to End International Remittance Transaction with the Purpose of \"family maintenance\"with TCS Payment Method UPI for Old user");
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
        sendMoneyPage.validateNetRemittance();
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("USD");
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("family maintenance");
        sendMoneyPage.confirmButton();
        sendMoneyPage.fcyCurrencyTextBox("359.56");
        onboardingPage.validatePromoMessage();
        sendMoneyPage.validateNetRemittance();
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.clickFirstAvailableRecipient();
        sendMoneyPage.warningContinue();
        sendMoneyPage.selectSourceOfFunds("personal savings");
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.completePayment();
        sendMoneyPage.selectPaymentMethod("neft");
        sendMoneyPage.validateBankDetailsAndClickContinue();
        sendMoneyPage.transactionScreen();
        TakeSnap.captureScreenshot();;

    }

    @Test(priority =30)
    public void TC030_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_living_expenses_Fees_with_TCS_GBP_Currency_Payment_Method_NetBank() throws Exception {
        before("TC030 - Create a End to End International Remittance Transaction with the Purpose of \"living_expenses_Fees\" With TCS Payment Method NetBank for Old User");
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
        sendMoneyPage.inrCurrencyTextBox("500000.55");
        onboardingPage.validatePromoMessage();
        sendMoneyPage.validateNetRemittance();
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.clickFirstAvailableRecipient();
        sendMoneyPage.warningContinue();
        sendMoneyPage.selectSourceOfFunds("investments");
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.completePayment();
        sendMoneyPage.netBanks();
        sendMoneyPage.addNewBank();
        TakeSnap.captureScreenshot();

    }

    @Test(priority = 31)
    public void TC031_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_overseas_education_living_Expenses_without_TCS_GBP_Currency() throws Exception {
        before("TC031 Create a End to End International Remittance Transaction with the Purpose of overseas education - living expenses without TCS GBP Currency");
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
        sendMoneyPage.validateRemittanceSummary();
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("gbp");
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("overseas education - university fees");
        sendMoneyPage.toggleSwitch();
        sendMoneyPage.confirmButton();
        sendMoneyPage.inrCurrencyTextBox("1802970");
        sendMoneyPage.validateNetRemittance();
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.clickFirstAvailableRecipient();
        sendMoneyPage.warningContinue();
        sendMoneyPage.applyCouponCode("ASHISH500");
        sendMoneyPage.selectSourceOfFunds("salary or wages");
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.transactionScreen();
        TakeSnap.captureScreenshot();

    }
    @Test(priority = 32)
    public void TC032_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_Family_Maintenance_GBP_currency_Payment_Method_Neft() throws Exception {
        before("TC032 - Create a End to End International Remittance Transaction with the Purpose of \"Family_Maintenance\" GBP currency Payment Method Neft for Old user");
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
        sendMoneyPage.selectCurrencyByName("gbp");
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("family maintenance");
        sendMoneyPage.confirmButton();
        sendMoneyPage.fcyCurrencyTextBox("5890.59");
        onboardingPage.validatePromoMessage();
        sendMoneyPage.validateNetRemittance();
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
    @Test(priority = 33)
    public void TC033_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_personal_gift_or_donation_GBP_Currency_Payment_Method_Neft() throws Exception {
        before("TC033 - Create a End to End International Remittance Transaction with the Purpose of \"personal_gift_or_donation\" GBP Currency  Payment Method Neftfor Old user");
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
        sendMoneyPage.validateRemittanceSummary();
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("gbp");
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("personal gift or donation");
        sendMoneyPage.confirmButton();
        sendMoneyPage.inrCurrencyTextBox("550000");
        onboardingPage.validatePromoMessage();
        sendMoneyPage.validateNetRemittance();
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

    @Test(priority = 34)
    public void TC034_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_personal_gift_or_donation_NZD_Currency_Payment_Method_Neft() throws Exception {
        before("TC034 - Create a End to End International Remittance Transaction with the Purpose of \"personal_gift_or_donation\" NZD_Currency Payment Method Neft for Old user");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("8886663330");
        onboardingPage.enterIncorrectEmailId("sakthivel+330@moneyhop.co");
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
        sendMoneyPage.inrCurrencyTextBox("999000.88");
        onboardingPage.validatePromoMessage();
        sendMoneyPage.validateNetRemittance();
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
    @Test(priority = 35)
    public void TC035_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_Overseas_Education_Living_Expenses_Recipient_flow_Payment_Method_Neft() throws Exception {
        before("TC035 - Create a End to End International Remittance Transaction with the Purpose of \"overseas education - living expenses\" Payment Method Neft for Old user Recipient_flow");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("8886663330");
        onboardingPage.enterIncorrectEmailId("sakthivel+330@moneyhop.co");
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
        sendMoneyPage.inrCurrencyTextBox("1550000.35");
        onboardingPage.validatePromoMessage();
        sendMoneyPage.validateNetRemittance();
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

    @Test(priority = 36)
    public void TC036_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_family_Maintenance_Recipient_flow_AED() throws Exception {
        before("TC036 - Create a End to End International Remittance Transaction with the Purpose of \"family maintenance\"  Payment Method Neft for Old user Recipient_flow_AED_currency");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("8886663330");
        onboardingPage.enterIncorrectEmailId("sakthivel+330@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("family maintenance");
        sendMoneyPage.confirmButton();
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("aed");
        sendMoneyPage.fcyCurrencyTextBox("20000.35");
        onboardingPage.validatePromoMessage();
        sendMoneyPage.validateNetRemittance();
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.clickFirstAvailableRecipient();
        sendMoneyPage.warningContinue();
        sendMoneyPage.selectSourceOfFunds("personal savings");
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.uploadDocs();
        sendMoneyPage.validateBankStatement();
        sendMoneyPage.docsUploadBackCTA();
        sendMoneyPage.completePayment();
        sendMoneyPage.selectPaymentMethod("neft");
        sendMoneyPage.validateBankDetailsAndClickContinue();
        sendMoneyPage.transactionScreen();
        onboardingPage.clickBackButton();
        TakeSnap.captureScreenshot();

    }
    @Test(priority = 37)
    public void TC037_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_Overseas_Education_University_Fees_Add_NewRecipient_GIC_flow_CADCurrency() throws Exception {
        before("TC037 - Create a End to End International Remittance Transaction with the Purpose of \"overseas education - University Fees\"  Payment Method Neft for Old user Add_NewRecipient GIC flow CADCurrency");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("8886663330");
        onboardingPage.enterIncorrectEmailId("sakthivel+330@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("overseas education - living expenses");
        sendMoneyPage.confirmButton();
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("cad");
        sendMoneyPage.fcyCurrencyTextBox("6528.34");
        onboardingPage.validatePromoMessage();
        sendMoneyPage.validateNetRemittance();
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.addNewRecipient();
        sendMoneyPage.selectRecipientType("gic");
        sendMoneyPage.enterRecipientDetailsAndContinue("Subbu","62TestingAddress","M5V3L9","Toronto","Canada","2562782788","testing@gmail.co");
        sendMoneyPage.enterRecipientBankDetailsAndContinue("CIBCCATT","12341234","12341234","1234");
        sendMoneyPage.selectSourceOfFunds("personal savings");
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.uploadDocs();
        sendMoneyPage.validateDocs();
        sendMoneyPage.docsUploadBackCTA();
        sendMoneyPage.completePayment();
        sendMoneyPage.selectPaymentMethod("neft");
        sendMoneyPage.validateBankDetailsAndClickContinue();
        sendMoneyPage.transactionScreen();
        onboardingPage.clickBackButton();
        TakeSnap.captureScreenshot();

    }
    @Test(priority = 38)
    public void TC038_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_Overseas_Education_Living_Expenses_Add_NewRecipient_Flywire_flow_AUDCurrency() throws Exception {
        before("TC038 - Create a End to End International Remittance Transaction with the Purpose of \"overseas education - living expenses\"  Payment Method Neft for Old user Add NewRecipient Flywir AUDCurrency");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("8886663330");
        onboardingPage.enterIncorrectEmailId("sakthivel+330@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("overseas education - living expenses");
        sendMoneyPage.confirmButton();
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("aud");
        sendMoneyPage.fcyCurrencyTextBox("25389.24");
        onboardingPage.validatePromoMessage();
        sendMoneyPage.validateNetRemittance();
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.addNewRecipient();
        sendMoneyPage.selectRecipientType("flywire");
        sendMoneyPage.enterRecipientDetailsAndContinue("Subbu","62TestingAddress","M5V3L9","Toronto","Canada","2562782788","testing@gmail.co");
        sendMoneyPage.enterRecipientBankDetailsAndContinue("SBININBB123","12341234","12341234","1234");
        sendMoneyPage.selectSourceOfFunds("investments");
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.uploadDocs();
        sendMoneyPage.docsUploadBackCTA();
        sendMoneyPage.completePayment();
        sendMoneyPage.netBanks();
        sendMoneyPage.addNewBank();
        TakeSnap.captureScreenshot();


    }
    @Test(priority = 39)
    public void TC039_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_Overseas_Education_Living_Expenses_Add_NewRecipient_Flywire_flow_AUDCurrency() throws Exception {
        before("TC039 - Create a End to End International Remittance Transaction with the Purpose of \"overseas education - living expenses\"  Payment Method Neft for Old user Add NewRecipient Flywir AUDCurrency");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("8886663330");
        onboardingPage.enterIncorrectEmailId("sakthivel+330@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("overseas education - university fees");
        sendMoneyPage.confirmButton();
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("aud");
        sendMoneyPage.inrCurrencyTextBox("90000.24");
        sendMoneyPage.validateNetRemittance();
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.addNewRecipient();
        sendMoneyPage.selectRecipientType("institution");
        sendMoneyPage.enterRecipientDetailsAndContinue("Hardik","62TestingAddress","A5V3U9","Toronto","Australiya","2562782788","testing@gmail.co");
        sendMoneyPage.enterRecipientBankDetailsAndContinue("SBININBB123","12341234","12341234","1234");
        sendMoneyPage.selectSourceOfFunds("investments");
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.uploadDocs();
        sendMoneyPage.docsUploadBackCTA();
        sendMoneyPage.completePayment();
        sendMoneyPage.selectPaymentMethod("neft");
        sendMoneyPage.validateBankDetailsAndClickContinue();
        sendMoneyPage.transactionScreen();
        onboardingPage.clickBackButton();
        TakeSnap.captureScreenshot();

    }

    @Test(priority = 40)
    public void TC040_Create_a_End_to_End_International_Remittance_Transaction_with_the_Purpose_of_family_maintenance_Add_NewRecipient_Flywire_flow_EUR_Currency() throws Exception {
        before("TC040 - Create a End to End International Remittance Transaction with the Purpose of \"family_maintenance\"  Payment Method Neft for Old user Add NewRecipient Flywir AUDCurrency");
        if (Constants.PLATFORM_NAME.equalsIgnoreCase("ios")) {
            onboardingPage.dismissButton();
        }

        onboardingPage.getStarted();
        onboardingPage.enterPhoneNo("8886663330");
        onboardingPage.enterIncorrectEmailId("sakthivel+330@moneyhop.co");
        onboardingPage.continueButton();
        onboardingPage.enterOtp("123456");
        onboardingPage.oldUserEnterPin("1234");
        onboardingPage.skipGuide();
        onboardingPage.validateUserIoOnSendMoneyScreen();
        sendMoneyPage.selectPurposeCode();
        sendMoneyPage.selectPurposeOfTransfer("family_maintenance");
        sendMoneyPage.confirmButton();
        sendMoneyPage.clickSelectCurrency();
        sendMoneyPage.selectCurrencyByName("eur");
        sendMoneyPage.inrCurrencyTextBox("190000.24");
        sendMoneyPage.validateNetRemittance();
        sendMoneyPage.setSendMoneyButton();
        sendMoneyPage.addNewRecipient();
        sendMoneyPage.selectRecipientType("institution");
        sendMoneyPage.enterRecipientDetailsAndContinue("Hardik","62TestingAddress","A5V3U9","Toronto","Australiya","2562782788","testing@gmail.co");
        sendMoneyPage.enterRecipientBankDetailsAndContinue("SBININBB123","12341234","12341234","1234");
        sendMoneyPage.selectSourceOfFunds("investments");
        sendMoneyPage.proceedToPayment();
        sendMoneyPage.uploadDocs();
        sendMoneyPage.docsUploadBackCTA();
        sendMoneyPage.completePayment();
        sendMoneyPage.selectPaymentMethod("neft");
        sendMoneyPage.validateBankDetailsAndClickContinue();
        sendMoneyPage.transactionScreen();
        onboardingPage.clickBackButton();
        TakeSnap.captureScreenshot();

    }
}

