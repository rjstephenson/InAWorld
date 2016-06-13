package com.inaworld.domain.character;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.inaworld.process.startup.ApplicationProperties;

public enum AttribDefsCacheUsingParser {

	INSTANCE;

	private static final String MAXIMUM = "max";
	private static final String MINIMUM = "min";
	private static final String ATTRIBUTE = "att";
	private static final String PROPERY_KEY = "AttribDefsCache";

	private AttribDefsCacheUsingParser() {

	}

	public Map<String, AttribDef> getCache() {
		final Map<String, AttribDef> attribDefMap = new HashMap<String,AttribDef>();

		try {
			String me = ApplicationProperties.INSTANCE.getPropertyValue(PROPERY_KEY);
			File file = new File(me);
			JsonFactory factory = new JsonFactory();
			JsonParser parser = factory.createParser(file);
			String att = null;
			int min = 0;
			int max = 0;
			while (!parser.isClosed()) {
				JsonToken jsonToken = parser.nextToken();
				if (JsonToken.FIELD_NAME.equals(jsonToken)) {
					String fieldName = parser.getCurrentName();
					jsonToken = parser.nextToken();
					if (ATTRIBUTE.equals(fieldName)) {
						att = parser.getValueAsString();
					} else if (MINIMUM.equals(fieldName)) {
						min = parser.getValueAsInt();
					} else if (MAXIMUM.equals(fieldName)) {
						max = parser.getValueAsInt();
						attribDefMap.put(att, new AttribDef.Builder().name(att).min(min).max(max).build());
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return attribDefMap;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, AttribDef> getAttribute(String key) {
		return (Map<String, AttribDef>) AttribDefsCacheUsingParser.INSTANCE.getCache().get(key);
	}
		
	public static void main (String[] args) {
		Map<String,AttribDef> attributes = AttribDefsCacheUsingParser.INSTANCE.getCache();
	}
}