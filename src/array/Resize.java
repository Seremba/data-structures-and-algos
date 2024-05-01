package array;

public class Resize {
	public static int[] resize(int[] arr, int capacity) {
		int[] temp = new int[capacity];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		arr = temp;
		return arr;
	}
	
	public static void main(String[] args) {
		int[] original = new int[] {2, 4, 5, 9, 10};
		System.out.println("Size of origial array " + original.length);
		
		original = resize(original, 10);
		
		System.out.println("Size of original array after resizing, " + original.length);
	}
}
