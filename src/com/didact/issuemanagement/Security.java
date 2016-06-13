package com.didact.issuemanagement;

public class Security implements Issues {

	@Override
	public void takeIt(String input) {
		System.out.println(input + " " + "Alarm");
		
	}

	@Override
	public void leaveIt(String input) {
		System.out.println(input + " " + "Plot");
		
		
	}

}
