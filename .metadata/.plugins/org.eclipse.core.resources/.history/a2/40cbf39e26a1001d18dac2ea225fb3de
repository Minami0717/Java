import java.util.Scanner;

public class PrimeCheck {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력 : ");
		long n = scanner.nextLong();
		boolean isPrime = true;
		
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				isPrime = false;
				break;
			}
		}
		if (isPrime)
			System.out.println("소수");
		else
			System.out.println("소수아님");
	}

}
