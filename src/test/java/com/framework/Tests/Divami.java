package com.framework.Tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.framework.BaseClass.ElementActions;
import com.framework.objectrepo.PojoReader;

public class Divami extends ElementActions {
	
	@Test
	public void divamiTest() throws FileNotFoundException, IOException, ParseException {

		url(PojoReader.getproperties().getPropertyValue("divami_url"));

	}
}
