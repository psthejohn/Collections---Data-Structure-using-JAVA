package com.geekster.november1.LinkedList;

import java.io.*;

//Java program to implement 
//a Singly Linked List 
public class LinkList {
	public class Node {
		int data;
		Node next;
	}

	Node head;
	int size;
	Node tail;

	public void addLast(int d) {
		Node newNode = new Node();
		newNode.data = d;
		if (size == 0) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	public void addStart(int d) {
		Node newNode = new Node();
		newNode.data = d;
		if (size == 0) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	public void addAt(int d, int pos) {
		if (pos > size || pos < 0) {
			System.out.println("position out of bound!!");
		} else if (pos == 1) {
			addStart(d);
		} else if (pos == size) {
			addLast(d);
		} else {
			Node temp = head;
			int counter = 0;
			while (counter < pos - 2) {
				temp = temp.next;
				counter++;
			}
			Node newNode = new Node();
			newNode.data = d;
			newNode.next = temp.next;
			temp.next = newNode;
			size++;
		}
	}

	public void display() {
		Node pointer = head;
		while (pointer != null) {
			System.out.print(pointer.data + " -->");
			pointer = pointer.next;
		}
	}

	public int getFirst() {
		if (size == 0) {
			return -1;
		} else {
			return head.data;
		}
	}

	public int getEnd() {
		if (size == 0) {
			return -1;
		} else {
			return tail.data;
		}
	}

	public int getAtPosition(int pos) {
		if (pos < 0 || pos > size) {
			System.out.println("Position out of bound");
			return -1;
		} else if (pos == 0) {
			return getFirst();
		} else if (pos == size) {
			return getEnd();
		} else {
			Node temp = head;
			int counter = 0;
			while (counter < pos - 1) {
				temp = temp.next;
				counter++;
			}
			return temp.data;
		}
	}

	public int getAtIndex(int idx) {
		return getAtPosition(idx + 1);
	}

	public Node getNodeAt(int idx) {
		if (idx < 0 || idx >= size) {
			return null;
		} else if (idx == 0) {
			return head;
		} else if (idx == size - 1) {
			return tail;
		} else {
			int counter = 0;
			Node temp = head;
			while (counter < idx) {
				temp = temp.next;
				counter++;
			}
			return temp;
		}
	}

	public void removeStart() {
		if (size == 0) {
			System.out.println("Nothing to remove !! List is empty");
		} else if (size == 1) {
			head = tail;
			size--;
		} else {
			head = head.next;
			size--;
		}
	}

	public void removeEnd() {
		if (size == 0) {
			System.out.println("Nothing to remove !! List is empty");
		} else if (size == 1) {
			head = null;
			tail = null;
			size--;
		} else {
			int counter = 0;
			Node temp = head;
			while (counter < size - 2) {
				temp = temp.next;
				counter++;
			}
			temp.next = null;
			tail = temp;
			size--;
		}
	}

	public void removeAt(int pos) {
		if (pos < 0 || pos > size) {
			System.out.println("Position out of bound");
		} else if (pos == 1) {
			removeStart();
		} else if (pos == size) {
			removeEnd();
		} else {
			int counter = 0;
			Node temp = head;
			while (counter < pos - 2) {
				temp = temp.next;
				counter++;
			}
			temp.next = temp.next.next;
			size--;
		}
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int getSize() {
		return size;
	}

	// Driver code
	public static void main(String[] args) {
		/* Start with the empty list. */
		LinkList list = new LinkList();
		LinkList l1 = new LinkList();

		l1.getFirst();
		// ******INSERTION******

		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addStart(7);
		list.addStart(8);
		list.addAt(9, 1);
		System.out.println(list.getAtPosition(4));
		System.out.println(list.getAtIndex(4));
		list.removeEnd();
		list.removeAt(2);
		// Print the LinkedList
		list.display();
	}
}
