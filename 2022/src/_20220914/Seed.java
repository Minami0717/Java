package _20220914;

import java.util.Random;

public class Seed {

	public static void main(String[] args) {
		Random random = new Random(12);
		random.setSeed(System.currentTimeMillis());
		int rndsu;
		
		for (int i = 0; i < 10; i++) {
			rndsu = random.nextInt(1000);
			System.out.println(rndsu);
		}
	}

}
