package com.linkedlist;

public class Node {

	String data;
	private Node next; 
	
	public Node (String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setNext(Node node) {
		this.next = node;
		
	}

	public Node getNext() {
		return next;
	}
	
}
