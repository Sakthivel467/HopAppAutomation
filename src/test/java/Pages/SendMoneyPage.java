package Pages;

import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utils.*;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static Utils.AndroidUtils.*;
import static extentReport.ExtentReportManager.test;

    public class SendMoneyPage {
        private final AppiumDriver driver;
        ExcelSetup ex = new ExcelSetup();
        CommonFunctions comFun = new CommonFunctions();


        public SendMoneyPage(AppiumDriver driver) {
            this.driver = driver;
            PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
        }

        //@AndroidFindBy(xpath = "//android.widget.EditText[@text='10,000']")
        @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"HomeScreen_Exchange_Input1\"]")
        private WebElement presetInrCurrencyTextbox;
        //        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"₹\"]/following-sibling::android.widget.EditText[1]")
        @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"HomeScreen_Exchange_Input1_Value\"]")
        private WebElement inrCurrencyTextbox;
        @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"HomeScreen_Exchange_Input2_Value\"]")
        private WebElement fcyCurrencyTextbox;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"INR Amount should be greater than or equal to 5,000 INR\"]")
        private WebElement minAmountErrorMessage;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"INR Amount should be less than or equal to 20,00,000 INR\"]")
        private WebElement maxAmountErrorMessage;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Select purpose of payment *\"]")
        private WebElement SelectPurposeCode;
        //android.view.ViewGroup[@content-desc="Select purpose of payment *"]
        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Overseas Education - University Fees\"]")
        private WebElement purposeUniversityFees;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Overseas Education - Living Expenses\"]")
        private WebElement purposeLivingExpenses;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Family Maintenance\"]")
        private WebElement purposeFamilyMaintenance;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Personal Gift or Donation\"]")
        private WebElement purposeGiftDonation;
        @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Confirm \"]")
        private WebElement confirmButton;
        @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Recipients\"]")
        //android.widget.TextView[@text="Recipients"]
        private WebElement svgIcon;
        @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"HomeScreen_Send_Money_Button\"]")
        private WebElement sendMoneyButton;
        @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Send Money \"]")
        private WebElement recipientSendMoneyButton;
        @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"HomeScreen_Send_Money_Button\"]")
        private WebElement setOnetimeVerificationButton;
        @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"Recipient_Listing_Ids_133\"])[1]")
        private WebElement recipient;
        @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Continue \"]")
        private WebElement warningContinue;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Select Source of Funds\"]")
        //android.view.ViewGroup[@content-desc="Select Source of Funds"]
        private WebElement selectSourceOfFunds;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Salary or Wages']")
        private WebElement salaryOrWages;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Student Loan']")
        private WebElement studentLoan;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Investments']")
        private WebElement investments;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Personal Savings']")
        private WebElement personalSavings;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Personal Wealth']")
        private WebElement personalWealth;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Retirement Funds']")
        private WebElement retirementFunds;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Business Owner/ Share Holder']")
        private WebElement businessOwnerOrShareHolder;
        @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Proceed to payment \"]")
        private WebElement proceedtoPayment;
        @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Complete Payment \"]")
        private WebElement completePayment;
        @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Netbanking\"]")
        private WebElement paymentNetbanking;
        @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"UPI\"]")
        private WebElement paymentUPI;
        @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Transfer via NEFT\"]")
        private WebElement paymentNEFT;
        @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Add New Bank\"]")
        private WebElement addNewBank;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Add new + \"]")
        private WebElement addNewRecipient;
        @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Relationship*\"]")
        private WebElement clickRelationshipsType;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Daughter\"]")
        private WebElement relationshipsType;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Brother\"]")
        private WebElement relationshipsType1;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Son\"]")
        private WebElement relationshipsTyp3;
        @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"SendingMoney_Listing_Ids_Individual\"]/android.view.ViewGroup")
        private WebElement selectRecipientType1;
        @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"SendingMoney_Listing_Ids_Institution\"]/android.view.ViewGroup")
        private WebElement selectRecipientType2;
        @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"SendingMoney_Listing_Ids_Flywire\"]/android.view.ViewGroup")
        private WebElement selectRecipientType3;
        @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"SendingMoney_Listing_Ids_GIC\"]/android.view.ViewGroup")
        private WebElement selectRecipientType4;
        @AndroidFindBy(className = "android.widget.EditText")
        private WebElement searchBar;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select Currency']")
        private WebElement selectCurrencyLabel;
        @AndroidFindBy(xpath = "//android.widget.EditText[@text='Type a currency']")
        private WebElement placeholderTypeCurrency;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='All currencies']")
        private WebElement allCurrencies;
        @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"HomeScreen_Exchange_Input_Country_Selection\"])[2]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView\n")
        private WebElement selectCurrency;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Euro']")
        private WebElement euroCurrency;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='British Pound Sterling']")
        private WebElement gbpCurrency;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='United States Dollar']")
        private WebElement usdCurrency;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Australian Dollar']")
        private WebElement audCurrency;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Canadian Dollar']")
        private WebElement cadCurrency;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Singapore Dollar']")
        private WebElement sgdCurrency;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Japanese Yen']")
        private WebElement jpyCurrency;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='United Arab Emirates Dirham']")
        private WebElement aedCurrency;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='New Zealand Dollar']")
        private WebElement nzdCurrency;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Swiss Franc']")
        private WebElement chfCurrency;

        //        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Tax and transfer fee']")
        //android.widget.TextView[@text="Included in INR amount"]
        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Total fees\"]")
        private WebElement taxAndTransferFee;
        @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView\n")
        private WebElement taxAndTransferFeeClose;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Transfer fee']/preceding-sibling::android.widget.TextView[1]\n")
        private WebElement transferFeeAmount;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Bank fees\"]/following-sibling::android.widget.TextView\n")
        private WebElement bankFerFeeAmount;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Convenience fees\"]/following-sibling::android.widget.TextView\n")
        private WebElement convenienceFeeAmount;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='GST']/preceding-sibling::android.widget.TextView[3]\n")
        private WebElement checkGstAmount;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='TCS']/preceding-sibling::android.widget.TextView[5]")
        private WebElement checkTcsAmount;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Send Money']")
        private WebElement sendMoneyLabel;
        @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[1]")
        private WebElement enterAmountToSend;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='The minimum you can send in one transaction is 5,000 INR']")
        private WebElement minAmount;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='The maximum you can send in one transaction is 20,00,000 INR']")
        private WebElement maxAmount;
        @AndroidFindBy(xpath = "//android.widget.TextView[2]")
        private WebElement validateExchangeRate;
        @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.widget.EditText[2]")
        private WebElement foreignCurrencyTextbox;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Transfer fee']/preceding-sibling::android.widget.TextView[5]")
        private WebElement bankAndConvenienceFee;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Overseas Education - University Fees\"]")
        private WebElement purposecode;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Bank fees\"]/following-sibling::android.widget.TextView[1]")
        private WebElement bankFeesText;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Convenience fees\"]/following-sibling::android.widget.TextView[1]\n")
        private WebElement convenienceFeesText;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"GST\"]/following-sibling::android.widget.TextView[1]\n")
        private WebElement gstText;
        @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, \"TCS\")]/following-sibling::android.widget.TextView[1]\n")
        private WebElement tcsTaxText;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Total fees\"]/following-sibling::android.widget.TextView[1]\n")
        private WebElement totalFeesText;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bank Details']")
        private WebElement bankDetailsText;
        @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Continue ']")
        private WebElement continueButton;
        @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText")
        private WebElement accountUPIField;
        @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText")
        private WebElement AccountNumberField;
        @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.EditText")
        private WebElement ifscCodeField;
        @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Verify ']")
        private WebElement verifyButton;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Transaction Detail\"]")
        private WebElement transactionScreen;
        @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"AddRecipient_Recipient_Name\"]")
        private WebElement recipientName;
        @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"AddRecipient_Address\"]")
        private WebElement recipientAddress;
        @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='AddRecipient_Pincode']")
        private WebElement pinCodeField;
        @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='AddRecipient_City']")
        private WebElement cityField;
        @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='AddRecipient_State']")
        private WebElement stateField;
        @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='AddRecipient_Country']")
        private WebElement countryField;
        @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='AddRecipient_PhoneNumber']")
        private WebElement phoneField;
        @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='AddRecipient_Email']")
        private WebElement emailField;
        @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='AddRecipient_Continue']")
        private WebElement accContinueButton;
        // Page Object Locators
        @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='RecipientAccount_SWIFT_IBAN_Input']")
        private WebElement swiftIbanField;
        @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='RecipientAccount1_Bank_Account']")
        private WebElement bankAccountField;
        @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='RecipientAccount1_Confirm_Bank_Account']")
        private WebElement confirmBankAccountField;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Verify']")
        private WebElement accVerifyButton;
        @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='RecipientAccount1_Continue_Button']")
        private WebElement nextContinueButton;
        @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'1 USD')]\n")
        private WebElement ibrRateField;


        public void sendMoneyLabel() {
            Assert.assertTrue(sendMoneyLabel.isDisplayed());
            test.get().log(Status.PASS, "Label: '" + sendMoneyLabel.getText() + "' is displayed correctly");
        }

        public void validatePresetAmount() {
            Assert.assertTrue(presetInrCurrencyTextbox.isDisplayed());
            test.get().log(Status.PASS, "Label: '" + presetInrCurrencyTextbox.getText() + "' is displayed correctly");
        }

        public void inrCurrencyTextBox(String Amount) throws InterruptedException {
            inrCurrencyTextbox.click();
            inrCurrencyTextbox.clear();
            Thread.sleep(10);
            inrCurrencyTextbox.sendKeys(Amount);
//            } else {
//                System.out.println("Field is not enabled.");
//            }
//            inrCurrencyTextbox.clear();
//            inrCurrencyTextbox.sendKeys(Amount);
        }

        public void fcyCurrencyTextBox(String Amount) throws InterruptedException {
//            WebElement amountField = driver.findElement(By.id("inrCurrencyTextbox"));
//            if (amountField.isEnabled()) {
            fcyCurrencyTextbox.click();
            fcyCurrencyTextbox.clear();
            Thread.sleep(10);
            fcyCurrencyTextbox.sendKeys(Amount);
//            } else {
//                System.out.println("Field is not enabled.");
//            }
//            inrCurrencyTextbox.clear();
//            inrCurrencyTextbox.sendKeys(Amount);
        }

        public void selectCurrencyByName(String currency) throws InterruptedException {
            switch (currency.toLowerCase()) {
                case "usd":
                case "united states dollar":
                    usdCurrency.click();
                    break;
                case "gbp":
                case "british pound sterling":
                    gbpCurrency.click();
                    break;
                case "eur":
                case "euro":
                    euroCurrency.click();
                    break;
                case "aud":
                case "australian dollar":
                    audCurrency.click();
                    break;
                case "cad":
                case "canadian dollar":
                    cadCurrency.click();
                    break;
                case "sgd":
                case "singapore dollar":
                    sgdCurrency.click();
                    break;
                case "jpy":
                case "japanese yen":
                    jpyCurrency.click();
                    break;
                case "aed":
                case "united arab emirates dirham":
                    aedCurrency.click();
                    break;
                case "nzd":
                case "new zealand dollar":
                    nzdCurrency.click();
                    break;
                case "chf":
                case "swiss franc":
                    chfCurrency.click();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid currency name: " + currency);
            }
            // Optional screenshot and wait
            TakeSnap.captureScreenshot();
            Thread.sleep(1000);
        }

        public void minAmountValidation() {
            Assert.assertTrue(minAmountErrorMessage.isDisplayed());
            test.get().log(Status.PASS, "Error message: '" + minAmountErrorMessage.getText() + "' is displayed correctly");

            Assert.assertFalse(sendMoneyButton.isEnabled());
            test.get().log(Status.PASS, "User is unable to move forward if the Minimum Amount Error is Displayed");

            TakeSnap.captureScreenshot();
        }

        public void maxAmountValidation() {
            Assert.assertTrue(maxAmountErrorMessage.isDisplayed());
            test.get().log(Status.PASS, "Error message: '" + maxAmountErrorMessage.getText() + "' is displayed correctly");

            Assert.assertFalse(sendMoneyButton.isEnabled());
            test.get().log(Status.PASS, "User is unable to move forward if the Maximum Amount Error is Displayed");

            TakeSnap.captureScreenshot();
        }

        public WebElement getCurrencyCode(String currencyCode) {
            String currencyCodeXpath = String.format("//android.widget.TextView[@text='%s']", currencyCode);
            return driver.findElement(By.xpath(currencyCodeXpath));
        }

        public WebElement getCurrencyFlag(String currencyFlag) {

            String currencyFlagXpath = String.format("(//android.view.ViewGroup[@content-desc=\"HomeScreen_Exchange_Input_Country_Selection\"])[1]/android.view.ViewGroup/android.widget.ImageView", currencyFlag);
            return driver.findElement(By.xpath(currencyFlagXpath));
        }

        public WebElement getCurrencySymbol(String currencySymbol) {
            String currencySymbolXpath = String.format("//android.widget.TextView[@text=\"₹\"]", currencySymbol);
            return driver.findElement(By.xpath(currencySymbolXpath));
        }

        public WebElement getForeignCurrencyFlag(String currencyFlag) {

            String currencyFlagXpath = String.format("//android.view.ViewGroup[@content-desc='%s']/android.widget.ImageView", currencyFlag);
            return driver.findElement(By.xpath(currencyFlagXpath));
        }

        public void defaultCurrencies() {

            Assert.assertTrue(getCurrencyCode("INR").isDisplayed());
            test.get().log(Status.PASS, "Success message: 'Indian Currency Code: " + getCurrencyCode("INR").getText() + "' is displayed correctly");

            Assert.assertTrue(getCurrencyFlag("INR").isDisplayed());
            test.get().log(Status.PASS, "Success message: 'Indian Currency Flag' is displayed correctly");

            Assert.assertTrue(getCurrencySymbol("₹").isDisplayed());
            test.get().log(Status.PASS, "Success message: 'Indian Currency Symbol: " + getCurrencySymbol("₹").getText() + "' is displayed correctly");

            Assert.assertTrue(getCurrencyCode("USD").isDisplayed());
            test.get().log(Status.PASS, "Success message: 'Default Foreign Currency Code: " + getCurrencyCode("USD").getText() + "' is displayed correctly");

            Assert.assertTrue(getCurrencyFlag("USD").isDisplayed());
            test.get().log(Status.PASS, "Success message: 'Default Foreign Currency Flag' is displayed correctly");

            Assert.assertTrue(getCurrencySymbol("$").isDisplayed());
            test.get().log(Status.PASS, "Success message: 'Default Foreign Currency Symbol: " + getCurrencySymbol("$").getText() + "' is displayed correctly");
        }

        public void selectForeignCurrency(String code) {
            getCurrencyCode(code).click();
        }

        public void searchBarTxt(String text) {
            searchBar.sendKeys(text);


        }

        public void foreignCurrencies() throws InterruptedException {


//            selectForeignCurrency("USD");
//
//            comFun.wait(selectCurrencyLabel);
//            Assert.assertTrue(selectCurrencyLabel.isDisplayed());
//            test.get().log(Status.PASS, "Label: '" + selectCurrencyLabel.getText() + "' is displayed correctly");
//
//            Assert.assertTrue(placeholderTypeCurrency.isDisplayed());
//            test.get().log(Status.PASS, "Label: '" + placeholderTypeCurrency.getText() + "' is displayed correctly");
//
//            Assert.assertTrue(allCurrencies.isDisplayed());
//            test.get().log(Status.PASS, "Label: '" + allCurrencies.getText() + "' is displayed correctly");
//            TakeSnap.captureScreenshot();
//
//            searchBarTxt("Euro");
//            TakeSnap.captureScreenshot();
//            searchBar.clear();
//            if (getForeignCurrencyFlag("EUR, Euro").isDisplayed() & euroCurrency.isDisplayed()) {
//                euroCurrency.click();
//                comFun.wait(sendMoneyLabel);
//                Assert.assertTrue(getCurrencyCode("EUR").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Code: " + getCurrencyCode("EUR").getText() + "' is displayed correctly");
//
//                Assert.assertTrue(getCurrencyFlag("EUR").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Flag' is displayed correctly");
//
//                Assert.assertTrue(getCurrencySymbol("€").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Symbol: " + getCurrencySymbol("€").getText() + "' is displayed correctly");
//            }
//            TakeSnap.captureScreenshot();
//
//            selectForeignCurrency("EUR");
//            comFun.wait(selectCurrencyLabel);
//            searchBarTxt("GBP");
//            TakeSnap.captureScreenshot();
//            searchBar.clear();
//            if (getForeignCurrencyFlag("GBP, British Pound Sterling").isDisplayed() & gbpCurrency.isDisplayed()) {
//                gbpCurrency.click();
//                comFun.wait(sendMoneyLabel);
//                Assert.assertTrue(getCurrencyCode("GBP").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Code: " + getCurrencyCode("GBP").getText() + "' is displayed correctly");
//
//                Assert.assertTrue(getCurrencyFlag("GBP").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Flag' is displayed correctly");
//
//                Assert.assertTrue(getCurrencySymbol("£").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Symbol: " + getCurrencySymbol("£").getText() + "' is displayed correctly");
//            }
//            TakeSnap.captureScreenshot();
//            selectForeignCurrency("GBP");
//            comFun.wait(selectCurrencyLabel);
//            searchBarTxt("USD");
//            TakeSnap.captureScreenshot();
//            searchBar.clear();
//            if (getForeignCurrencyFlag("USD, United States Dollar").isDisplayed() & gbpCurrency.isDisplayed()) {
//                usdCurrency.click();
//                comFun.wait(sendMoneyLabel);
//                Assert.assertTrue(getCurrencyCode("USD").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Code: " + getCurrencyCode("USD").getText() + "' is displayed correctly");
//
//                Assert.assertTrue(getCurrencyFlag("USD").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Flag' is displayed correctly");
//
//                Assert.assertTrue(getCurrencySymbol("$").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Symbol: " + getCurrencySymbol("$").getText() + "' is displayed correctly");
//            }
//            TakeSnap.captureScreenshot();
//            selectForeignCurrency("USD");
//            comFun.wait(selectCurrencyLabel);
//            searchBarTxt("AUD");
//            TakeSnap.captureScreenshot();
//            searchBar.clear();
//            if (getForeignCurrencyFlag("AUD, Australian Dollar").isDisplayed() & gbpCurrency.isDisplayed()) {
//                audCurrency.click();
//                comFun.wait(sendMoneyLabel);
//                Assert.assertTrue(getCurrencyCode("AUD").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Code: " + getCurrencyCode("AUD").getText() + "' is displayed correctly");
//
//                Assert.assertTrue(getCurrencyFlag("AUD").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Flag' is displayed correctly");
//
//                Assert.assertTrue(getCurrencySymbol("$").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Symbol: " + getCurrencySymbol("$").getText() + "' is displayed correctly");
//            }
//            TakeSnap.captureScreenshot();
//            selectForeignCurrency("AUD");
//            comFun.wait(selectCurrencyLabel);
//            searchBarTxt("CAD");
//            TakeSnap.captureScreenshot();
//            searchBar.clear();
//            if (getForeignCurrencyFlag("CAD, Canadian Dollar").isDisplayed() & gbpCurrency.isDisplayed()) {
//                cadCurrency.click();
//                comFun.wait(sendMoneyLabel);
//                Assert.assertTrue(getCurrencyCode("CAD").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Code: " + getCurrencyCode("CAD").getText() + "' is displayed correctly");
//
//                Assert.assertTrue(getCurrencyFlag("CAD").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Flag' is displayed correctly");
//
//                Assert.assertTrue(getCurrencySymbol("$").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Symbol: " + getCurrencySymbol("$").getText() + "' is displayed correctly");
//            }
//            TakeSnap.captureScreenshot();
//            selectForeignCurrency("CAD");
//            comFun.wait(selectCurrencyLabel);
//            searchBarTxt("SGD");
//            TakeSnap.captureScreenshot();
//            searchBar.clear();
//            if (getForeignCurrencyFlag("SGD, Singapore Dollar").isDisplayed() & gbpCurrency.isDisplayed()) {
//                sgdCurrency.click();
//                comFun.wait(sendMoneyLabel);
//                Assert.assertTrue(getCurrencyCode("SGD").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Code: " + getCurrencyCode("SGD").getText() + "' is displayed correctly");
//
//                Assert.assertTrue(getCurrencyFlag("SGD").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Flag' is displayed correctly");
//
//                Assert.assertTrue(getCurrencySymbol("$").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Symbol: " + getCurrencySymbol("$").getText() + "' is displayed correctly");
//            }
//            TakeSnap.captureScreenshot();
//            selectForeignCurrency("SGD");
//            comFun.wait(selectCurrencyLabel);
//            searchBarTxt("JPY");
//            TakeSnap.captureScreenshot();
//            searchBar.clear();
//            if (getForeignCurrencyFlag("JPY, Japanese Yen").isDisplayed() & gbpCurrency.isDisplayed()) {
//                jpyCurrency.click();
//                comFun.wait(sendMoneyLabel);
//                Assert.assertTrue(getCurrencyCode("JPY").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Code: " + getCurrencyCode("JPY").getText() + "' is displayed correctly");
//
//                Assert.assertTrue(getCurrencyFlag("JPY").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Flag' is displayed correctly");
//
//                Assert.assertTrue(getCurrencySymbol("¥").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Symbol: " + getCurrencySymbol("¥").getText() + "' is displayed correctly");
//            }
//            TakeSnap.captureScreenshot();
//            selectForeignCurrency("JPY");
//            comFun.wait(selectCurrencyLabel);
//
//            searchBarTxt("NZD");
//            TakeSnap.captureScreenshot();
//            searchBar.clear();
//            if (getForeignCurrencyFlag("NZD, New Zealand Dollar").isDisplayed() & gbpCurrency.isDisplayed()) {
//                nzdCurrency.click();
//                comFun.wait(sendMoneyLabel);
//                Assert.assertTrue(getCurrencyCode("NZD").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Code: " + getCurrencyCode("NZD").getText() + "' is displayed correctly");
//
//                Assert.assertTrue(getCurrencyFlag("NZD").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Flag' is displayed correctly");
//
//                Assert.assertTrue(getCurrencySymbol("$").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Symbol: " + getCurrencySymbol("$").getText() + "' is displayed correctly");
//            }
//            TakeSnap.captureScreenshot();
//            selectForeignCurrency("NZD");
//            comFun.wait(selectCurrencyLabel);
//            searchBarTxt("CHF");
//            TakeSnap.captureScreenshot();
//            searchBar.clear();
//            if (getForeignCurrencyFlag("CHF, Swiss Franc").isDisplayed() & gbpCurrency.isDisplayed()) {
//                chfCurrency.click();
//                comFun.wait(sendMoneyLabel);
//                Assert.assertTrue(getCurrencyCode("CHF").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Code: " + getCurrencyCode("CHF").getText() + "' is displayed correctly");
//
//                Assert.assertTrue(getCurrencyFlag("CHF").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Flag' is displayed correctly");
//
//                Assert.assertTrue(getCurrencySymbol("₣").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Symbol: " + getCurrencySymbol("₣").getText() + "' is displayed correctly");
//            }
//            TakeSnap.captureScreenshot();
//            selectForeignCurrency("CHF");
//            comFun.wait(selectCurrencyLabel);
//            searchBarTxt("AED");
//            TakeSnap.captureScreenshot();
//            searchBar.clear();
//            if (getForeignCurrencyFlag("AED, United Arab Emirates Dirham").isDisplayed() & gbpCurrency.isDisplayed()) {
//                aedCurrency.click();
//                comFun.wait(sendMoneyLabel);
//                Assert.assertTrue(getCurrencyCode("AED").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Code: " + getCurrencyCode("AED").getText() + "' is displayed correctly");
//
//                Assert.assertTrue(getCurrencyFlag("AED").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Flag' is displayed correctly");
//
//                Assert.assertTrue(getCurrencySymbol("AED").isDisplayed());
//                test.get().log(Status.PASS, "Success message: 'Foreign Currency Symbol: " + getCurrencySymbol("AED").getText() + "' is displayed correctly");
//            }
//            TakeSnap.captureScreenshot();
        }


