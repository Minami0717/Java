package _20221006;

public class ArrayTest {

	public static void main(String[] args) {
		int[] array;
		array = getData();
		printData(array);
	}
	
	public static int[] getData() {
		int[] arr = {10,20,30,40,50};
		return arr;
	}
	
	private static void printData(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
