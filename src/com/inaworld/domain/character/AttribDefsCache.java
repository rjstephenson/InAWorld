package com.inaworld.domain.character;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inaworld.process.startup.ApplicationProperties;

public enum AttribDefsCache {

	INSTANCE;

	private static final String MAXIMUM = "max";
	private static final String MINIMUM = "min";
	private static final String ATTRIBUTE = "att";
	private static final String PROPERTY_KEY = "attribDefs";

	private AttribDefsCache() {

	}

	public List<AttribDef> getAttribDefs() {
		Map<String, Object> map = parseFile();
		@SuppressWarnings("unchecked")
		List<Map<String, Object>>  list = (List<Map<String, Object>>) map.get(PROPERTY_KEY);

		List<AttribDef> attribDefs = new ArrayList<AttribDef>();
		
		for (Map<String, Object> attribute : list) {
			String name = (String) attribute.get(ATTRIBUTE);
			int min = (Integer) attribute.get(MINIMUM);
			int max = (Integer) attribute.get(MAXIMUM);
			AttribDef att = new AttribDef.Builder().name(name).min(min).max(max).build();
			attribDefs.add(att);
		}
		
		return attribDefs;
	}


	/**
	 * @return
	 */
	private Map<String, Object> parseFile() {
		ObjectMapper mapper = new ObjectMapper();
		String fileName = null;
		try {
			fileName = ApplicationProperties.INSTANCE.getPropertyValue(PROPERTY_KEY);

		} catch (IOException e) {
			e.printStackTrace();
		}
		File from = new File(fileName);
		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
		};

		HashMap<String, Object> map = null;
		try {
			map = mapper.readValue(from, typeRef);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
		
	public static void main (String[] args) {
		List<AttribDef> attribDefs = AttribDefsCache.INSTANCE.getAttribDefs();
		for (AttribDef attribDef : attribDefs) {
			System.out.println(attribDef.toString());
		}
	}
}