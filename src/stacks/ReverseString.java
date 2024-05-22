package stacks;
import java.util.Stack;
public class ReverseString {
	public static String reverse (String string) {
		Stack<Character> stack = new Stack<>();
		char[] chars = string.toCharArray();
		
		for (char c : chars) {
			stack.push(c);
		}
		
		for (int i = 0; i < chars.length; i++) {
			chars[i] = stack.pop();
		}
		return new String(chars);
	}
	
	public static void main(String[] args) {
		String abc = "ABCD";
		System.out.println("Before reverse: " + abc);
		System.out.println("After reverse: " + reverse(abc));
	}
}
