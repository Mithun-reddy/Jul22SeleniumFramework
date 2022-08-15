package sfdc.com.listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import sfdc.com.tests.BaseTest;
import sfdc.reusable.utils.Utilities;

public class SFDCListeners extends BaseTest implements ITestListener  {

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("test has started");
		test = extent.createTest(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.pass(result.getName()+" PASSED");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");  // here we are accessing the driver object that we added in Test class  
		
		try {
		test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		LoginTest.test.log(Status.FAIL, result.getName()+" Failed");
		test.fail(result.getName()+" FAILED");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}
