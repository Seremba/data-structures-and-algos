package array;

public class MoveZeros {
  // Given an integer array nums, move all 0's to the end of it while maintaining the
  // relative order of the non-zero elements. Input: nums = [0,1,0,3,12], Output: [1,3,12,0,0]
	public static void moveZeros(int[] arr) {
		int j = 0; // tracks zero elements
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0 && arr[j] == 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			
			if (arr[j] != 0) {
				j++;
			}
		}
	}
	public static void printNums(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// given an array of integers, return second maximum number
		int[] numbers = {0,1,0,3,12};
		moveZeros(numbers);
		printNums(numbers);
	}
}
