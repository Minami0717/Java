package _20220908;

import java.util.Random;

public class ClassRandom {

	public static void main(String[] args) {
		Random rand = new Random();
		int num;
		
		int num1 = rand.nextInt();
		int num2 = rand.nextInt(10);
		int num3 = rand.nextInt(10)+1;
		int num4 = rand.nextInt(50)+10;
		
		for (int i = 0; i < 6; i++) {
			num = rand.nextInt(46);
			System.out.println(num);
		}
	}

}
