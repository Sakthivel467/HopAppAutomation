package DriverSetup;

import Pages.*;
import Utils.TakeSnap;
import com.aventstack.extentreports.ExtentTest;
import extentReport.ExtentReportManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;

import io.appium.java_client.ios.options.XCUITestOptions;
import listeners.ReportListener;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Listeners({ReportListener.class})
public class BaseTest {
    public static AppiumDriver driver;
    private static final String PLATFORM = System.getProperty("platform", "android");

    //Declaring all page objects as protected Variable

    protected  ExtentTest test;
    protected OnboardingPage onboardingPage;
    protected SendMoneyPage sendMoneyPage;
    protected KycPage kycPage;

    @BeforeSuite
    public void setupExtent() {
        ExtentReportManager.setup();
    }



    @BeforeMethod
    public void setUp() throws MalformedURLException {


        if (PLATFORM.equalsIgnoreCase("android")) {

            //Android Setup
            String home = System.getProperty("user.home");
            File app = new File(home + File.separator + "Desktop" + File.separator + "remit_stg_nov13th.apk");

            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("emulator-5554");
            options.ignoreHiddenApiPolicyError();
            options.autoGrantPermissions();
            options.fullReset();
            options.setAutomationName("UiAutomator2");
            options.setApp(app.getAbsolutePath());
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), options);
            System.out.println("AndroidDriver is set");


        } else if (PLATFORM.equalsIgnoreCase("ios")) {
            String home = System.getProperty("user.home");
            File app = new File(home + File.separator + "Desktop" + File.separator + "moneyHopp.app");

            XCUITestOptions options = new XCUITestOptions();
            options.setDeviceName("iPhone 15 Pro Max")
                    .setPlatformVersion("17.5")
                    .setUdid("67956AE8-2C42-42D0-8C4B-3D450EEF8090")
                    .setAutomationName("XCUITest")
                    .setAutoAcceptAlerts(true)
                    .setResetOnSessionStartOnly(true)
                    .setConnectHardwareKeyboard(true);
            options.setApp(app.getAbsolutePath());
            driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), options);
            System.out.println("IOSDriver is set");
        }
        //  Initializing all page objects once

        onboardingPage=new OnboardingPage(driver);
        sendMoneyPage=new SendMoneyPage(driver);
        kycPage=new KycPage(driver);

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void tearDownExtentReport() {
        ExtentReportManager.flush();
    }

    public static String testcase=null;
    public void before(String TestCaseName) throws IOException {
        testcase=TestCaseName;
        ExtentReportManager.createTest(TestCaseName);
    }
}

