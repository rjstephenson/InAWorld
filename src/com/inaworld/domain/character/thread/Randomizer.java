package com.inaworld.domain.character.thread;

import java.util.Random;

public class Randomizer {
	public static int oneToHigh(int high) {
		return new Random().nextInt(high) + 1;
	}

	public static int lowToHigh(int low, int high) {
		return new Random().nextInt(high - low + 1) + low;
	}

	public static int lowToHigh(int low, int high, int normalizer) {
		int normalized = 0;
		switch (new Random().nextInt(4) + 1) {
		case 1:
		case 2:
		case 3:
//			System.out.println("Normalized...");
			for (int i = 1; i <= normalizer; i++) {
				normalized = normalized + new Random().nextInt(high - low + 1) + low;
			}
			normalized = normalized / normalizer;
			break;

		case 4:
//			System.out.println("Not normalized...");
			normalized = new Random().nextInt(high - low + 1) + low;
			break;
		}
		return normalized;
	}
}
