package com.framework.objectrepo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.framework.Utilies.FrameworkExeptions;

public class JsonReader {

	private JSONObject jsonobject;
	private String filepath;
	private JSONParser jsonparser;
	private String value;

	public JsonReader(String filepath) throws FileNotFoundException, IOException, ParseException {
		this.filepath = filepath;
		jsonparser = new JSONParser();
		Object obejct = jsonparser.parse(new FileReader(filepath));
		jsonobject = (JSONObject) obejct;
	}

	public String getJsonValue(String key) throws FrameworkExeptions {
		if (jsonobject != null) {
			value = (String) jsonobject.get(key);
		} else {
			FrameworkExeptions framworkexeption=new FrameworkExeptions("WebDriver pointing to null");
			throw framworkexeption;
		}
		return value;
	}

	public String getJsonValue(String key, String defaultValue) {
		if (jsonobject != null) {
			value = (String) jsonobject.getOrDefault(key, defaultValue);
			if (value == null) {
				value = defaultValue;
			}
		} else {
			System.out.println("Json Object is pointing to nulll");
		}
		return value;
	}

	public Map<String, String> getJsonkeyValues() {
		Map<String, String> keyset = new HashMap<String, String>();
		if (jsonobject != null) {
			Set keys = jsonobject.keySet();
			for (Object object : keys) {
				String key = (String) object;
				value = (String) jsonobject.get(key);
				keyset.put(key, value);
			}
		}

		return keyset;

	}

}
