package com.linkedlist;

public class LinkedList {

	private int size; 
	private Node head;
	
	public void add(String string) {
		Node newNode = new Node(string);
		if (head == null) {
			head = newNode; 
		} else {
			Node current = getLastNode();
			current.setNext(newNode);
		}
		
		size++;
	}

	public int size() {
			return size;
	}

	public String getLastData() {
		Node current = getLastNode();
		return current.getData();
	}

	/**
	 * @return
	 */
	private Node getLastNode() {
		Node current = head; 
		while (current.getNext() != null) {
			current = current.getNext();
		}
		return current;
	}

	public Object getFirstData() {
		return head.data;
	}

	public void removeLast() {
		Node current = head; 
		Node prior = head; 
		while (current.getNext() != null) {
			prior = current; 
			current = current.getNext();
		}
		prior.setNext(null);
		size--;
	}

}
