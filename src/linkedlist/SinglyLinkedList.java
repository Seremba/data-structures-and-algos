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
	public void display() {
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
	// how to for a node search in a linkedlist in java
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
	
	// connect nodes
	public static void main(String[] args) {
		SinglyLinkedList ssl = new SinglyLinkedList();
		ssl.insert(1, 2);
		ssl.insert(2, 7);
		ssl.insert(3,10);
		ssl.insert(4, 13);
		
		if (ssl.find(ssl.head, 7)) {
			System.out.println("Search key found!!!");
		} else {
			System.out.println("Search key not found!!!");
		}
	}
}
