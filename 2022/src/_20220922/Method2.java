package _20220922;

public class Method2 {

	public static int sum(int num1, int num2) {
		int sum = 0;
		
		for (int i = num1; i <= num2; i++) {
			sum += i;
		}
		
		return sum;
	}
	public static void main(String[] args) {
		System.out.println("합(1~10):" + sum(1, 10));
		System.out.println("합(10~100):" + sum(10, 100));
		System.out.println("합(100~1000):" + sum(100, 1000));
	}

}
