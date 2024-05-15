package linkedlist;

public class DoublyLinkedList {
	private ListNode head;
	private ListNode tail;
	private int length;
	
	private class ListNode {
		private int data;
		private ListNode next;
		private ListNode previous;
		
		public ListNode(int data) {
			this.data = data;
		}
	}
	
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public int length() {
		return length;
	}
	
	// how to print elements of a doubly linked list
	public void displayForward() {
		if (head == null) {
			return;
		}
		ListNode temp = head;
		
		while (temp != null) {
			System.out.print(temp.data + " ->");
			temp = temp.next ;
		}
		System.out.print("null");
	}
	public void displayBackward() {
		if (tail == null) {
			return;
		}
		ListNode temp = tail;
		
		while (temp != null) {
			System.out.print(temp.data + " ->");
			temp = temp.previous;
		}
		System.out.print("null");
	}
	
	public static void main(String[] args) {
	
	}
}
