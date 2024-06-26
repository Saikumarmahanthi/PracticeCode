package com.framework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.BaseClass.BaseTest;

public class Amazon_HomePage extends BaseTest {

	@FindBy(id = "twotabsearchtextbox")
	private static WebElement amazonSearch;

	@FindBy(id = "nav-search-submit-button")
	private static WebElement InputSubmit;

	@FindBy(id = "searchDropdownBox")
	private static WebElement seachDropdown;

	public static void searchInput(String search) {
		amazonSearch.sendKeys(search);
	}
	public static void submit() {
		InputSubmit.click();
	}
	public static void searchdopdown() {
		seachDropdown.click();
	}

	static {
		PageFactory.initElements(getDriver(), Amazon_HomePage.class);
	}
}
