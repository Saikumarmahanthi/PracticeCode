package com.framework.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RerunFailedTests implements IRetryAnalyzer {

	int minCount = 0;
	int maxCount = 1;

	/*
	 * This class implements IRetryAnalyzer it is an interface for retrying failed
	 * tests through this interface by specified counts
	 * 
	 */
	@Override
	public boolean retry(ITestResult result) {

		if (minCount < maxCount) {
			minCount++;
			return true;
		}

		return false;
	}

}
