import java.time.LocalTime;

public class PrimeNumber {

	public static void main(String[] args) {
		int t1 = LocalTime.now().getSecond();
		System.out.println("시간 : " + LocalTime.now());
		for (int i = 3; i < 1500000; i=i+2) {
			boolean isPrime = true;
			for (int j = 3; j <= Math.sqrt(i); j=j+2) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime)
				System.out.print(i+" ");
		}
		int t2 = LocalTime.now().getSecond();
		System.out.println("\n시간 : " + LocalTime.now());
		System.out.println(t2-t1+"초");
	}
}