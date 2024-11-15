package Pages;

import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utils.*;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;

import static Utils.AndroidUtils.*;
import static extentReport.ExtentReportManager.test;

    public class SendMoneyPage  {
        private final AppiumDriver driver;
        ExcelSetup ex = new ExcelSetup();
        CommonFunctions comFun = new CommonFunctions();


        public SendMoneyPage(AppiumDriver driver) {
            this.driver = driver;
            PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
        }

        @AndroidFindBy(xpath = "//android.widget.EditText[@text='10,000']")
        private WebElement presetInrCurrencyTextbox;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"₹\"]/following-sibling::android.widget.EditText[1]")
        private WebElement inrCurrencyTextbox;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='INR Amount should be greater than or equal to 5000']")
        private WebElement minAmountErrorMessage;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='The maximum you can send in one transaction is 20,00,000 INR']")
        private WebElement maxAmountErrorMessage;
        @AndroidFindBy(accessibility = "Send Money")
        private WebElement sendMoneyButton;
        @AndroidFindBy(className = "android.widget.EditText")
        private WebElement searchBar;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select Currency']")
        private WebElement selectCurrencyLabel;
        @AndroidFindBy(xpath = "//android.widget.EditText[@text='Type a currency']")
        private WebElement placeholderTypeCurrency;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='All currencies']")
        private WebElement allCurrencies;
        @AndroidFindBy(accessibility = "EUR, Euro")
        private WebElement euroCurrency;
        @AndroidFindBy(accessibility = "GBP, British Pound Sterling")
        private WebElement gbpCurrency;
        @AndroidFindBy(accessibility = "USD, United States Dollar")
        private WebElement usdCurrency;
        @AndroidFindBy(accessibility = "AUD, Australian Dollar")
        private WebElement audCurrency;
        @AndroidFindBy(accessibility = "CAD, Canadian Dollar")
        private WebElement cadCurrency;
        @AndroidFindBy(accessibility = "SGD, Singapore Dollar")
        private WebElement sgdCurrency;
        @AndroidFindBy(accessibility = "JPY, Japanese Yen")
        private WebElement jpyCurrency;
        @AndroidFindBy(accessibility = "AED, United Arab Emirates Dirham")
        private WebElement aedCurrency;
        @AndroidFindBy(accessibility = "NZD, New Zealand Dollar")
        private WebElement nzdCurrency;
        @AndroidFindBy(accessibility = "CHF, Swiss Franc")
        private WebElement chfCurrency;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Tax and transfer fee']")
        private WebElement taxAndTransferFee;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Transfer fee']/preceding-sibling::android.widget.TextView[1]\n")
        private WebElement transferFeeAmount;
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


        public void sendMoneyLabel() {
            Assert.assertTrue(sendMoneyLabel.isDisplayed());
            test.get().log(Status.PASS, "Label: '" + sendMoneyLabel.getText() + "' is displayed correctly");
        }

        public void validatePresetAmount() {
            Assert.assertTrue(presetInrCurrencyTextbox.isDisplayed());
            test.get().log(Status.PASS, "Label: '" + presetInrCurrencyTextbox.getText() + "' is displayed correctly");
        }

        public void inrCurrencyTextBox(String Amount) {
            inrCurrencyTextbox.clear();
            inrCurrencyTextbox.sendKeys(Amount);
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

            String currencyFlagXpath = String.format("//android.view.ViewGroup[@content-desc='%s']/android.view.ViewGroup/android.widget.ImageView", currencyFlag);
            return driver.findElement(By.xpath(currencyFlagXpath));
        }

        public WebElement getCurrencySymbol(String currencySymbol) {
            String currencySymbolXpath = String.format("//android.widget.TextView[@text='%s']", currencySymbol);
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
            selectForeignCurrency("USD");

            comFun.wait(selectCurrencyLabel);
            Assert.assertTrue(selectCurrencyLabel.isDisplayed());
            test.get().log(Status.PASS, "Label: '" + selectCurrencyLabel.getText() + "' is displayed correctly");

            Assert.assertTrue(placeholderTypeCurrency.isDisplayed());
            test.get().log(Status.PASS, "Label: '" + placeholderTypeCurrency.getText() + "' is displayed correctly");

            Assert.assertTrue(allCurrencies.isDisplayed());
            test.get().log(Status.PASS, "Label: '" + allCurrencies.getText() + "' is displayed correctly");
            TakeSnap.captureScreenshot();

            searchBarTxt("Euro");
            TakeSnap.captureScreenshot();
            searchBar.clear();
            if (getForeignCurrencyFlag("EUR, Euro").isDisplayed() & euroCurrency.isDisplayed()) {
                euroCurrency.click();
                comFun.wait(sendMoneyLabel);
                Assert.assertTrue(getCurrencyCode("EUR").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Code: " + getCurrencyCode("EUR").getText() + "' is displayed correctly");

                Assert.assertTrue(getCurrencyFlag("EUR").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Flag' is displayed correctly");

                Assert.assertTrue(getCurrencySymbol("€").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Symbol: " + getCurrencySymbol("€").getText() + "' is displayed correctly");
            }
            TakeSnap.captureScreenshot();

            selectForeignCurrency("EUR");
            comFun.wait(selectCurrencyLabel);
            searchBarTxt("GBP");
            TakeSnap.captureScreenshot();
            searchBar.clear();
            if (getForeignCurrencyFlag("GBP, British Pound Sterling").isDisplayed() & gbpCurrency.isDisplayed()) {
                gbpCurrency.click();
                comFun.wait(sendMoneyLabel);
                Assert.assertTrue(getCurrencyCode("GBP").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Code: " + getCurrencyCode("GBP").getText() + "' is displayed correctly");

                Assert.assertTrue(getCurrencyFlag("GBP").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Flag' is displayed correctly");

                Assert.assertTrue(getCurrencySymbol("£").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Symbol: " + getCurrencySymbol("£").getText() + "' is displayed correctly");
            }
            TakeSnap.captureScreenshot();
            selectForeignCurrency("GBP");
            comFun.wait(selectCurrencyLabel);
            searchBarTxt("USD");
            TakeSnap.captureScreenshot();
            searchBar.clear();
            if (getForeignCurrencyFlag("USD, United States Dollar").isDisplayed() & gbpCurrency.isDisplayed()) {
                usdCurrency.click();
                comFun.wait(sendMoneyLabel);
                Assert.assertTrue(getCurrencyCode("USD").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Code: " + getCurrencyCode("USD").getText() + "' is displayed correctly");

                Assert.assertTrue(getCurrencyFlag("USD").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Flag' is displayed correctly");

                Assert.assertTrue(getCurrencySymbol("$").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Symbol: " + getCurrencySymbol("$").getText() + "' is displayed correctly");
            }
            TakeSnap.captureScreenshot();
            selectForeignCurrency("USD");
            comFun.wait(selectCurrencyLabel);
            searchBarTxt("AUD");
            TakeSnap.captureScreenshot();
            searchBar.clear();
            if (getForeignCurrencyFlag("AUD, Australian Dollar").isDisplayed() & gbpCurrency.isDisplayed()) {
                audCurrency.click();
                comFun.wait(sendMoneyLabel);
                Assert.assertTrue(getCurrencyCode("AUD").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Code: " + getCurrencyCode("AUD").getText() + "' is displayed correctly");

                Assert.assertTrue(getCurrencyFlag("AUD").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Flag' is displayed correctly");

                Assert.assertTrue(getCurrencySymbol("$").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Symbol: " + getCurrencySymbol("$").getText() + "' is displayed correctly");
            }
            TakeSnap.captureScreenshot();
            selectForeignCurrency("AUD");
            comFun.wait(selectCurrencyLabel);
            searchBarTxt("CAD");
            TakeSnap.captureScreenshot();
            searchBar.clear();
            if (getForeignCurrencyFlag("CAD, Canadian Dollar").isDisplayed() & gbpCurrency.isDisplayed()) {
                cadCurrency.click();
                comFun.wait(sendMoneyLabel);
                Assert.assertTrue(getCurrencyCode("CAD").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Code: " + getCurrencyCode("CAD").getText() + "' is displayed correctly");

                Assert.assertTrue(getCurrencyFlag("CAD").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Flag' is displayed correctly");

                Assert.assertTrue(getCurrencySymbol("$").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Symbol: " + getCurrencySymbol("$").getText() + "' is displayed correctly");
            }
            TakeSnap.captureScreenshot();
            selectForeignCurrency("CAD");
            comFun.wait(selectCurrencyLabel);
            searchBarTxt("SGD");
            TakeSnap.captureScreenshot();
            searchBar.clear();
            if (getForeignCurrencyFlag("SGD, Singapore Dollar").isDisplayed() & gbpCurrency.isDisplayed()) {
                sgdCurrency.click();
                comFun.wait(sendMoneyLabel);
                Assert.assertTrue(getCurrencyCode("SGD").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Code: " + getCurrencyCode("SGD").getText() + "' is displayed correctly");

                Assert.assertTrue(getCurrencyFlag("SGD").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Flag' is displayed correctly");

                Assert.assertTrue(getCurrencySymbol("$").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Symbol: " + getCurrencySymbol("$").getText() + "' is displayed correctly");
            }
            TakeSnap.captureScreenshot();
            selectForeignCurrency("SGD");
            comFun.wait(selectCurrencyLabel);
            searchBarTxt("JPY");
            TakeSnap.captureScreenshot();
            searchBar.clear();
            if (getForeignCurrencyFlag("JPY, Japanese Yen").isDisplayed() & gbpCurrency.isDisplayed()) {
                jpyCurrency.click();
                comFun.wait(sendMoneyLabel);
                Assert.assertTrue(getCurrencyCode("JPY").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Code: " + getCurrencyCode("JPY").getText() + "' is displayed correctly");

                Assert.assertTrue(getCurrencyFlag("JPY").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Flag' is displayed correctly");

                Assert.assertTrue(getCurrencySymbol("¥").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Symbol: " + getCurrencySymbol("¥").getText() + "' is displayed correctly");
            }
            TakeSnap.captureScreenshot();
            selectForeignCurrency("JPY");
            comFun.wait(selectCurrencyLabel);

            searchBarTxt("NZD");
            TakeSnap.captureScreenshot();
            searchBar.clear();
            if (getForeignCurrencyFlag("NZD, New Zealand Dollar").isDisplayed() & gbpCurrency.isDisplayed()) {
                nzdCurrency.click();
                comFun.wait(sendMoneyLabel);
                Assert.assertTrue(getCurrencyCode("NZD").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Code: " + getCurrencyCode("NZD").getText() + "' is displayed correctly");

                Assert.assertTrue(getCurrencyFlag("NZD").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Flag' is displayed correctly");

                Assert.assertTrue(getCurrencySymbol("$").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Symbol: " + getCurrencySymbol("$").getText() + "' is displayed correctly");
            }
            TakeSnap.captureScreenshot();
            selectForeignCurrency("NZD");
            comFun.wait(selectCurrencyLabel);
            searchBarTxt("CHF");
            TakeSnap.captureScreenshot();
            searchBar.clear();
            if (getForeignCurrencyFlag("CHF, Swiss Franc").isDisplayed() & gbpCurrency.isDisplayed()) {
                chfCurrency.click();
                comFun.wait(sendMoneyLabel);
                Assert.assertTrue(getCurrencyCode("CHF").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Code: " + getCurrencyCode("CHF").getText() + "' is displayed correctly");

                Assert.assertTrue(getCurrencyFlag("CHF").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Flag' is displayed correctly");

                Assert.assertTrue(getCurrencySymbol("₣").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Symbol: " + getCurrencySymbol("₣").getText() + "' is displayed correctly");
            }
            TakeSnap.captureScreenshot();
            selectForeignCurrency("CHF");
            comFun.wait(selectCurrencyLabel);
            searchBarTxt("AED");
            TakeSnap.captureScreenshot();
            searchBar.clear();
            if (getForeignCurrencyFlag("AED, United Arab Emirates Dirham").isDisplayed() & gbpCurrency.isDisplayed()) {
                aedCurrency.click();
                comFun.wait(sendMoneyLabel);
                Assert.assertTrue(getCurrencyCode("AED").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Code: " + getCurrencyCode("AED").getText() + "' is displayed correctly");

                Assert.assertTrue(getCurrencyFlag("AED").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Flag' is displayed correctly");

                Assert.assertTrue(getCurrencySymbol("AED").isDisplayed());
                test.get().log(Status.PASS, "Success message: 'Foreign Currency Symbol: " + getCurrencySymbol("AED").getText() + "' is displayed correctly");
            }
            TakeSnap.captureScreenshot();
        }

        public void expandTaxAndTransferFee() {
            taxAndTransferFee.click();
        }

        public void validateTransferFee() throws InterruptedException {
            Thread.sleep(2000);
            String youSendAmount = comFun.removeDelimiter(inrCurrencyTextbox.getText());
            String transferFee = comFun.removeDelimiter(transferFeeAmount.getText());

            // Convenience Fees( It will be needed once the Promo code is deployed)
            double conFeeMinAmount = 0;
            double conFeeAmountRange1 = 250;
            double conFeeAmountRange2 = 350;
            double conFeeAmountRange3 = 750;
            double conFeeAmountRange4 = 1000;
            double conFeeAmountRange5 = 1250;


            // Bank Fees
            double bankFeeMinAmount = 750;
            double bankFeeAmountRange1 = 1000;
            double bankFeeAmountRange2 = 1250;
            double bankFeeAmountRange3 = 1500;

            // Bank and Convenience Fees ( It will be needed once the Promo code is deployed)
            double bankAndConvenienceFeeMinAmount = conFeeMinAmount + bankFeeMinAmount;
            double bankAndConvenienceFeeAmountRange1 = conFeeAmountRange1 + bankFeeAmountRange1;
            double bankAndConvenienceFeeAmountRange2 = conFeeAmountRange2 + bankFeeAmountRange2;
            double bankAndConvenienceFeeAmountRange3 = conFeeAmountRange3 + bankFeeAmountRange3;
            double bankAndConvenienceFeeAmountRange4 = conFeeAmountRange4 + bankFeeAmountRange3;
            double bankAndConvenienceFeeAmountRange5 = conFeeAmountRange5 + bankFeeAmountRange3;


            if (Double.parseDouble(youSendAmount) < 80000) {
                if (String.valueOf(bankFeeMinAmount).contains(transferFee)) {
                    test.get().log(Status.PASS, "Successful Validation Message: Amount is less than 80000, so the transfer fee is calculated as Expected: " + transferFee);
                } else {
                    test.get().log(Status.FAIL, "Amount is less than 80000, so the transfer fee is not calculated as Expected: " + transferFee);
                }
            }
            if (Double.parseDouble(youSendAmount) >= 80000 && Double.parseDouble(youSendAmount) < 200000) {
                if (String.valueOf(bankFeeAmountRange1).contains(transferFee)) {
                    test.get().log(Status.PASS, "Successful Validation Message: Amount is in range of 80000 to 200000 so the transfer fee is calculated as Expected: " + transferFee);
                } else {
                    test.get().log(Status.FAIL, "Amount is in range of 80000 to 200000 so the transfer fee is not calculated as Expected: " + transferFee);
                }
            }

            if (Double.parseDouble(youSendAmount) >= 200000 && Double.parseDouble(youSendAmount) < 400000) {
                if (String.valueOf(bankFeeAmountRange2).contains(transferFee)) {
                    test.get().log(Status.PASS, "Successful Validation Message: Amount is in range of 200000 to 400000 so the transfer fee is calculated as Expected: " + transferFee);
                } else {
                    test.get().log(Status.FAIL, "Amount is in range of 200000 to 400000 so the transfer fee is not calculated as Expected: " + transferFee);
                }
            }

            if (Double.parseDouble(youSendAmount) >= 400000) {
                if (String.valueOf(bankFeeAmountRange3).contains(transferFee)) {
                    test.get().log(Status.PASS, "Successful Validation Message: Amount is equal or more than 400000 so the transfer fee is calculated as Expected: " + transferFee);
                } else {
                    test.get().log(Status.FAIL, "Amount is equal or more than 400000 so the transfer fee is not calculated as Expected: " + transferFee);
                }
            }
            TakeSnap.captureScreenshot();
        }


        //  (It will be needed once the Promo code is deployed)
       /* if(Double.parseDouble(youSendAmount)<80000)

        {
            if (String.valueOf(bankAndConvenienceFeeMinAmount).contains(bankAndConvenienceFeeAmount)) {
                System.out.println("Successful Validation Message: Amount is less than 80000, so the bank and convenience fee is calculated as Expected: " + bankAndConvenienceFeeAmount);
            } else {
                System.out.println("Amount is less than 80000, so the bank and convenience fee is not calculated as Expected: " + bankAndConvenienceFeeAmount);
            }
        }
        if(Double.parseDouble(youSendAmount)>=80000&&Double.parseDouble(youSendAmount)<200000)

        {
            if (String.valueOf(bankAndConvenienceFeeAmountRange1).contains(bankAndConvenienceFeeAmount)) {
                System.out.println("Successful Validation Message: Amount is in range of 80000 to 200000 so the bank and convenience fee is calculated as Expected: " + bankAndConvenienceFeeAmount);
            } else {
                System.out.println("Amount is in range of 80000 to 200000 so the bank and convenience fee is not calculated as Expected: " + bankAndConvenienceFeeAmount);
            }
        }

        if(Double.parseDouble(youSendAmount)>=200000&&Double.parseDouble(youSendAmount)<400000)

        {
            if (String.valueOf(bankAndConvenienceFeeAmountRange2).contains(bankAndConvenienceFeeAmount)) {
                System.out.println("Successful Validation Message: Amount is in range of 200000 to 400000 so the bank and convenience fee is calculated as Expected: " + bankAndConvenienceFeeAmount);
            } else {
                System.out.println("Amount is in range of 200000 to 400000 so the bank and convenience fee is not calculated as Expected: " + bankAndConvenienceFeeAmount);
            }
        }

        if(Double.parseDouble(youSendAmount)>=400000&&Double.parseDouble(youSendAmount)<600000)

        {
            if (String.valueOf(bankAndConvenienceFeeAmountRange3).contains(bankAndConvenienceFeeAmount)) {
                System.out.println("Successful Validation Message: Amount is in range of 400000 to 600000 so the bank and convenience fee is calculated as Expected: " + bankAndConvenienceFeeAmount);
            } else {
                System.out.println("Amount is in range of 400000 to 600000 so the bank and convenience fee is not calculated as Expected: " + bankAndConvenienceFeeAmount);
            }
        }

        if(Double.parseDouble(youSendAmount)>=600000&&Double.parseDouble(youSendAmount)<1000000)

        {
            if (String.valueOf(bankAndConvenienceFeeAmountRange4).contains(bankAndConvenienceFeeAmount)) {
                System.out.println("Successful Validation Message: Amount is in range of 600000 to 1000000 so the bank and convenience fee is calculated as Expected: " + bankAndConvenienceFeeAmount);
            } else {
                System.out.println("Amount is in range of 600000 to 1000000 so the bank and convenience fee is not calculated as Expected: " + bankAndConvenienceFeeAmount);
            }
        }

        if(Double.parseDouble(youSendAmount)>=1000000)

        {
            if (String.valueOf(bankAndConvenienceFeeAmountRange5).contains(bankAndConvenienceFeeAmount)) {
                System.out.println("Successful Validation Message: Amount is more than 1000000 so the bank and convenience fee is calculated as Expected: " + bankAndConvenienceFeeAmount);
            } else {
                System.out.println("Amount is more than 1000000 so the bank and convenience fee is not calculated as Expected: " + bankAndConvenienceFeeAmount);
            }
        }*/


        public void validateGST() throws InterruptedException {
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

        public void setSendMoneyButton() {
            sendMoneyButton.click();
        }

        public void validateTheTCSInCalculationsSectionBeforeSelectingThePurposeCode() {
            String youSendAmount = comFun.removeDelimiter(inrCurrencyTextbox.getText());
            String tcsAmount = comFun.removeDelimiter(checkTcsAmount.getText());

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            double expectedTcsValue = comFun.twoDecimalValues((Double.parseDouble(youSendAmount) - 700000) * 5) / 100;
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


        public void uploadPassport() {
            String passportDoc = enterAmountToSend.getText();


            boolean value = inrCurrencyTextbox.isEnabled();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.alertIsPresent());


        }
    }



