
package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.List;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports report;
	public ExtentTest test;

	String reportName;

	@Override
	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		reportName = "TestNG_ExtentReport"+timeStamp+".html";

		String filepath = System.getProperty("user.dir") + "/Reports/";
		sparkReporter = new ExtentSparkReporter(filepath + reportName);// specify location of the report

		sparkReporter.config().setDocumentTitle("Zig Wheels "); // Title of report
		sparkReporter.config().setReportName("Identify New Bikes"); // name of the report
		sparkReporter.config().setTheme(Theme.STANDARD);

		report = new ExtentReports();
		report.attachReporter(sparkReporter);
		report.setSystemInfo("Application", "Zig Wheels");
		report.setSystemInfo("Module", "Identify New Module");
		//report.setSystemInfo("Sub Module", "News Page");
		report.setSystemInfo("Operating System", System.getProperty("os.name"));
		report.setSystemInfo("User Name", System.getProperty("user.name"));
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		report.setSystemInfo("Browser", browser);

		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
		report.setSystemInfo("Groups", includedGroups.toString());
	}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = report.createTest(result.getName());
		test.log(Status.PASS, "Test Passed");
		test.assignCategory(result.getMethod().getGroups());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = report.createTest(result.getName());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		test.assignCategory(result.getMethod().getGroups());


	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = report.createTest(result.getName());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
		test.assignCategory(result.getMethod().getGroups());
	}

	@Override
	public void onFinish(ITestContext testContext) {
		report.flush();


	}
}

