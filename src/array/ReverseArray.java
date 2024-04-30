package array;

public class ReverseArray {
	public static void main(String[] args) {
		// given an array or string, the task is to reverse the array or string
		// input [2, 11, 5, 10, 7, 8], output [8, 7, 10, 5, 11, 2]
		int[] numbers = {2, 11, 5, 10, 7, 8};
		reverseArray(numbers, 0, numbers.length - 1);
		printNums(numbers);
		
	}
	public static void printNums(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public static void reverseArray(int[] arr, int start, int end) {
		while(start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
}
