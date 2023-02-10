package resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static  ExtentReports er;
	
	public static ExtentReports getReportObject() {
		
		String path = "./reports/report.html";
		ExtentSparkReporter esr = new ExtentSparkReporter(path);
		
		esr.config().setReportName("Apple Automation");
		esr.config().setDocumentTitle("Test Result");
		
		er = new ExtentReports();
		er.attachReporter(esr);
		
		er.setSystemInfo("Tester", "Saurabh");
		
		
		return er;
		
	}
}
