package array;

public class SecondMaxValue {
	public static int findSecondMaxValue(int[] numbers) {
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > max) {
				secondMax = max;
				max = numbers[i];
			} else if (numbers[i] > secondMax && numbers[i] != max) {
				secondMax = numbers[i];
			}
		}
		return secondMax;
	}
	
	public static void main(String[] args) {
		// given an array of integers, return second maximum number
		int[] numbers = {12, 34, 2, 34, 33, 1};
		int ans = findSecondMaxValue(numbers);
		System.out.println(ans);
	}
	
	
}
