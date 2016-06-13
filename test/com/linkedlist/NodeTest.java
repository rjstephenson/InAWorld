package com.linkedlist;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class NodeTest {


	@Test 
	public void makeNode () {
		Node n = new Node(new String("Go"));
		assertTrue(n.getData().equals("Go"));
	}

	@Test 
	public void setNext () {
		Node n = new Node(new String("Go"));
		n.setNext(new Node("next"));
		assertTrue(n.getNext() != null);
	}

}
