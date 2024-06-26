package com.framework.Tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.framework.BaseClass.BaseTest;
import com.framework.BaseClass.ElementActions;
import com.framework.objectrepo.PojoReader;
import com.relevantcodes.extentreports.LogStatus;

public class Filpkart extends ElementActions {

	@Test
	public void filpkartTest() throws FileNotFoundException, IOException, ParseException {	
		
		url(PojoReader.getproperties().getPropertyValue("filpcart_url"));
		
		
		
		
		
	}
}
