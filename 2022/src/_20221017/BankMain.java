package _20221017;

public class BankMain {

	public static void main(String[] args) {
		Bank bank = new Bank();
		
		bank.setName("홍길동");
		bank.setMoney(10000);
		
		System.out.printf("이름: %s\n", bank.getName());
		System.out.printf("통장잔고: %d", bank.getMoney());
	}

}