//         public void expandTaxAndTransferFee(boolean validateGst) {
//                try {
//                    // Step 1: Expand the section
//                    taxAndTransferFee.click();
//                    Thread.sleep(1000); // Or use WebDriverWait
//
//                    // Step 2: Conditionally validate GST
//                    if (validateGst) {
//                        validateGST();
//                    }
//
//                    // Step 3: Collapse the section
//                    taxAndTransferFeeClose.click();
//                    Thread.sleep(1000);
//
//                    test.get().log(Status.INFO, "Tax & Transfer Fee section expanded" +
//                            (validateGst ? ", GST validated" : "") + ", and section closed.");
//
//                } catch (Exception e) {
//                    test.get().log(Status.FAIL, "Failed to expand/close Tax & Transfer Fee section: " + e.getMessage());
//                    TakeSnap.captureScreenshot();
//                }
//            }

        public void expandTaxAndTransferFee() throws InterruptedException {
            taxAndTransferFee.click();
            TakeSnap.captureScreenshot();


        }

        public void expandTaxAndTransferClose() throws InterruptedException {
            taxAndTransferFeeClose.click();
            Thread.sleep(4000);

        }


//        public void validateTransferFee() throws InterruptedException {
//
//            String youSendAmount = comFun.removeDelimiter(inrCurrencyTextbox.getText());
//            String transferFee = comFun.removeDelimiter(transferFeeAmount.getText());
//
//            // Convenience Fees( It will be needed once the Promo code is deployed)
//            double conFeeMinAmount = 0;
//            double conFeeAmountRange1 = 250;
//            double conFeeAmountRange2 = 350;
//            double conFeeAmountRange3 = 750;
//            double conFeeAmountRange4 = 1000;
//            double conFeeAmountRange5 = 1250;
//
//
//            // Bank Fees
//            double bankFeeMinAmount = 750;
//            double bankFeeAmountRange1 = 1000;
//            double bankFeeAmountRange2 = 1250;
//            double bankFeeAmountRange3 = 1500;
//
//            // Bank and Convenience Fees ( It will be needed once the Promo code is deployed)
//            double bankAndConvenienceFeeMinAmount = conFeeMinAmount + bankFeeMinAmount;
//            double bankAndConvenienceFeeAmountRange1 = conFeeAmountRange1 + bankFeeAmountRange1;
//            double bankAndConvenienceFeeAmountRange2 = conFeeAmountRange2 + bankFeeAmountRange2;
//            double bankAndConvenienceFeeAmountRange3 = conFeeAmountRange3 + bankFeeAmountRange3;
//            double bankAndConvenienceFeeAmountRange4 = conFeeAmountRange4 + bankFeeAmountRange3;
//            double bankAndConvenienceFeeAmountRange5 = conFeeAmountRange5 + bankFeeAmountRange3;
//
//
//            if (Double.parseDouble(youSendAmount) < 80000) {
//                if (String.valueOf(bankFeeMinAmount).contains(transferFee)) {
//                    test.get().log(Status.PASS, "Successful Validation Message: Amount is less than 80000, so the transfer fee is calculated as Expected: " + transferFee);
//                } else {
//                    test.get().log(Status.FAIL, "Amount is less than 80000, so the transfer fee is not calculated as Expected: " + transferFee);
//                }
//            }
//            if (Double.parseDouble(youSendAmount) >= 80000 && Double.parseDouble(youSendAmount) < 200000) {
//                if (String.valueOf(bankFeeAmountRange1).contains(transferFee)) {
//                    test.get().log(Status.PASS, "Successful Validation Message: Amount is in range of 80000 to 200000 so the transfer fee is calculated as Expected: " + transferFee);
//                } else {
//                    test.get().log(Status.FAIL, "Amount is in range of 80000 to 200000 so the transfer fee is not calculated as Expected: " + transferFee);
//                }
//            }
//
//            if (Double.parseDouble(youSendAmount) >= 200000 && Double.parseDouble(youSendAmount) < 400000) {
//                if (String.valueOf(bankFeeAmountRange2).contains(transferFee)) {
//                    test.get().log(Status.PASS, "Successful Validation Message: Amount is in range of 200000 to 400000 so the transfer fee is calculated as Expected: " + transferFee);
//                } else {
//                    test.get().log(Status.FAIL, "Amount is in range of 200000 to 400000 so the transfer fee is not calculated as Expected: " + transferFee);
//                }
//            }
//
//            if (Double.parseDouble(youSendAmount) >= 400000) {
//                if (String.valueOf(bankFeeAmountRange3).contains(transferFee)) {
//                    test.get().log(Status.PASS, "Successful Validation Message: Amount is equal or more than 400000 so the transfer fee is calculated as Expected: " + transferFee);
//                } else {
//                    test.get().log(Status.FAIL, "Amount is equal or more than 400000 so the transfer fee is not calculated as Expected: " + transferFee);
//                }
//            }
//            TakeSnap.captureScreenshot();
//
//
//        //  (It will be needed once the Promo code is deployed)
//        if(Double.parseDouble(youSendAmount)<80000)
//
//        {
//            if (String.valueOf(bankAndConvenienceFeeMinAmount).contains(bankAndConvenienceFeeAmount)) {
//                System.out.println("Successful Validation Message: Amount is less than 80000, so the bank and convenience fee is calculated as Expected: " + bankAndConvenienceFeeAmount);
//            } else {
//                System.out.println("Amount is less than 80000, so the bank and convenience fee is not calculated as Expected: " + bankAndConvenienceFeeAmount);
//            }
//        }
//        if(Double.parseDouble(youSendAmount)>=80000&&Double.parseDouble(youSendAmount)<200000)
//
//        {
//            if (String.valueOf(bankAndConvenienceFeeAmountRange1).contains(bankAndConvenienceFeeAmount)) {
//                System.out.println("Successful Validation Message: Amount is in range of 80000 to 200000 so the bank and convenience fee is calculated as Expected: " + bankAndConvenienceFeeAmount);
//            } else {
//                System.out.println("Amount is in range of 80000 to 200000 so the bank and convenience fee is not calculated as Expected: " + bankAndConvenienceFeeAmount);
//            }
//        }
//
//        if(Double.parseDouble(youSendAmount)>=200000&&Double.parseDouble(youSendAmount)<400000)
//
//        {
//            if (String.valueOf(bankAndConvenienceFeeAmountRange2).contains(bankAndConvenienceFeeAmount)) {
//                System.out.println("Successful Validation Message: Amount is in range of 200000 to 400000 so the bank and convenience fee is calculated as Expected: " + bankAndConvenienceFeeAmount);
//            } else {
//                System.out.println("Amount is in range of 200000 to 400000 so the bank and convenience fee is not calculated as Expected: " + bankAndConvenienceFeeAmount);
//            }
//        }
//
//        if(Double.parseDouble(youSendAmount)>=400000&&Double.parseDouble(youSendAmount)<600000)
//
//        {
//            if (String.valueOf(bankAndConvenienceFeeAmountRange3).contains(bankAndConvenienceFeeAmount)) {
//                System.out.println("Successful Validation Message: Amount is in range of 400000 to 600000 so the bank and convenience fee is calculated as Expected: " + bankAndConvenienceFeeAmount);
//            } else {
//                System.out.println("Amount is in range of 400000 to 600000 so the bank and convenience fee is not calculated as Expected: " + bankAndConvenienceFeeAmount);
//            }
//        }
//
//        if(Double.parseDouble(youSendAmount)>=600000&&Double.parseDouble(youSendAmount)<1000000)
//
//        {
//            if (String.valueOf(bankAndConvenienceFeeAmountRange4).contains(bankAndConvenienceFeeAmount)) {
//                System.out.println("Successful Validation Message: Amount is in range of 600000 to 1000000 so the bank and convenience fee is calculated as Expected: " + bankAndConvenienceFeeAmount);
//            } else {
//                System.out.println("Amount is in range of 600000 to 1000000 so the bank and convenience fee is not calculated as Expected: " + bankAndConvenienceFeeAmount);
//            }
//        }
//
//        if(Double.parseDouble(youSendAmount)>=1000000)
//
//        {
//            if (String.valueOf(bankAndConvenienceFeeAmountRange5).contains(bankAndConvenienceFeeAmount)) {
//                System.out.println("Successful Validation Message: Amount is more than 1000000 so the bank and convenience fee is calculated as Expected: " + bankAndConvenienceFeeAmount);
//            } else {
//                System.out.println("Amount is more than 1000000 so the bank and convenience fee is not calculated as Expected: " + bankAndConvenienceFeeAmount);
//            }
//        }
//        }

        private BigDecimal gstFrom(double baseFee) {
            double gstValue = twoDecimalValues(baseFee * 0.18 * 100) / 100;
            return new BigDecimal(gstValue).setScale(0, RoundingMode.UP);
        }

        private void validateGstCondition(BigDecimal expected, BigDecimal actual, String slabInfo) {
            if (expected.equals(actual)) {
                test.get().log(Status.PASS, "GST Validated: " + slabInfo + " | GST: " + actual);
            } else {
                test.get().log(Status.FAIL, "GST Mismatch: " + slabInfo + " | Expected: " + expected + ", Found: " + actual);
            }
        }

        public void validateGST() {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.visibilityOf(inrCurrencyTextbox));
                wait.until(ExpectedConditions.visibilityOf(checkGstAmount));

                // Extract raw UI values
                String youSendAmountRaw = inrCurrencyTextbox.getText();
                String gstAmountRaw = checkGstAmount.getText();

                // Clean numeric values
                String youSendAmountClean = comFun.removeDelimiter(youSendAmountRaw);
                String gstAmountClean = String.valueOf(extractNumber(gstAmountRaw));

                double amount = Double.parseDouble(youSendAmountClean);
                BigDecimal actualGst = new BigDecimal(gstAmountClean).setScale(0, RoundingMode.UP);
                BigDecimal expectedGst;

                // GST calculation logic based on amount range
                if (amount <= 25000) {
                    expectedGst = new BigDecimal(45);
                    validateGstCondition(expectedGst, actualGst, "Amount ≤ 25,000");
                } else if (amount <= 80000) {
                    expectedGst = gstFrom(amount - 0);
                    validateGstCondition(expectedGst, actualGst, "Amount between 25,001 – 80,000");
                } else if (amount <= 100000) {
                    expectedGst = gstFrom(amount - 250);
                    validateGstCondition(expectedGst, actualGst, "Amount between 80,001 – 1,00,000");
                } else if (amount <= 200000) {
                    expectedGst = gstFrom(1000 + ((amount - 250 - 100000) * 5 / 1000));
                    validateGstCondition(expectedGst, actualGst, "Amount between 1L – 2L");
                } else if (amount <= 400000) {
                    expectedGst = gstFrom(1000 + ((amount - 350 - 100000) * 5 / 1000));
                    validateGstCondition(expectedGst, actualGst, "Amount between 2L – 4L");
                } else if (amount <= 600000) {
                    expectedGst = gstFrom(1000 + ((amount - 750 - 100000) * 5 / 1000));
                    validateGstCondition(expectedGst, actualGst, "Amount between 4L – 6L");
                } else if (amount <= 1000000) {
                    expectedGst = gstFrom(1000 + ((amount - 1000 - 100000) * 5 / 1000));
                    validateGstCondition(expectedGst, actualGst, "Amount between 6L – 10L");
                } else {
                    expectedGst = gstFrom(5500 + ((amount - 1250 - 1000000) * 0.001));
                    validateGstCondition(expectedGst, actualGst, "Amount > 10L");
                }

                // Print values to terminal
                System.out.println("  Amount entered: " + amount);
                System.out.println(" GST displayed (UI): " + gstAmountRaw);
                System.out.println(" GST extracted: " + actualGst);
                System.out.println(" GST expected: " + expectedGst);

                TakeSnap.captureScreenshot();

            } catch (Exception e) {
                test.get().log(Status.FAIL, "Exception occurred while validating GST: " + e.getMessage());
                e.printStackTrace();
            }
        }

        public void selectMethod() throws InterruptedException {
            Thread.sleep(2000);
            String youSendAmount = comFun.removeDelimiter(inrCurrencyTextbox.getText());
            String gstAmount = String.valueOf(extractNumber(checkGstAmount.getText()));

            // Convenience Fees
            double conFeeMinAmount = 0;
            double conFeeAmountRange1 = 250;
            double conFeeAmountRange2 = 350;
            double conFeeAmountRange3 = 750;
            double conFeeAmountRange4 = 1000;
            double conFeeAmountRange5 = 1250;

            int expectedGstAmountOption_1 = 45; //If Amount is Less than 25000
            double expectedGstAmountOption_2 = twoDecimalValues((((Double.parseDouble(youSendAmount) - Double.parseDouble(String.valueOf(conFeeMinAmount))) * 0.18) / 100) * 100) / 100; //If Amount is in Range of 25000 to 80000
            double expectedGstAmountOption_3 = twoDecimalValues((((Double.parseDouble(youSendAmount) - Double.parseDouble(String.valueOf(conFeeAmountRange1))) * 0.18) / 100) * 100) / 100; //If Amount is in Range of 80000 to 100000

            double expectedGstAmountOption_4 = twoDecimalValues((1000 + (((Double.parseDouble(youSendAmount) - Double.parseDouble(String.valueOf(conFeeAmountRange1)) - 100000) * 5) / 1000)) * 0.18 * 100) / 100; //If Amount is in Range of 100000 to 200000

            double expectedGstAmountOption_5 = twoDecimalValues((1000 + (((Double.parseDouble(youSendAmount) - Double.parseDouble(String.valueOf(conFeeAmountRange2)) - 100000) * 5) / 1000)) * 0.18 * 100) / 100; //If Amount is in Range of 200000 to 400000

            double expectedGstAmountOption_6 = twoDecimalValues((1000 + (((Double.parseDouble(youSendAmount) - Double.parseDouble(String.valueOf(conFeeAmountRange3)) - 100000) * 5) / 1000)) * 0.18 * 100) / 100; //If Amount is in Range of 400000 to 600000

            double expectedGstAmountOption_7 = twoDecimalValues((1000 + (((Double.parseDouble(youSendAmount) - Double.parseDouble(String.valueOf(conFeeAmountRange4)) - 100000) * 5) / 1000)) * 0.18 * 100) / 100; //If Amount is in Range of 600000 to 1000000
            double expectedGstAmountOption_8 = twoDecimalValues((5500 + ((Double.parseDouble(youSendAmount) - Double.parseDouble(String.valueOf(conFeeAmountRange5)) - 1000000) * 0.001)) * 0.18 * 100) / 100;//If Amount is greater than 1000000

            BigDecimal condition_2 = new BigDecimal(expectedGstAmountOption_2);
            BigDecimal condition_3 = new BigDecimal(expectedGstAmountOption_3);
            BigDecimal condition_4 = new BigDecimal(expectedGstAmountOption_4);
            BigDecimal condition_5 = new BigDecimal(expectedGstAmountOption_5);
            BigDecimal condition_6 = new BigDecimal(expectedGstAmountOption_6);
            BigDecimal condition_7 = new BigDecimal(expectedGstAmountOption_7);
            BigDecimal condition_8 = new BigDecimal(expectedGstAmountOption_8);
            BigDecimal defaultCondition = new BigDecimal(gstAmount);

            condition_2 = condition_2.setScale(0, RoundingMode.UP);
            condition_3 = condition_3.setScale(0, RoundingMode.UP);
            condition_4 = condition_4.setScale(0, RoundingMode.UP);
            condition_5 = condition_5.setScale(0, RoundingMode.UP);
            condition_6 = condition_6.setScale(0, RoundingMode.UP);
            condition_7 = condition_7.setScale(0, RoundingMode.UP);
            condition_8 = condition_8.setScale(0, RoundingMode.UP);
            defaultCondition = defaultCondition.setScale(0, RoundingMode.UP);

            if (Integer.parseInt(youSendAmount) <= 25000) {
                if ((String.valueOf(expectedGstAmountOption_1)).contains(gstAmount)) {
                    test.get().log(Status.PASS, "Successful Validation Message: The Amount is less than 25000 so the GST will be: " + gstAmount);
                } else {
                    test.get().log(Status.FAIL, "The Amount is less than 25000 but the GST Amount is not as expected: " + gstAmount);
                }
            }

            if (Double.parseDouble(youSendAmount) > 25000 && Double.parseDouble(youSendAmount) <= 80000) {

                if (condition_2.equals(defaultCondition)) {
                    test.get().log(Status.PASS, "Successful Validation Message: The Amount is in range of  25000 to 80000 so the GST will be: " + gstAmount);
                } else {
                    test.get().log(Status.FAIL, "The Amount is in the range of 25000 to 80000 but the GST Amount is not as expected: " + gstAmount);
                }
            }

            if (Double.parseDouble(youSendAmount) > 80000 && Double.parseDouble(youSendAmount) <= 100000) {

                if (condition_3.equals(defaultCondition)) {
                    test.get().log(Status.PASS, "Successful Validation Message: The Amount is in range of  80000 to 1 Lakh so the GST will be: " + gstAmount);
                } else {
                    test.get().log(Status.FAIL, "The Amount is in the range of 80000 to 1 Lakh but the GST Amount is not as expected: " + gstAmount);
                }
            }

            if (Double.parseDouble(youSendAmount) > 100000 && Double.parseDouble(youSendAmount) <= 200000) {
                if (condition_4.equals(defaultCondition)) {

                    test.get().log(Status.PASS, "Successful Validation Message: The Amount is in range of 1 Lakh to 2 Lakh so the GST will be: " + gstAmount);
                } else {
                    test.get().log(Status.FAIL, "The Amount is in the range of 1 Lakh to 2 Lakh but the GST Amount is not as expected: " + gstAmount);
                }
            }

            if (Double.parseDouble(youSendAmount) > 200000 && Double.parseDouble(youSendAmount) <= 400000) {
                if (condition_5.equals(defaultCondition)) {

                    test.get().log(Status.PASS, "Successful Validation Message: The Amount is in range of 2 Lakh to 4 Lakh so the GST will be: " + gstAmount);
                } else {
                    test.get().log(Status.FAIL, "The Amount is in the range of 2 Lakh to 4 Lakh but the GST Amount is not as expected: " + gstAmount);
                }
            }

            if (Double.parseDouble(youSendAmount) > 400000 && Double.parseDouble(youSendAmount) <= 600000) {
                if (condition_6.equals(defaultCondition)) {

                    test.get().log(Status.PASS, "Successful Validation Message: The Amount is in range of 4 Lakh to 6 Lakh so the GST will be: " + gstAmount);
                } else {
                    test.get().log(Status.FAIL, "The Amount is in the range of 4 Lakh to 6 Lakh but the GST Amount is not as expected: " + gstAmount);
                }
            }

            if (Double.parseDouble(youSendAmount) > 600000 && Double.parseDouble(youSendAmount) <= 1000000) {
                if (condition_7.equals(defaultCondition)) {

                    test.get().log(Status.PASS, "Successful Validation Message: The Amount is in range of 6 Lakh to 10 Lakh so the GST will be: " + gstAmount);
                } else {
                    test.get().log(Status.FAIL, "The Amount is in the range of 6 Lakh to 10 Lakh but the GST Amount is not as expected: " + gstAmount);
                }
            }

            if (Double.parseDouble(youSendAmount) > 1000000) {
                if (condition_8.equals(defaultCondition)) {
                    test.get().log(Status.PASS, "Successful Validation Message: The Amount is greater than 10 Lakh so the GST will be: " + gstAmount);
                } else {
                    test.get().log(Status.FAIL, "The Amount is greater than 10 Lakh but the GST Amount is not as expected: " + gstAmount);
                }
            }
            TakeSnap.captureScreenshot();
        }

        public void selectPurposeCode() throws InterruptedException {
            Thread.sleep(500);
            SelectPurposeCode.click();
        }

        public void selectPurposeOfTransfer(String purpose) throws InterruptedException {
            switch (purpose.toLowerCase()) {
                case "overseas education - university fees":
                    purposeUniversityFees.click();
                    break;
                case "overseas education - living expenses":
                    purposeLivingExpenses.click();
                    break;
                case "family maintenance":
                    purposeFamilyMaintenance.click();
                    break;
                case "personal gift or donation":
                    purposeGiftDonation.click();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid purpose of transfer: " + purpose);
            }
            TakeSnap.captureScreenshot();
            Thread.sleep(1000); // Consider using WebDriverWait instead of Thread.sleep
        }


        public void confirmButton() {
            confirmButton.click();
        }

        public void clickRecipientSvgIcon() {
            svgIcon.click();
        }

        public void setSendMoneyButton() throws InterruptedException {
            Thread.sleep(800);
            TakeSnap.captureScreenshot();
            sendMoneyButton.click();
        }

        public void recipientSendMoneyButton() throws InterruptedException {
            Thread.sleep(800);
            TakeSnap.captureScreenshot();
            recipientSendMoneyButton.click();
        }


        public void setOnetimeVerificationButton() throws InterruptedException {
            Thread.sleep(500);
            setOnetimeVerificationButton.click();
        }

        //        public void recipient() throws InterruptedException{
