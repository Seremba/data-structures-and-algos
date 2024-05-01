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
	// connect nodes
	public static void main(String[] args) {
		SinglyLinkedList ssl = new SinglyLinkedList();
//		ssl.head = new ListNode(10);
//		ListNode second = new ListNode(1);
//		ListNode third = new ListNode(8);
//		ListNode forth = new ListNode(11);
//		ssl.head.next = second;
//		second.next = third;
//		third.next = forth;
		ssl.insertLast(15);
		ssl.insertLast(8);
		ssl.insertLast(1);
		ssl.insertLast(12);
		ssl.display(); // display node values
		int len = ssl.length();
		System.out.println("The length of singly linked list is \n" + len);
	}
}
