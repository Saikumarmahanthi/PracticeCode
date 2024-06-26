package com.framework.objectrepo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesReader {

	private String filepath;
	private Properties properties;
	private String value;

	public PropertiesReader(String filepath) throws IOException {
		this.filepath = filepath;
		FileInputStream fileinputstream = new FileInputStream(filepath);
		properties = new Properties();
		properties.load(fileinputstream);
	}

	public String getPropertyValue(String key) {
		if (properties != null) {
			value = properties.getProperty(key);
		} else {
			System.out.println("Properties value pointing to NULL");
		}
		return value;
	}

	// IF KEY IS NOT THERE ASSIGN DEFAULT VALUE

	public String getValue(String key, String defaultValue) {
		if (properties != null) {
			value = properties.getProperty(key);
			if (value == null) {
				value = defaultValue;
			}
		} else {
			System.out.println("Properties value pointing to NULL");
		}
		return value;
	}

	// IF KEY IS NOT IN STRING FROMAT & KEY NOT THERE ASSIGN DEFAULT VALUE

	public String getValue(Object key, Object defaultValue) {
		if (properties != null) {
			value = (String) properties.getOrDefault(key, defaultValue);
			if (value == null) {
				value = (String) defaultValue;
			}
		} else {
			System.out.println("Properties value pointing to NULL");
		}
		return value;
	}

	public void writeKeyValue(String key, String value) throws IOException {

		if (properties != null) {
			properties.setProperty(key, value);
			FileOutputStream fileinputstream = new FileOutputStream(filepath);
			properties.store(fileinputstream, "File saved Successfuuly");
		} else {
			System.out.println("Properties value pointing to NULL");
		}

	}

	public void writeKeyValue(Object key, Object value) throws IOException {

		if (properties != null) {
			properties.put(key, value);
			FileOutputStream fileinputstream = new FileOutputStream(filepath);
			properties.store(fileinputstream, "File saved Successfuuly");
		} else {
			System.out.println("Properties value pointing to NULL");
		}

	}

	public List getValues() {

		List listvalues = new ArrayList();

		if (properties != null) {
			Set set = properties.keySet();

			for (Object obj : set) {
				Object value = properties.get(obj);
				listvalues.add(value);
			}
		} else {
			System.out.println("Properties value pointing to NULL");
		}
		return listvalues;
	}

	public Map getKeyValues() {
		Map map = new HashMap();
		if (properties != null) {
			Set set = properties.keySet();

			for (Object obj : set) {
				Object value = properties.get(obj);
				map.put(obj, value);
			}
		} else {
			System.out.println("Properties value pointing to NULL");
		}
		return map;

	}

}