//            Thread.sleep(300);
//            recipient.click();
//            TakeSnap.captureScreenshot();
//        }
        public void clickFirstAvailableRecipient() {
            List<String> xpaths = Arrays.asList(
                    "(//android.view.ViewGroup[@content-desc='Recipient_Listing_Ids_0000037211307001'])[1]",
                    "(//android.view.ViewGroup[@content-desc='Recipient_Listing_Ids_31926819'])[1]",
                    "(//android.view.ViewGroup[@content-desc='Recipient_Listing_Ids_133'])[1]",
                    "(//android.view.ViewGroup[@content-desc='Recipient_Listing_Ids_133'])[2]",
                    "(//android.view.ViewGroup[@content-desc='Recipient_Listing_Ids_123'])[1]",
                    "//android.view.ViewGroup[@content-desc='Recipient_Listing_Ids_1342']",
                    "//android.view.ViewGroup[@content-desc='Recipient_Listing_Ids_457']",
                    "//android.view.ViewGroup[@content-desc='Recipient_Listing_Ids_234']"
            );

            boolean clicked = false;

            for (String xpath : xpaths) {
                try {
                    WebElement element = driver.findElement(By.xpath(xpath));
                    if (element.isDisplayed()) {
                        element.click();
                        TakeSnap.captureScreenshot(); // Optional
                        System.out.println("Clicked element with XPath: " + xpath);
                        clicked = true;
                        break; // Exit after first match
                    }
                } catch (NoSuchElementException e) {
                    // Skip if not found
                }
            }

            if (!clicked) {
                throw new RuntimeException("No recipient element found from the provided list.");
            }
        }

        public void warningContinue() throws InterruptedException {
            warningContinue.click();
            Thread.sleep(1000);
        }

        //        public void selectSourceOfFunds() throws InterruptedException{
