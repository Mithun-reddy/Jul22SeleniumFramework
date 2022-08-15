package sfdc.com;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import sfdc.reusable.utils.Utilities;

public class ListenersDemo implements ITestListener  {

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("test has started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test passed");
//		LoginTest.test.log(Status.PASS, result.getName()+" Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
//		LoginTest login = new LoginTest();
//		try {
//			LoginTest.test.addScreenCaptureFromPath(Utilities.captureScreenshot(LoginTest.driver));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		LoginTest.test.log(Status.FAIL, result.getName()+" Failed");
		
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
