package _20220926;

public class ArrayEx {

	public static void main(String[] args) {
		int[] numbers = new int[5];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random()*1000);
		}
		
		for (int value : numbers) {
			System.out.print(value+" ");
		}
	}

}
