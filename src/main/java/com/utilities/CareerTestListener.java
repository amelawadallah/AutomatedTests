package com.utilities;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class CareerTestListener extends TestListenerAdapter{
	
	@Override
	public void onTestSuccess(ITestResult tr){
		System.out.println(tr.getName() + "was successful");
	}
	
	@Override
	public void onTestFailure(ITestResult tr){
		System.out.println(tr.getName() + " was a failure.\n Throwable: "+tr.getThrowable().getMessage());
	}
	
	@Override
	public void onTestSkipped(ITestResult tr){
		System.out.println(tr.getName() + " was skipped.");

	}	
}
