package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportManager  {
	public static ExtentReports extent;
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	public static void setup() {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(Constants.REPORT_DIRECTORY);
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setDocumentTitle("Hop App Automation Test Report");
		sparkReporter.config().setReportName("Test Suite Report");

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("OS", "Mac");
		extent.setSystemInfo("Environment", "Staging");
	}

	public static void flush() {
		extent.flush();
	}

	public static ExtentTest createTest(String testName) {
		ExtentTest extentTest = extent.createTest(testName);
		test.set(extentTest);
		return extentTest;
	}

}
