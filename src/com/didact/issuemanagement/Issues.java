/**
 * 
 */
package com.didact.issuemanagement;

/**
 * @author p625305
 *
 */
public interface Issues {	

	public enum Components { 
		AUTHORITY, COMMUNICATION, FATHER, SECURITY, CONTROL
		
	}
	public void takeIt (String input);
	public void leaveIt (String input);

}
