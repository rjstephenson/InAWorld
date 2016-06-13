package com.inaworld.domain.character;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inaworld.process.startup.ApplicationProperties;

public enum NameSegmentsCache {
	INSTANCE;
	private static final String PROPERTY_KEY = "nameSegments";

	private NameSegmentsCache() {

	}

	public List<String> getNameStarts() {
		HashMap<String, Object> map = parseFile();

		@SuppressWarnings("unchecked")
		List<String> list = (ArrayList<String>) map.get("nameStarts");

		return list;
	}

	public List<String> getNameEnds() {
		HashMap<String, Object> map = parseFile();

		@SuppressWarnings("unchecked")
		List<String> list = (ArrayList<String>) map.get("nameEnds");

		return list;
	}

	/**
	 * @return
	 */
	private HashMap<String, Object> parseFile() {
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

	public static void main(String[] args) {
		List<String> starts = NameSegmentsCache.INSTANCE.getNameStarts();
		List<String> ends = NameSegmentsCache.INSTANCE.getNameEnds();
		System.out.println(starts.toString());
		System.out.println(ends.toString());
	}
}