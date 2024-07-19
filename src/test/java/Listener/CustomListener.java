package Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener {
	
	
	public void onTestStart(ITestResult result) {
       System.out.println("Start test....." + result.getName());
    }
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test success....." + result.getName());
    }
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failure....." + result.getName());
    }
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped....." + result.getName());
    }
	
	public void onStart(ITestContext context) {
		System.out.println("Start test suite....." + context.getName());
    }
	
	public void onFinish(ITestContext context) {
		System.out.println("Finish test suite....." + context.getName());
    }
}
