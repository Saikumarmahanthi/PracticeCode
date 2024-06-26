package com.framework.BaseClass;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.framework.Utilies.FrameworkExeptions;
import com.framework.Utilies.ScreenshotUtility;
import com.framework.listener.RerunFailedTests;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private static WebDriver driver;
	private static String tcName;

	public static ExtentReports extent;
	public static ExtentTest test;

	@Parameters({ "browser" })
	@BeforeSuite
	public void openBrowser(@Optional("chrome") String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().clearDriverCache().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else {
			throw new IllegalArgumentException("Invalid browser specified: " + browser);
		}
	}

	public void init() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	@AfterSuite
	public void closeBrowser() throws FrameworkExeptions {
		if (driver != null) {
			driver.close();
		} else {
			FrameworkExeptions fwe = new FrameworkExeptions("WebDriver pointing to null");
			throw fwe;
		}
	}

	@BeforeMethod
	public void beforeTCExecution(Method method) {
		tcName = method.getName();
		test = extent.startTest(tcName);
		System.out.println("TC Name:  " + tcName);
	}

	@AfterMethod
	public void afterTCExecution(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("TC Passesd: " + result.getName());
			test.log(LogStatus.PASS, "TC Passesd" + result.getName());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("TC Failed: " + result.getName());
			test.log(LogStatus.FAIL, "TC Passesd" + result.getName());
			test.log(LogStatus.FAIL, "TC Passesd" + result.getThrowable());
			String image=ScreenshotUtility.screenshot();
			test.log(LogStatus.FAIL, test.addScreenCapture(image));
			
		} else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println("Tc Skip" + result.getName());
			test.log(LogStatus.SKIP, "TC Passesd: " + result.getName());
			test.log(LogStatus.SKIP, "TC Passesd: " + result.getThrowable());
			String image=ScreenshotUtility.screenshot();
			test.log(LogStatus.SKIP, test.addScreenCapture(image));
		}
		extent.endTest(test);
		extent.flush();
	}

	@BeforeTest
	public void initReport() {
		 extent= new ExtentReports(System.getProperty("user.dir") + "\\Reports\\reports.html");
		 extent.addSystemInfo("User Name ", "M Saikumar");
	}
	
	@AfterTest
	public void closeReport() {
		// extent.close();
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static String getTCName() {
		return tcName;
	}

	public static ExtentTest getExtentTest() {
		return test;
	}
}
