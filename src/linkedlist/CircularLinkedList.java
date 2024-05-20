package linkedlist;

import java.util.NoSuchElementException;

public class CircularLinkedList {
	private ListNode last;
	private int length;
	
	private class ListNode {
		private ListNode next;
		private int data;
		
		public ListNode(int data) {
			this.data = data;
		}
	}
	
	public CircularLinkedList() {
		last = null;
		length = 0;
	}
	
	public  int length() {
		return length;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	public void createCircularLinkedList() {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(5);
		ListNode third = new ListNode(10);
		ListNode fourth = new ListNode(15);
		
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = first;
		
		last = fourth;
	}
	// how to traverse and print a cicular linked list in Java
	public void display() {
		if (last == null) {
			return;
		}
		
		ListNode first = last.next;
		
		while (first != last) {
			System.out.print(first.data + " ");
			first = first.next;
		}
		
		System.out.print(first.data);
	}
	// how to insert a node at the beginning of a circular linked list
	public void insertFirst(int data) {
		ListNode temp = new ListNode(data);
		if (last == null) {
			last = temp;
		} else {
			temp.next = last.next;
		}
		last.next = temp;
		length++;
	}
	//how to insert a node at the end of a circular linked list
	public void insertLast(int data) {
		ListNode temp = new ListNode(data);
		if (last == null){
			last = temp;
			last.next= last;
		} else {
			temp.next = last.next;
			last.next = temp;
			last = temp;
		}
		length++;
	}
	
	// how to remove first node from a circular linked list
	public ListNode removeFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		ListNode temp = last.next;
		
		if (last.next == last) {
			last = null;
		} else {
			last.next = temp.next;
		}
		temp.next = null;
		length--;
		return temp;
	}
	
	public static void main(String[] args) {
		CircularLinkedList csll = new CircularLinkedList();
		// csll.createCircularLinkedList();
		csll.insertLast(10);
		csll.insertLast(12);
		csll.insertLast(15);
		csll.display();
		
		csll.removeFirst();
		csll.removeFirst();
		csll.removeFirst();
		csll.removeFirst();
		System.out.println();
		csll.display();
	}
}
