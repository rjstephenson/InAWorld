package com.inaworld.process.startup;

public class EqualityTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String myString = new String ("Randy");
		
		String myOtherString =  new String ("Randy");
		
		System.out.println((myString == myOtherString) ? "true" : "false");

	}

}
