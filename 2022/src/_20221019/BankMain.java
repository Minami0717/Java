package _20221019;

public class BankMain {

	public static void main(String[] args) {
		BadBank badBank = new BadBank();
		NormalBank normalBank = new NormalBank();
		GoodBank goodBank = new GoodBank();
		
		System.out.println("BadBank의 이자율: " + badBank.rate());
		System.out.println("NormalBank의 이자율: " + normalBank.rate());
		System.out.println("GoodBank의 이자율: " + goodBank.rate());
	}

}
