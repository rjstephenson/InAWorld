package com.didact.issuemanagement;

import com.didact.issuemanagement.Issues.Components;

public class ComponentFactory {
	public static Object getComponent (Components components) {
		
		switch (components) {
		case AUTHORITY:
			return new Authority();
		case COMMUNICATION:
			return new Communication();
		case FATHER:
			return new Father();
		case SECURITY:
			return new Security();
		case CONTROL:
			return new Control();
			
		}
		return null;
	
	}
}