//            selectSourceOfFunds.click();
//            Thread.sleep(1000);
//            TakeSnap.captureScreenshot();
//        }
        public void selectSourceOfFunds(String source) throws InterruptedException {
            // Click the dropdown or field to open Source of Funds options
            selectSourceOfFunds.click();
            Thread.sleep(1000);
            TakeSnap.captureScreenshot();

            // Select the appropriate source based on the given input
            switch (source.toLowerCase()) {
                case "salary or wages":
                    salaryOrWages.click();
                    break;
                case "student loan":
                    studentLoan.click();
                    break;
                case "investments":
                    investments.click();
                    break;
                case "personal savings":
                    personalSavings.click();
                    break;
                case "personal wealth":
                    personalWealth.click();
                    break;
                case "retirement funds":
                    retirementFunds.click();
                    break;
                case "business owner/ share holder":
                case "business owner/share holder":
                    businessOwnerOrShareHolder.click();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid source of funds: " + source);
            }

            TakeSnap.captureScreenshot();
            Thread.sleep(1000);
        }


        public void proceedToPayment() throws InterruptedException {
            proceedtoPayment.click();
            Thread.sleep(1000);
        }

        public void completePayment() throws InterruptedException {
            TakeSnap.captureScreenshot();
            completePayment.click();
            Thread.sleep(1000);
        }

        public void selectPaymentMethod(String method) throws InterruptedException {
            TakeSnap.captureScreenshot();
            switch (method.toLowerCase()) {
                case "upi":
                    paymentUPI.click();
                    break;
                case "netBanking":
                    paymentNetbanking.click();
                    break;
                case "transfer via neft":
                case "neft": // supporting both full and short form
                    paymentNEFT.click();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid payment method: " + method);
            }
            TakeSnap.captureScreenshot(); // Optional: capture screen for log/debug
            Thread.sleep(1000); // Consider replacing with WebDriverWait for better stability
        }


        public void addNewBank() throws InterruptedException {
            addNewBank.click();
            Thread.sleep(1000);
        }

        public void addNewRecipient() throws InterruptedException {
            Thread.sleep(100);
            TakeSnap.captureScreenshot();
            addNewRecipient.click();

        }

        public void clickRelationshipsType() throws InterruptedException {
            clickRelationshipsType.click();
            Thread.sleep(1000);
        }

        public void clickSelectCurrency() throws InterruptedException {
            selectCurrency.click();
            Thread.sleep(1000);
        }


        public void recipientName(String name) throws Exception {
            recipientName.sendKeys(name);
        }

        public void recipientAddress(String name) throws Exception {
            recipientAddress.sendKeys(name);
        }

        public void selectRelationshipType(String relation) {
            String xpath = "//android.widget.TextView[@text='" + relation + "']";
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement relationElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            relationElement.click();
        }
