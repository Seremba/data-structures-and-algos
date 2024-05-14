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
	// detect a loop in a linked list in java
	public boolean containsLoop() {
		ListNode fastPointer = head;
		ListNode slowPointer = head;
		
		while (fastPointer != null && fastPointer.next != null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
			
			if (slowPointer == fastPointer) {
				return true;
			}
		}
		
		return false;
	}
	// create a loop in a linked list
	public void createALoopInLinkedList() {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		ListNode sixth = new ListNode(6);
		
		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = third; // loop
		
	}
	
	// how to find the start of a loop in a singly linked list(Floyd cycle detection)
	public ListNode startNodeInALoop() {
		ListNode fastPointer = head;
		ListNode slowPointer = head;
		
		while (fastPointer != null && fastPointer.next != null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
			
			if (slowPointer == fastPointer) {
				return getStartingNode(slowPointer);
			}
		}
		
		return null;
	}
	
	private ListNode getStartingNode(ListNode slowPointer) {
		ListNode temp = head;
		while (temp != slowPointer) {
			temp = temp.next;
			slowPointer =slowPointer.next;
		}
		return temp; // starting node of the loop
	}
	// how to remove a loop from a singly linked list
	public void removeLoop() {
		ListNode fastPointer = head;
		ListNode slowPointer = head;
		
		while (fastPointer != null && fastPointer.next != null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
			
			if (slowPointer == fastPointer) {
				 removeLoop(slowPointer);
				return;
			}
		}
		
	}
	
	private void removeLoop(ListNode slowPointer) {
		ListNode temp = head;
		while (temp.next != slowPointer.next) {
			temp = temp.next;
			slowPointer =slowPointer.next;
		}
		slowPointer.next = null;
	}
	// merge two sorted linked lists
	public static ListNode merge(ListNode a, ListNode b) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		
		while (a != null && b != null) {
			if (a.data <= b.data) {
				tail.next = a;
				a = a.next;
			} else {
				tail.next = b;
				b = b.next;
			}
			tail = tail.next;
		}
		
		if (a == null) {
			tail.next = b;
		} else {
			tail.next = a;
		}
		
		return dummy.next;
	}
	
	// add two singly linked list https://leetcode.com/problems/add-two-numbers/description/
	public static ListNode add(ListNode a, ListNode b) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		int carry = 0;
		
		while (a != null || b != null) {
			int x = (a != null) ? a.data : 0;
			int y = (b != null) ? b.data : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			tail.next = new ListNode(sum % 10);
			tail = tail.next;
			if (a != null) a = a.next;
			if (b != null) b = b.next;
		}
		if (carry > 0) {
			tail.next = new ListNode(carry);
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		SinglyLinkedList ssl1 = new SinglyLinkedList();
		ssl1.insertLast(1);
		ssl1.insertLast(4);
		ssl1.insertLast(8);
		
		SinglyLinkedList ssl2 = new SinglyLinkedList();
		ssl2.insertLast(3);
		ssl2.insertLast(5);
		ssl2.insertLast(8);
		ssl1.insertLast(9);
		ssl1.insertLast(14);
		ssl1.insertLast(18);
		
		ssl2.display();
		ssl1.display();
		
		SinglyLinkedList result = new SinglyLinkedList();
		result.head = merge(ssl1.head, ssl2.head);
		
		result.display();
	}
}
