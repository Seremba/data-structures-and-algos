public class Main {
	
	public static void main(String[] args) {
		// Given an array of integers, return a new array with even integers removed.
		int[] ans = removeEvens(new int[]{3, 2, 4, 7, 10, 6, 5});
		printNums(ans);
	}
	
	public static void printNums(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public static int[] removeEvens(int[] nums) {
		// get the number of odds in the given array
		int odds = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 != 0) {
				odds++;
			}
		}
		// create an array for odd numbers
		int[] returnArr = new int[odds];
		int index = 0;
		// populate odd numbers into the array
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 != 0) {
				returnArr[index] = nums[i];
				index++;
			}
		}
		return returnArr;
	}
	
	
}
