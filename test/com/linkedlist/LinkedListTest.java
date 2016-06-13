package com.linkedlist;


import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

	LinkedList ll;
	
	@Before
	public void setUp() throws Exception {
		ll = new LinkedList(); 
	}

	@After
	public void tearDown() throws Exception {
		ll = null;
	}

	@Test
	public void addOneandSizeisOne() {
		ll.add(new String("A"));
		assertTrue(ll.size() == 1); 
	}
	
	@Test
	public void addTwoAndSizeisTwo() {
		ll.add(new String("A"));
		ll.add(new String("B"));
		assertTrue(ll.size() == 2); 
	}
	
	@Test
	public void addThreeAndSizeisThree() {
		ll.add(new String("A"));
		ll.add(new String("B"));
		ll.add(new String("C"));
		assertTrue(ll.size() == 3); 
	}
	@Test
	public void addTwoGetLastData() {
		ll.add(new String("A"));
		ll.add(new String("B"));
		assertTrue(ll.getLastData().equals("B")); 
	}
	
	@Test
	public void addThreeGetLastData() {
		ll.add(new String("A"));
		ll.add(new String("B"));
		ll.add(new String("C"));
		assertTrue(ll.getLastData().equals("C")); 
	}
	
	@Test
	public void addThreeGetFirstData() {
		ll.add(new String("A"));
		ll.add(new String("B"));
		ll.add(new String("C"));
		assertTrue(ll.getFirstData().equals("A")); 
	}
	
	@Test
	public void addTwoGetFirstData() {
		ll.add(new String("A"));
		ll.add(new String("C"));
		assertTrue(ll.getFirstData().equals("A")); 
	}
	
	@Test
	public void addTwoRemoveLastGetLastData() {
		ll.add(new String("A"));
		ll.add(new String("C"));
		ll.removeLast(); 
		assertTrue(ll.getLastData().equals("A")); 
	}
}
