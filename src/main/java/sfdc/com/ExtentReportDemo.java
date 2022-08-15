package sfdc.com;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemo {
	private static Logger logger = LogManager.getLogger(ExtentReportDemo.class);
	
	public static void main(String[] args) {
		
//		.html, klov
		
		String dateFormat = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		System.out.println(dateFormat);
		
		String reportPath = System.getProperty("user.dir")+"\\src\\main\\resources\\reports\\"+dateFormat+"_sfdc.html";
		
		ExtentReports extent = new ExtentReports();
		ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(reportPath);
		extent.attachReporter(htmlReport);
		
		// Start logging for the report TC1
//		Levels: INFO, WARN, PASS, FAIL
		ExtentTest test1 = extent.createTest("TC01");
		test1.info("App launched");
		test1.info("Username enetered");
		test1.info("password enetered");
		test1.info("Login button clicked");
		test1.pass("TC01 PASSED");
		
		ExtentTest test2 = extent.createTest("TC02");
		test2.info("App launched");
		test2.info("Username enetered");
		test2.info("password enetered");
		test2.info("Login button clicked");
		test2.error("Home page not loaded");
		test2.pass("TC02 FAILED");
		
		extent.flush();
	}

}
