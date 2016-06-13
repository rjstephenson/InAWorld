package com.inaworld.domain.test.geography;
import org.junit.Test;

import com.inaworld.domain.character.thread.Randomizer;


public class Scratchpad {

	@SuppressWarnings("unused")
	@Test
	public void tryItOut () {
		
		for (int i = 1;i<=100;i++) {
			System.out.println(Randomizer.lowToHigh(4,24,50));	
			
		}
		
		
		if ( 16 % 2 == 0 ) {
			System.out.println("even");
		} else {
			System.out.println("odd");
			
		}
		System.out.println((int) Math.ceil(17 / 2));
		System.out.println(Math.ceil(17 / 2));
		System.out.println((double) Math.ceil(17 / 2));
		
		String answer = 2 * 5 == 10 ? "Bite me" : "Smell my armpit";
	}
	
	
}
