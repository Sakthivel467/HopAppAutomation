package Utils;

import DriverSetup.BaseTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static DriverSetup.BaseTest.driver;
import static extentReport.ExtentReportManager.test;

public class TakeSnap{


    public static void captureScreenshot() {
		try {
			byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			String screenshotBase64 = encodeBase.encodeBase64(screenshotBytes);
			String fullSizeScreenshotHtml = "<a href='data:image/png;base64," + screenshotBase64 + "' target='_blank'>"
					+ "<img src='data:image/png;base64," + screenshotBase64 + "'  style='width:200px;height:auto;' /></a>";
			test.get().log(Status.INFO, fullSizeScreenshotHtml);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
