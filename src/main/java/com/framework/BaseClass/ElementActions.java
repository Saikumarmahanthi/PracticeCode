package com.framework.BaseClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class ElementActions extends BaseTest {

	public static void url(String url) {
		try {

			getDriver().get(url);
			getExtentTest().log(LogStatus.INFO, "URL is entered as: " + url);

		} catch (Exception e) {
			getExtentTest().log(LogStatus.FAIL, "URL is  NOT entered as: " + url);
		}
	}

	public static void clickOnElement(WebElement element, String elemetName) {
		try {
			Assert.assertTrue(element.isDisplayed() && element.isEnabled());
			getExtentTest().log(LogStatus.PASS, elemetName + " is Displayed");
			element.click();
			getExtentTest().log(LogStatus.PASS, "Click action is done on " + elemetName);

		} catch (Exception e) {
			getExtentTest().log(LogStatus.FAIL, elemetName + " is NOT Displayed");
		}
	}

	public static void clickOnElementByActions(WebElement element, String elemetName) {
		try {
			Assert.assertTrue(element.isDisplayed() && element.isEnabled());
			getExtentTest().log(LogStatus.PASS, elemetName + " is Displayed");
			Actions action = new Actions(getDriver());
			action.click(element).build().perform();
			getExtentTest().log(LogStatus.PASS, "Click action is done on " + elemetName);

		} catch (Exception e) {
			getExtentTest().log(LogStatus.FAIL, elemetName + " is NOT Displayed");
		}
	}

	public static void setText(WebElement element, String elemetName, String testdata) {
		try {
			Assert.assertTrue(element.isDisplayed() && element.isEnabled());
			getExtentTest().log(LogStatus.PASS, elemetName + " is Displayed");
			element.clear();
			element.sendKeys(testdata);
			;
		} catch (Exception e) {
			getExtentTest().log(LogStatus.FAIL, elemetName + " is NOT Displayed");
		}
	}

	public static void setTextbyActions(WebElement element,  String elemetName, String testdata) {
		try {
			Assert.assertTrue(element.isDisplayed() && element.isEnabled());		
			getExtentTest().log(LogStatus.PASS, elemetName + " is Displayed");
			Actions action=new Actions(getDriver());
			action.sendKeys(element,testdata).build().perform();
		} catch (Exception e) {
			getExtentTest().log(LogStatus.FAIL, elemetName + " is NOT Displayed");
		}
	}

	public static void handledropdown(WebElement element,  String elemetName,String typevalue,String type) {
	
		try {
			Assert.assertTrue(element.isDisplayed() && element.isEnabled());		
			getExtentTest().log(LogStatus.PASS, elemetName + " is Displayed");
			Select select=new Select(element);
			
			if(type.equalsIgnoreCase("value")) {
				select.selectByValue(typevalue);
			}else if(type.equalsIgnoreCase("text")) {
				select.selectByVisibleText(typevalue);
			}
			else if(type.equalsIgnoreCase("index")) {
				int value=Integer.parseInt(typevalue);
				select.selectByIndex(value);
			}
			
		} catch (Exception e) {
			getExtentTest().log(LogStatus.FAIL, elemetName + " is NOT Displayed");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
}

