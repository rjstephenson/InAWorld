/**
 * 
 */
package com.didact.issuemanagement;

import java.util.ArrayList;
import java.util.List;

import com.didact.issuemanagement.Issues.Components;

/**
 * @author p625305
 * 
 */
public class IssueManager {
	
	/**
	 * 
	 */
	public IssueManager() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Object> components = new ArrayList<Object>();
		components.add(ComponentFactory.getComponent(Components.AUTHORITY));
		components.add(ComponentFactory.getComponent(Components.COMMUNICATION));
		components.add(ComponentFactory.getComponent(Components.FATHER));
		components.add(ComponentFactory.getComponent(Components.SECURITY));
		components.add(ComponentFactory.getComponent(Components.CONTROL));
		Issues issues;
		Interactive interactive;

		/** 
		 * Process take its
		 */
		System.out.println("Issues where you just Take it");
		for (Object i : components) {
			issues = (Issues) i;
			issues.takeIt(i.getClass().getName());
		}

		/**
		 * process leave its
		 */
		System.out.println("Issues where you just LEAVE it");
		for (Object i : components) {
			issues = (Issues) i;
			issues.leaveIt(i.getClass().getName());
		}
		
		/** 
		 * Process avoid
		 */
		System.out.println("Interactions...");
		for (Object i : components) {
			Class myObjectClass = i.getClass();
			Class[] interfaces = myObjectClass.getInterfaces();
			if (interfaces != null) {
				for (Object j : interfaces) {
					if (j.toString().contains("Interactive")) {
						interactive = (Interactive) i;
						interactive.avoid(i.getClass().getName());
						interactive.blameShift(i.getClass().getName());
						interactive.compliment(i.getClass().getName());
						interactive.delegate(i.getClass().getName());

						
					}
				}
			}
		}
	}

}
