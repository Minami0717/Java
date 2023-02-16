package _20220908;

public class MathRandom {

	public static void main(String[] args) {
		int randd;
		double rand1 = (Math.random()*6);
		
		int rand2 = (int)(Math.random()*6);
		int rand3 = (int)(Math.random()*6)+1;
		int rand4 = (int)(Math.random()*6)+10;
		
		for (int i = 0; i < 6; i++) {
			randd = (int)(Math.random()*46);
			System.out.println(randd);
		}
	}

}