//        selectRelationshipType("Daughter");
//        selectRelationshipType("Brother");
//        selectRelationshipType("Son");

        public void selectRecipientType(String recipientType) throws InterruptedException {
            switch (recipientType.toLowerCase()) {
                case "individual":
                    selectRecipientType1.click();
                    break;
                case "institution":
                    selectRecipientType2.click();
                    break;
                case "flywire":
                    selectRecipientType3.click();
                    break;
                case "gic":
                    selectRecipientType4.click();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid recipient type: " + recipientType);
            }
            TakeSnap.captureScreenshot();
            Thread.sleep(1000); // Add waits as needed, better to use WebDriverWait instead
        }

        public void validateTheTCSInCalculationsSectionBeforeSelectingThePurposeCode() {
            String youSendAmount = comFun.removeDelimiter(inrCurrencyTextbox.getText());
            String tcsAmount = comFun.removeDelimiter(checkTcsAmount.getText());

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            double expectedTcsValue = comFun.twoDecimalValues((Double.parseDouble(youSendAmount) - 1000000) * 5) / 100;
            if (Double.parseDouble(youSendAmount) > 700000) {
                if ((String.valueOf(expectedTcsValue)).contains(tcsAmount)) {
                    test.get().log(Status.PASS, "Successful Validation Message: TCS Value is calculated as Expected before selecting Purpose Code: " + tcsAmount);
                } else {
                    test.get().log(Status.FAIL, "TCS Value is not calculated as Expected before selecting Purpose Code: " + tcsAmount);
                }
            } else {
                test.get().log(Status.PASS, "Successful Validation Message: TCS Value will be remain 0 till 700000 amount");
            }
            TakeSnap.captureScreenshot();
        }

        public void checkTheyForeignCurrencyAmountTextbox() throws InterruptedException {
            Thread.sleep(3000);
            String amountToSend = enterAmountToSend.getText();


            String exchangeRate = validateExchangeRate.getText();
            double value = extractCurrencyValue(exchangeRate);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfAllElements(foreignCurrencyTextbox));

            String textInsideCheckAmountTheyReceive = foreignCurrencyTextbox.getText();


            if (textInsideCheckAmountTheyReceive.isEmpty()) {
                System.out.println("They Receive text-box didn't get updated automatically");
            } else {
                System.out.println("Successful Validation Message: They Receive text-box got updated successfully");
            }
            Thread.sleep(2000);

            double theyReceiveAmount = twoDecimalValues((Double.parseDouble(amountToSend)) / Double.parseDouble(String.valueOf(value)));
            Assert.assertEquals(String.valueOf(theyReceiveAmount), textInsideCheckAmountTheyReceive);
            System.out.println("Successful validation message: " + textInsideCheckAmountTheyReceive);
        }

        public void eSignAutomation() {
            // 1. Locate the Signature Pad
            WebElement signaturePad = driver.findElement(By.id("your_signature_pad_id")); // Replace with real ID

            // Get the coordinates of the signature pad
            int startX = signaturePad.getLocation().getX() + 10;
            int startY = signaturePad.getLocation().getY() + 10;
            int endX = startX + 200;
            int endY = startY + 100;

            // 2. Draw the Signature
            TouchAction action = new TouchAction((PerformsTouchActions) driver);
            action.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                    .moveTo(PointOption.point(endX, startY))
                    .moveTo(PointOption.point(endX - 100, endY))
                    .moveTo(PointOption.point(startX, endY - 20))
                    .release()
                    .perform();

            test.get().log(Status.PASS, "Signature drawn successfully.");
            TakeSnap.captureScreenshot();

            // 3. Click Submit Button
            WebElement submitButton = driver.findElement(By.id("your_submit_button_id")); // Replace with real ID
            submitButton.click();
            test.get().log(Status.PASS, "Submit button clicked.");
            TakeSnap.captureScreenshot();
        }

        public void validateTotalFeesDynamically() {
            try {
                // Clean and parse UI values
                double bank = Double.parseDouble(bankFeesText.getText().replace("INR", "").replace(",", "").trim());
                double convenience = Double.parseDouble(convenienceFeesText.getText().replace("INR", "").replace(",", "").trim());
                double gstAmount = Double.parseDouble(gstText.getText().replace("INR", "").replace(",", "").trim());
                double tcs = 0.0; // Default TCS
                boolean isTcsPresent = false;

                // Check if TCS is displayed
                try {
                    if (tcsTaxText.isDisplayed()) {
                        tcs = Double.parseDouble(tcsTaxText.getText().replace("INR", "").replace(",", "").trim());
                        isTcsPresent = true;
                    }
                } catch (NoSuchElementException | NullPointerException e) {
                    test.get().log(Status.INFO, "TCS not displayed. Skipping TCS validation.");
                }

                double expectedTotal = Double.parseDouble(totalFeesText.getText().replace("INR", "").replace(",", "").trim());

                // Log values to report
                test.get().log(Status.INFO, "Bank Fee validated successfully : " + bank);
                test.get().log(Status.INFO, "Convenience Fee validated successfully : " + convenience);
                test.get().log(Status.INFO, "GST Amount: " + gstAmount);
                if (isTcsPresent) {
                    test.get().log(Status.INFO, "TCS Amount: " + tcs);
                }
                test.get().log(Status.INFO, "Expected Total from UI: " + expectedTotal);

                // Calculate total
                double calculatedTotal = bank + convenience + gstAmount + (isTcsPresent ? tcs : 0.0);
                test.get().log(Status.INFO, "Calculated Total: " + calculatedTotal);

                // Final assertion
                Assert.assertEquals(calculatedTotal, expectedTotal, 0.05, "Total fee mismatch!");
                test.get().log(Status.PASS, "Total fees validated successfully");

            } catch (Exception e) {
                test.get().log(Status.FAIL, "Error in total fee validation: " + e.getMessage());
            } finally {
                TakeSnap.captureScreenshot();
            }
        }


        //            // Clean and parse individual values from UI
