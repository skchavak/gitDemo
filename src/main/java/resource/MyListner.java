package resource;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListner implements ITestListener {
	WebDriver driver;
	ExtentReports er;
	ThreadLocal<ExtentTest> thread = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		er = ExtentReport.getReportObject();
		ExtentTest et = er.createTest(result.getMethod().getMethodName());
		thread.set(et);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		
		thread.get().log(Status.PASS, "Test Passed");
	}
	

	@Override
	public void onTestFailure(ITestResult result) {
		thread.get().fail(result.getThrowable());
		ITestContext context = result.getTestContext();
		// TODO Auto-generated method stub
		String path = "./screenshot/"+ result.getMethod().getMethodName() +".png";
		try {
			//driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					//.get(result.getInstance());
			driver = (WebDriver)context.getAttribute("WebDriver");
			File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scr, new File(path));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		File f = new File(path);
		thread.get().addScreenCaptureFromPath(f.getAbsolutePath());
	}
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		er.flush();
	}
}
