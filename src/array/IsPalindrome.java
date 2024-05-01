package array;

public class IsPalindrome {
	// Given a string, the task is to check whether it is palindrome o not
	// example: madam -> true, that -> false
	public static void main(String[] args) {
		boolean ans = isPalindrome("that");
		System.out.println(ans);
	}
	
	public static boolean isPalindrome(String word) {
		char [] charArray = word.toCharArray();
		int start = 0;
		int end = charArray.length - 1;
		
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[start] != charArray[end]) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
