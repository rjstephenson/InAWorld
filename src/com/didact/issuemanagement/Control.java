package com.didact.issuemanagement;

public class Control implements Issues {

	@Override
	public void takeIt(String input) {
		System.out.println(input + " " + "Dominate");
		
	}

	@Override
	public void leaveIt(String input) {
		System.out.println(input + " " + "Let go");
		
	}

}
