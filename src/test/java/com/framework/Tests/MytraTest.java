package com.framework.Tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


import com.framework.BaseClass.BaseTest;
import com.framework.objectrepo.PojoReader;
import com.relevantcodes.extentreports.LogStatus;

public class MytraTest  extends BaseTest{
	
	@Test
	public void mytraTest() throws FileNotFoundException, IOException, ParseException {
		getDriver().get(PojoReader.getproperties().getPropertyValue("mytra_url"));
	}

}

