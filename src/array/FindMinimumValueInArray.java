package array;

public class FindMinimumValueInArray {
	public static void main(String[] args) {
		// given an array of integers, the task is to find the minimum element in
		// the array input [2, 11, 5, 10, 7, 8], output 2.
		int[] numbers = {1, 2, 11, 5, 10, 7, 8};
		int ans = findMinimumArray(numbers);
		System.out.println(ans);
		
	}
	
	public static int findMinimumArray(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException();
		}
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}
}
