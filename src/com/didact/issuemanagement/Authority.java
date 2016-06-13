package com.didact.issuemanagement;

public class Authority implements Issues, Interactive {

	@Override
	public void takeIt(String input) {
		System.out.println(input + " " + "Submit");
		
	}

	@Override
	public void leaveIt(String input) {
		System.out.println(input + " " + "Vacate");
		
	}

	@Override
	public void delegate(String operation) {
		System.out.println(operation + " " + "You do it..");
		
	}

	@Override
	public void microManage(String operation) {
		System.out.println(operation + " " + "Are you done yet, are you done yet!");
		
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
		System.out.println(operation + " " + "Can't stand it");
		
	}

	@Override
	public void compliment(String operation) {
		System.out.println(operation + " " + "Way to go.");
		
	}

}
