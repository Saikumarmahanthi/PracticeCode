package com.framework.objectrepo;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public class PojoReader {
	
	

	public static JsonReader getjsonobject() throws FileNotFoundException, IOException, ParseException {
	
		JsonReader jsonreader = new JsonReader(FilePaths.jsonFilePath);
		
		return jsonreader;
	}

	public static PropertiesReader getproperties() throws FileNotFoundException, IOException, ParseException {
		
		PropertiesReader properties = new PropertiesReader(FilePaths.propertiespath);
		
		return properties;
	}
	
	public static ExcelReader getexcelvalue() throws FileNotFoundException, IOException, ParseException {
		
		ExcelReader exceldata = new ExcelReader(FilePaths.excelpath);
		
		return exceldata;
	}
}
