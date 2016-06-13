package com.inaworld.process.startup;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public enum AllPurposePool { 
	INSTANCE;
	
	private ExecutorService allPurposePool = Executors.newFixedThreadPool(300);

	public ExecutorService getAllPurposePool() {
		return allPurposePool;
	}
	
	

}
