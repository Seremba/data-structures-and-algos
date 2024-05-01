package array;

public class MissingNumber {
	
	public static void main(String[] args) {
		// Given an array nums containing n distinct numbers in the range [0, n],
		// return the only number in the range that is missing from the array.
		// https://leetcode.com/problems/missing-number/
		int [] arr = new int[] {9,6,4,2,3,5,7,0,1};
		int ans = missingNumber(arr);
		System.out.println(ans);
	}
	public static int missingNumber(int[] arr) {
		int n = arr.length;
		int expectedSum = n * (n + 1) / 2;
		int actualSum = 0;
		for (int num: arr) {
			actualSum = actualSum + num;
		}
		return expectedSum - actualSum;
	}
	
}
