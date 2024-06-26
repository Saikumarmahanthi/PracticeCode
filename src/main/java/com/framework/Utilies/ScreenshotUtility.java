package com.framework.Utilies;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.framework.BaseClass.BaseTest;

public interface ScreenshotUtility {

	public static String screenshot() throws IOException {

		File file = ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.FILE);
		String screenshot = System.getProperty("user.dir") + "\\Screenshots\\" + BaseTest.getTCName() + ".png";
		FileUtils.copyFile(file, new File(screenshot));
		return screenshot;

	}

	public static String screenshot(String tcName) throws IOException {

		File file = ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.FILE);
		String screenshot = System.getProperty("user.dir") + "\\Screenshots\\" + tcName + ".png";
		FileUtils.copyFile(file, new File(screenshot));
		return screenshot;
	}
}
