package linkedlist;

import org.w3c.dom.NodeList;

public class SinglyLinkedList {
	private ListNode head;
	
	private static class ListNode {
		private int data;
		private ListNode next;
		
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	// length of linked list
	public int length() {
		if (head == null) {
			return 0;
		}
		int count = 0;
		ListNode current = head;
		while (current != null) {
			count = count + 1;
			current = current.next;
		}
		return count;
	}
	// print node values
	public void display(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.print("null");
		System.out.println();
	}
	// insert node at the beginning
	public void insertFirst(int value) {
		ListNode newNode = new ListNode(value);
		newNode.next = head;
		head = newNode;
	}
	// insert node at the end of linkedlist
	public void insertLast(int value) {
		ListNode newNode = new ListNode(value);
		if (head == null) {
			head = newNode;
			return;
		}
		ListNode current = head;
		
		while(null != current.next) {
			current = current.next;
		}
		current.next = newNode;
	}
	// insert node at a position in a singly linked list
	public void insert(int position, int value) {
		ListNode node = new ListNode(value);
		if (position == 1) {
			node.next = head;
			head = node;
		} else {
			ListNode previous = head;
			int count = 1;
			while (count < position - 1) {
				previous = previous.next;
				count++;
			}
			ListNode current = previous.next;
			previous.next = node;
			node.next = current;
		}
	}
	// delete the first node from the linked list
	public ListNode deleteFirst() {
		if (head == null) {
			return null;
		}
		ListNode temp = head;
		head = head.next;
		temp.next = null;
		return temp;
	}
	// delete the last node from the linked list
	public ListNode deleteLast() {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode current = head;
		ListNode previous = null;
		
		while (current.next != null) {
			previous = current;
			current = current.next;
		}
		previous.next = null;
		return current;
	}
	// delete a node  from a singly linked list at a position
	public void delete(int position) {
		if (position == 1) {
			head = head.next;
		} else {
			ListNode prev = head;
			int count = 1;
			while (count < position - 1) {
			  prev = prev.next;
			  count++;
			}
			ListNode current = prev.next;
			prev.next = current.next;
		}
	}
	// how to search for a node in a singly linked list in java
	public boolean find(ListNode head, int searchKey) {
		if (head == null) {
			return false;
		}
		ListNode current = head;
		
		while (current != null) {
			if (current.data == searchKey) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
	// how to reverse a singly linked list in Java
	public ListNode reverse (ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;
		
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return  previous;
	}
	// how to find nth node from the end of a linked list
	public ListNode getNthNodeFromEnd(int n) {
		if (head == null) {
			return null;
		}
		
		if (n <= 0) {
			throw new IllegalArgumentException("Invalid value: n = " + n);
		}
		ListNode mainPointer = head;
		ListNode referencePointer = head;
		
		int count = 0;
		
		while (count < n) {
			if (referencePointer == null) {
				throw new IllegalArgumentException(n + "is greater than the number of ref nodes");
			}
			referencePointer = referencePointer.next;
			count++;
		}
		
		while (referencePointer != null) {
			referencePointer = referencePointer.next;
			mainPointer = mainPointer.next;
		}
		return mainPointer;
	}
	// how to remove duplicates from SORTED linked list
	public void removeDuplicates() {
		if (head == null) {
			return;
		}
		ListNode current = head;
		while (current != null && current.next != null) {
			if (current.data == current.next.data) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
	}
	// insert a node in a SORTED singly linked list
	public ListNode insertInSortedList(int value) {
		ListNode newNode = new ListNode(value);
		if (head == null) {
			return newNode;
		}
		
		ListNode current = head;
		ListNode temp = null;
		
		while(current != null && current.data < newNode.data) {
			temp = current;
			current = current.next;
		}
		newNode.next = current;
		temp.next = newNode;
		return head;
	}
	// remove a given key from a singly linked list
	public void deleteNode(int key) {
		ListNode current = head;
		ListNode temp = null;
		
		if (current != null && current.data == key) {
			head = current.next;
			return;
		}
		while (current != null && current.data != key) {
			temp = current;
			current = current.next;
		}
		if (current == null) {
			return;
		}
		
		temp.next = current.next;
	}
	public static void main(String[] args) {
		SinglyLinkedList ssl = new SinglyLinkedList();
		ssl.insertFirst(16);
		ssl.insertFirst(10);
		ssl.insertFirst(8);
		ssl.insertFirst(1);
		
		ssl.insertInSortedList(11);
		ssl.display(ssl.head);
		ssl.deleteNode(10);
		ssl.display(ssl.head);
	}
}