//            double bank = Double.parseDouble(bankFeesText.getText().replace("INR", "").replace(",", "").trim());
//            double convenience = Double.parseDouble(convenienceFeesText.getText().replace("INR", "").replace(",", "").trim());
//            double gstAmount = Double.parseDouble(gstText.getText().replace("INR", "").replace(",", "").trim());
//            double tcs = Double.parseDouble(tcsTaxText.getText().replace("INR", "").replace(",", "").trim());
//            double expectedTotal = Double.parseDouble(totalFeesText.getText().replace("INR", "").replace(",", "").trim());
//
//            // Print individual values
//            System.out.println("Bank Fees: " + bank);
//            System.out.println("Convenience Fees: " + convenience);
//            System.out.println("GST Amount: " + gstAmount);
//            System.out.println("TCS Tax: " + tcs);
//            System.out.println("Expected Total Fees: " + expectedTotal);
//            // Sum all parts
//            double calculatedTotal = bank + convenience + gstAmount + tcs;
//
//            // Debug log
//            System.out.println("Calculated Total: " + calculatedTotal);
//            System.out.println("Displayed Total: " + expectedTotal);
//
//            // Assert with tolerance for rounding
//            Assert.assertEquals(calculatedTotal, expectedTotal, 0.05, "Total fee mismatch!");
//            TakeSnap.captureScreenshot();
//        }
        public void validateBankDetailsAndClickContinue() {
            if (bankDetailsText.isDisplayed() && bankDetailsText.getText().equals("Bank Details")) {
                System.out.println("Bank Details text is displayed correctly.");
            } else {
                throw new AssertionError("Bank Details text is not displayed or incorrect.");
            }

            // Click on the "Continue" button
            continueButton.click();
            System.out.println("Clicked on Continue button.");
        }

        public void enterAccountDetailsAndClickVerify(String upi, String AccountNumber, String ifscCode) {
            // Enter Account Number
            TakeSnap.captureScreenshot();
            accountUPIField.sendKeys(upi);
            // Confirm Account Number
            ifscCodeField.sendKeys(ifscCode);
            // Enter IFSC Code
            AccountNumberField.sendKeys(AccountNumber);
            // Click on Verify button
            verifyButton.click();
        }

        public void transactionScreen() {
            Assert.assertTrue(transactionScreen.isDisplayed());
            test.get().log(Status.PASS, "Label: '" + transactionScreen.getText() + "' is displayed correctly");
        }

        public void enterRecipientDetailsAndContinue(String nameRecipient, String addNewRecipient, String pinCode, String city, String state, String country, String phone, String email) throws InterruptedException {
            // Fill all fields
            recipientName.sendKeys(nameRecipient);
            recipientAddress.sendKeys(addNewRecipient);
            pinCodeField.sendKeys(pinCode);
            cityField.sendKeys(city);
            stateField.sendKeys(state);
            countryField.sendKeys(country);
            phoneField.sendKeys(phone);
            emailField.sendKeys(email);

            // Hide keyboard
            driver.network();

            // Take screenshot
            TakeSnap.captureScreenshot();

            // Click Continue
            continueButton.click();
        }

        public void enterRecipientBankDetailsAndContinue(String swiftIban, String accountNumber, String confirmAccountNumber) throws InterruptedException {
            swiftIbanField.sendKeys(swiftIban);
            // Click Verify
            accVerifyButton.click();
            Thread.sleep(1000); // Optional wait after verification

            bankAccountField.sendKeys(accountNumber);
            confirmBankAccountField.sendKeys(confirmAccountNumber);

            // Optionally hide keyboard
            driver.network();

            // Take screenshot (if needed)
            TakeSnap.captureScreenshot();

            // Click Continue
            nextContinueButton.click();
        }

        public void applyCouponCode(String couponCode) {
            // Locate the Coupon Code field and enter the value
            WebElement couponCodeField = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='ConfirmScreen_Coupon_Code_Value']"));
            couponCodeField.clear();
            couponCodeField.sendKeys(couponCode);

            // Optional: Hide keyboard if visible
            try {
                driver.network();
            } catch (Exception e) {
                // Keyboard not open — ignore
            }

            // Locate and click the Apply button
            WebElement applyButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Apply']"));
            applyButton.click();

            // Optional: wait or screenshot
            TakeSnap.captureScreenshot();
        }

        public void redeemHopCoins(String couponCode) {
            // Step 1: Click "Redeem Hop Coins"
            WebElement redeemHopCoinsButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Redeem Hop Coins']"));
            redeemHopCoinsButton.click();

            // Step 2: Enter value in the coupon code input field
            WebElement couponCodeField = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='ConfirmScreen_Coupon_Code_Value']"));
            couponCodeField.clear();
            couponCodeField.sendKeys(couponCode);

            // Optional: Hide keyboard
            try {
                driver.network();
            } catch (Exception e) {
                // Ignore if keyboard is already hidden
            }

            // Step 3: Click the "Redeem" button
            WebElement redeemButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Redeem']"));
            redeemButton.click();

            // Optional: Screenshot or wait
            TakeSnap.captureScreenshot();
        }

        public void toggleSwitch() {
            WebElement toggleSwitch = driver.findElement(By.xpath("//android.widget.Switch"));
            toggleSwitch.click();  // Toggles the switch
        }

        public void validateGstAndTcs_ForFinalAmount() {
            // 1. Total Pay and Fees (get dynamically in real test using XPaths)
            double totalPay = 100000;
            double totalFees = 4000;

            // 2. Final amount to validate against
            double finalAmount = totalPay - totalFees;
            System.out.println("Final amount after fees: ₹" + finalAmount);

            // 3. Calculate Expected GST
            double expectedGst = calculateGst(finalAmount);
            System.out.println("Expected GST: ₹" + expectedGst);

            // 4. Calculate Expected TCS
            double expectedTcs = calculateTcsO(finalAmount);
            System.out.println("Expected TCS: ₹" + expectedTcs);

            // 5. (Replace with actual XPath to fetch these from app)
            String gstText = driver.findElement(By.xpath("//android.widget.TextView[@text=\"GST\"]/following-sibling::android.widget.TextView[1]\n")).getText();
            String tcsText = driver.findElement(By.xpath("//android.widget.TextView[contains(@text, \"TCS\")]/following-sibling::android.widget.TextView[1]\n")).getText();

            double actualGst = Double.parseDouble(gstText.replaceAll("[^\\d.]", ""));
            double actualTcs = Double.parseDouble(tcsText.replaceAll("[^\\d.]", ""));

            // 6. Validate (allow small difference tolerance)
            Assert.assertEquals(actualGst, expectedGst, 0.5, "GST mismatch!");
            Assert.assertEquals(actualTcs, expectedTcs, 0.5, "TCS mismatch!");

            System.out.println(" GST & TCS validation passed.");
        }

        public double calculateGst(double amount) {
            if (amount <= 25000) {
                return 250.0; // 1% of 25000
            } else if (amount <= 100000) {
                return amount * 0.01; // 1% flat
            } else if (amount <= 1000000) {
                return 1000 + 0.005 * (amount - 100000); // 0.5% after 1L
            } else {
                return 5500 + 0.001 * (amount - 1000000); // 0.1% after 10L
            }

        }

        public double calculateTcsO(double amount) {
            return amount * 0.05;
        }

        public void validateTCSOnly() {
            // 1. Get Total Pay from UI
            String totalPayText = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"HomeScreen_Exchange_Input1_Value\"]")).getText();
            double totalPay = Double.parseDouble(totalPayText.replaceAll("[^\\d.]", ""));

            // 2. Get Total Fees from UI
            String totalFeesText = driver.findElement(By.xpath("//android.widget.TextView[@text='Total Fees']/following-sibling::android.widget.TextView")).getText();
            double totalFees = Double.parseDouble(totalFeesText.replaceAll("[^\\d.]", ""));

            // 3. Calculate Final Amount
            double finalAmount = totalPay - totalFees;
            System.out.println("Final Amount: " + finalAmount);

            // 4. Calculate expected TCS (5%)
            double expectedTcs = calculateTcs(finalAmount);
            System.out.println("Expected TCS: ₹" + expectedTcs);

            // 5. Get TCS from UI
            String tcsText = driver.findElement(By.xpath("//android.widget.TextView[contains(@text, \"TCS\")]/following-sibling::android.widget.TextView[1]\n")).getText();
            double actualTcs = Double.parseDouble(tcsText.replaceAll("[^\\d.]", ""));

            // 6. Validate TCS with small tolerance
            Assert.assertEquals(actualTcs, expectedTcs, 0.5, "TCS mismatch!");
        }

        // TCS Calculator
        public double calculateTcs(double amount) {
            return amount * 0.05;
        }

        public void validateAd2BankAndConvenienceFee() {
            try {
                TakeSnap.captureScreenshot();
                // Step 1: Get the entered amount and fees from UI
                String youSendAmountText = comFun.removeDelimiter(inrCurrencyTextbox.getText());
                String bankFeeText = bankFerFeeAmount.getText(); // e.g., "1,250 INR"
                String conFeeText = convenienceFeeAmount.getText(); // e.g., "350 INR"

                double youSendAmount = Double.parseDouble(youSendAmountText);
                double actualBankFee = Double.parseDouble(cleanFeeText(bankFeeText));
                double actualConFee = Double.parseDouble(cleanFeeText(conFeeText));

                // Step 2: Calculate expected Bank Fee
                double expectedBankFee = 0;
                if (youSendAmount <= 79999) {
                    expectedBankFee = 750;
                } else if (youSendAmount <= 199999) {
                    expectedBankFee = 1000;
                } else if (youSendAmount <= 399999) {
                    expectedBankFee = 1250;
                } else if (youSendAmount <= 599999) {
                    expectedBankFee = 1500;
                } else if (youSendAmount <= 999999) {
                    expectedBankFee = 1500;
                } else if (youSendAmount <= 3000000) {
                    expectedBankFee = 1500;
                }

                // Step 3: Calculate expected Convenience Fee
                double expectedConFee = 0;
                if (youSendAmount <= 79999) {
                    expectedConFee = 0;
                } else if (youSendAmount <= 199999) {
                    expectedConFee = 250;
                } else if (youSendAmount <= 399999) {
                    expectedConFee = 350;
                } else if (youSendAmount <= 599999) {
                    expectedConFee = 750;
                } else if (youSendAmount <= 999999) {
                    expectedConFee = 1000;
                } else if (youSendAmount <= 3000000) {
                    expectedConFee = 1250;
                }
                TakeSnap.captureScreenshot();
                // Step 4: Validate both fees
                if (Math.abs(actualBankFee - expectedBankFee) <= 0.5) {
                    test.get().log(Status.PASS, "Bank Fee validated successfully AD2: " + actualBankFee);
                } else {
                    test.get().log(Status.FAIL, "Bank Fee mismatch. Expected: " + expectedBankFee + ", Actual: " + actualBankFee);
                }

                if (Math.abs(actualConFee - expectedConFee) <= 0.5) {
                    test.get().log(Status.PASS, "Convenience Fee validated successfully AD2: " + actualConFee);
                } else {
                    test.get().log(Status.FAIL, "Convenience Fee mismatch. Expected: " + expectedConFee + ", Actual: " + actualConFee);
                }

                // Step 5: Capture screenshot
                TakeSnap.captureScreenshot();
            } catch (Exception e) {
                test.get().log(Status.FAIL, "Error while validating fees: " + e.getMessage());
                TakeSnap.captureScreenshot();
            }
        }

        // Utility Method to clean text like "1,250 INR" => "1250"
        public String cleanFeeText(String text) {
            return text.replaceAll("[^\\d.]", "");
        }

        public void validateAd1BankAndConvenienceFee() {
            try {
                TakeSnap.captureScreenshot();
                // Step 1: Get entered amount and fees from UI
                String youSendAmountText = comFun.removeDelimiter(inrCurrencyTextbox.getText());
                String bankFeeText = comFun.removeDelimiter(bankFerFeeAmount.getText());
                String conFeeText = comFun.removeDelimiter(convenienceFeeAmount.getText());

                double youSendAmount = Double.parseDouble(youSendAmountText.replaceAll("[^\\d.]", ""));
                double actualBankFee = Double.parseDouble(bankFeeText.replaceAll("[^\\d.]", ""));
                double actualConFee = Double.parseDouble(conFeeText.replaceAll("[^\\d.]", ""));

                // Step 2: Define expected values for AD1
                double expectedBankFee = 590.0;
                double expectedConFee = 0.0;

                // Step 3: Validate Bank Fee
                if (Math.abs(actualBankFee - expectedBankFee) <= 0.5) {
                    test.get().log(Status.PASS, "Bank Fee validated successfully for AD1: " + actualBankFee);
                } else {
                    test.get().log(Status.FAIL, "Bank Fee mismatch for AD1. Expected: " + expectedBankFee + ", Actual: " + actualBankFee);
                }

                // Step 4: Validate Convenience Fee
                if (Math.abs(actualConFee - expectedConFee) <= 0.5) {
                    test.get().log(Status.PASS, "Convenience Fee validated successfully for AD1: " + actualConFee);
                } else {
                    test.get().log(Status.FAIL, "Convenience Fee mismatch for AD1. Expected: " + expectedConFee + ", Actual: " + actualConFee);
                }

                // Step 5: Capture screenshot
                TakeSnap.captureScreenshot();

            } catch (Exception e) {
                test.get().log(Status.FAIL, "Error while validating AD1 Fees: " + e.getMessage());
                TakeSnap.captureScreenshot();
            }
        }

        public void validateIBRChangesOnTargetCurrencySelection(String fullCurrencyName, String expectedCurrencyCode) throws InterruptedException {
            // Step 1: Capture Initial IBR
            TakeSnap.captureScreenshot();
            String initialIBR = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'1') and contains(@text,'INR')]")).getText();
            test.get().log(Status.INFO, " Initial IBR Rate: " + initialIBR);

            // Step 2: Select target currency
            test.get().log(Status.INFO, " Selecting Currency: " + fullCurrencyName);
            selectCurrency.click();

            TakeSnap.captureScreenshot();
            String xpath = "//android.widget.TextView[contains(@text,'" + fullCurrencyName + "')]";

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement currencyOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            currencyOption.click();

            // Step 3: Wait for IBR to update
            Thread.sleep(2000); // Replace with WebDriverWait for production

            // Step 4: Capture Updated IBR
            String updatedIBR = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'1') and contains(@text,'INR')]")).getText();
            test.get().log(Status.INFO, " Updated IBR Rate: " + updatedIBR);

            // Step 5: Log expected vs actual
            test.get().log(Status.INFO, " Expected Currency Code: " + expectedCurrencyCode);

            // Step 6: Assertion with logging
            if (updatedIBR.contains("1 " + expectedCurrencyCode)) {
                test.get().log(Status.PASS, " IBR updated correctly for selected currency: " + expectedCurrencyCode);
            } else {
                test.get().log(Status.FAIL, " IBR mismatch. Expected to contain: '1 " + expectedCurrencyCode + "', but found: '" + updatedIBR + "'");
                Assert.fail("IBR not updated for selected currency. Expected: " + expectedCurrencyCode + ", Found: " + updatedIBR);
            }
        }

        public void validateInrToForeignConversionWithTCS() {
            try {
                // Step 1: Fetch actual INR amount shown in UI
                String actualInrText = inrCurrencyTextbox.getText().replace("INR", "").replace(",", "").trim();
                double inrAmount = Double.parseDouble(actualInrText);

                // Step 2: Read total fee from UI
                String feeText = taxAndTransferFee.getText().replace("INR", "").replace(",", "").trim();
                double totalFee = Double.parseDouble(feeText);

                // Step 3: Read IBR from UI (format: "1 USD = 83.45 INR")
                String ibrRateText = ibrRateField.getText();
                double ibr = Double.parseDouble(ibrRateText.split("=")[1].replace("INR", "").trim());

                // Step 4: Read displayed "User Gets" value from UI
                String userGetsText = fcyCurrencyTextbox.getText().replace(",", "").trim();
                double displayedUserGets = Double.parseDouble(userGetsText);

                // Step 5: Read TCS (if present)
                double displayedTCS = 0.0;
                boolean tcsDisplayed = false;

                try {
                    String tcsText = tcsTaxText.getText().replace("INR", "").replace(",", "").trim();
                    displayedTCS = Double.parseDouble(tcsText);
                    tcsDisplayed = true;
                } catch (NoSuchElementException e) {
                    test.get().log(Status.INFO, "TCS not displayed in UI. Skipping TCS validation.");
                }

                // Step 6: Perform Calculations
                double actualAmount = inrAmount - totalFee;
                double expectedUserGets = actualAmount / ibr;
                double expectedTCS = actualAmount * 0.05;

                // Step 7: Log all values
                test.get().log(Status.INFO, "Entered INR Amount: " + inrAmount);
                test.get().log(Status.INFO, "Total Fee: " + totalFee);
                test.get().log(Status.INFO, "Actual Amount (after fee): " + actualAmount);
                test.get().log(Status.INFO, "IBR Rate: " + ibr);
                test.get().log(Status.INFO, "Expected 'User Gets': " + expectedUserGets);
                test.get().log(Status.INFO, "Displayed 'User Gets': " + displayedUserGets);

                if (tcsDisplayed) {
                    test.get().log(Status.INFO, "Expected TCS (5%): " + expectedTCS);
                    test.get().log(Status.INFO, "Displayed TCS: " + displayedTCS);
                }

                // Step 8: Validate User Gets with tolerance
                Assert.assertEquals(displayedUserGets, expectedUserGets, 0.5, "'User Gets' mismatch");

                // Step 9: Validate TCS if present
                if (tcsDisplayed) {
                    Assert.assertEquals(displayedTCS, expectedTCS, 0.5, "TCS mismatch");
                    test.get().log(Status.PASS, "TCS validated successfully: " + displayedTCS);
                }

                test.get().log(Status.PASS, "INR to Foreign Currency Conversion validated successfully.");
            } catch (Exception e) {
                test.get().log(Status.FAIL, "Exception during INR conversion validation: " + e.getMessage());
            } finally {
                TakeSnap.captureScreenshot();
            }

        }

        public void calculateDynamicAmountAfterFee() {
            try {
                    // 1. Get INR Amount with better XPath
                    String inrText = driver.findElement(By.xpath(
                            "//android.widget.TextView[contains(@text,'₹') and string-length(@text) > 2]"
                    )).getText();

                    System.out.println("Raw INR Text: " + inrText);
                    test.get().log(Status.INFO, "Raw INR Text: " + inrText);

                    if (inrText == null || inrText.trim().isEmpty()) {
                        test.get().log(Status.FAIL, "INR amount text not found or empty.");
                        return;
                    }

                    String inrClean = inrText.replaceAll("[^\\d.]", "").trim();
                    if (inrClean.isEmpty()) {
                        test.get().log(Status.FAIL, "INR amount is empty after cleanup: " + inrText);
                        return;
                    }

                    double inrValue = Double.parseDouble(inrClean);

                    // 2. Get Total Fees from content-desc
                    String feeText = driver.findElement(By.xpath(
                            "//android.view.ViewGroup[contains(@content-desc,'Total fees')]"
                    )).getAttribute("content-desc");

                    System.out.println("Raw Fee Text: " + feeText);
                    test.get().log(Status.INFO, "Raw Fee Text: " + feeText);

                    if (feeText == null || feeText.trim().isEmpty()) {
                        test.get().log(Status.FAIL, "Total fees content-desc is empty or not found.");
                        return;
                    }

                    String[] feeParts = feeText.split(",");
                    if (feeParts.length < 2) {
                        test.get().log(Status.FAIL, "Unexpected fee format: " + feeText);
                        return;
                    }

                    String feeClean = feeParts[1].replaceAll("[^\\d.]", "").trim();
                    if (feeClean.isEmpty()) {
                        test.get().log(Status.FAIL, "Fee amount is empty after cleanup: " + feeText);
                        return;
                    }

                    double feeValue = Double.parseDouble(feeClean);

                    // 3. Calculate Net Amount
                    double netAmount = inrValue - feeValue;

                    // 4. Print and Log Results
                    System.out.println("INR Amount: " + inrValue);
                    System.out.println("Total Fee: " + feeValue);
                    System.out.println("Amount after Fee: " + netAmount);

                    test.get().log(Status.INFO, "INR Amount: ₹" + inrValue);
                    test.get().log(Status.INFO, "Total Fee: ₹" + feeValue);
                    test.get().log(Status.PASS, "Amount after Fee: ₹" + netAmount);

                } catch (Exception e) {
                    test.get().log(Status.FAIL, "Exception occurred during calculation: " + e.getMessage());
                    e.printStackTrace();
                }
            }

            public void validateNetAmountAndTCS() {
            // 1. Get INR Amount
            String inrText = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'₹')]")).getText();
            String inrClean = inrText.replaceAll("[^\\d.]", "");
            double inrValue = Double.parseDouble(inrClean);

            // 2. Get Total Fees
            String feeText = driver.findElement(By.xpath("//android.view.ViewGroup[contains(@content-desc,'Total fees')]"))
                    .getAttribute("content-desc");
            String feeClean = feeText.split(",")[1].replaceAll("[^\\d.]", "");
            double feeValue = Double.parseDouble(feeClean);

            // 3. Calculate Net Amount
            double netAmount = inrValue - feeValue;

            // 4. Get TCS from UI
            String tcsText = driver.findElement(By.xpath("//android.widget.TextView[contains(@text, \"TCS\")]/following-sibling::android.widget.TextView[1]\n"))
                    .getAttribute("content-desc");
            String tcsClean = tcsText.split(",")[1].replaceAll("[^\\d.]", "");
            double tcsValueFromUI = Double.parseDouble(tcsClean);

            // 5. Calculate Expected TCS (e.g., 5% of Net Amount)
            double expectedTcs = (netAmount * 5) / 100.0;

            // 6. Round both to 2 decimal places
            expectedTcs = Math.round(expectedTcs * 100.0) / 100.0;
            tcsValueFromUI = Math.round(tcsValueFromUI * 100.0) / 100.0;

            // 7. Log values
            test.get().log(Status.INFO, "INR Amount: ₹" + inrValue);
            test.get().log(Status.INFO, "Total Fee: ₹" + feeValue);
            test.get().log(Status.INFO, "Net Amount: ₹" + netAmount);
            test.get().log(Status.INFO, "Expected TCS (5%): ₹" + expectedTcs);
            test.get().log(Status.INFO, "Actual TCS from UI: ₹" + tcsValueFromUI);

            // 8. Validation
            if (expectedTcs == tcsValueFromUI) {
                test.get().log(Status.PASS, "TCS is correctly applied.");
            } else {
                test.get().log(Status.FAIL, "TCS mismatch! Expected: ₹" + expectedTcs + ", but found: ₹" + tcsValueFromUI);
            }
        }



    }



