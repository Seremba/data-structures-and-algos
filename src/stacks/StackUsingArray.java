package stacks;

public class StackUsingArray {
	private int top;
	private int[] arr;
	
	public StackUsingArray(int capacity) {
		top = -1;
		arr = new int[capacity];
	}
	
	public StackUsingArray() {
		this(10);
	}
	
	public void push(int data) {
		if (isFull()) {
			throw new RuntimeException("Stack is full!!!");
		}
		top++;
		arr[top] = data;
	}
	
	public boolean isFull() {
		return arr.length == size();
	}
	public int size() {
		return top + 1;
	}
	
	public int pop() {
		if (isEmpty()) {
			throw  new RuntimeException("Stack is empty!!!");
		}
		int result = arr[top];
		top--;
		return result;
	}
	
	public boolean isEmpty() {
		return top < 0;
	}
	
	public int peek() {
		if (isEmpty()) {
			throw  new RuntimeException("Stack is empty!!!");
		}
		
		return arr[top];
	}
	public static void main(String[] args) {
	
	}
}
