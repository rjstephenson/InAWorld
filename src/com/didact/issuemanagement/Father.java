package com.didact.issuemanagement;

public class Father implements Issues {

	@Override
	public void takeIt(String input) {
		System.out.println(input + " " + "Defend");
		
	}

	@Override
	public void leaveIt(String input) {
		System.out.println(input + " " + "Exit");
		
	}

}
