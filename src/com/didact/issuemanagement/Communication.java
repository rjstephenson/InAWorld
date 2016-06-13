/**
 * 
 */
package com.didact.issuemanagement;

/**
 * @author p625305
 *
 */
public class Communication implements Issues, Interactive {

	/**
	 * 
	 */
	public Communication() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void takeIt(String input) {
		System.out.println(input + " " + "Silence");
		
	}

	@Override
	public void leaveIt(String input) {
		System.out.println(input + " " + "Explode");
		
	}

	@Override
	public void delegate(String operation) {
		System.out.println(operation + " " + "Please help..");
		
	}

	@Override
	public void microManage(String operation) {
		System.out.println(operation + " " + "Well!?");
		
	}

	@Override
	public void manage(String operation) {
		System.out.println(operation + " " + "Give me status.");
		
	}

	@Override
	public void avoid(String operation) {
		System.out.println(operation + " " + "<crickets>");
		
	}

	@Override
	public void blameShift(String operation) {
		System.out.println(operation + " " + "I told you so.");
		
	}

	@Override
	public void flatter(String operation) {
		System.out.println(operation + " " + "Good job!");
		
	}

	@Override
	public void vent(String operation) {
		System.out.println(operation + " " + "Why I oughta!");
		
	}

	@Override
	public void compliment(String operation) {
		System.out.println(operation + " " + "Could be worse.");
		
	}

}
