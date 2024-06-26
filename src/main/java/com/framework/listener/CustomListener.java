package com.framework.listener;

import org.testng.IAnnotationTransformer;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.framework.Utilies.Reports;

public class CustomListener implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test suite is started");
	}

	/*
	 * This method is invoked when a test method starts execution
	 */
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("TC is Started " + result.getName());
	}
	/*
	 * This method is called when a test method successfully completes its execution
	 * without any assertion failures or exceptions. It provides information about
	 * the successful test method
	 */

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("TC is Passed " + result.getName());
	}

	/*
	 * This method is triggered when a test method fails due to an assertion failure
	 * or an unhandled exception. It provides information about the failed test
	 * method
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("TC is Failed " + result.getName());
	}

	/*
	 * This method is invoked when a test method is skipped, either due to
	 * dependencies not being met or because it is explicitly skipped using
	 * annotations such as @Test(enabled = false)
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("TC is Skipped " + result.getName());
	}

	/*
	 * This method is called after the execution of all the test methods within a
	 * tag in the testng.xml file. It provides information about the test context
	 * via the ITestContext parameter.
	 */
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Suite is finished");
	}

}
