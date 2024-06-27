package com.framework.Tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.framework.BaseClass.ElementActions;
import com.framework.Pages.Amazon_HomePage;
import com.framework.objectrepo.PojoReader;

public class AmazonTest extends ElementActions {

	@Test
	public void amazonTest() throws FileNotFoundException, IOException, ParseException {
		url(PojoReader.getproperties().getPropertyValue("amazon_url"));
//		clickOnElement(ele, "SAI");
//		Amazon_HomePage.searchInput("Laptop");
//		Amazon_HomePage.searchdopdown();
//		Amazon_HomePage.submit();
	}
}
