package _20221017;

public class AccountMain {

	public static void main(String[] args) {
		
		AccountData kim = new AccountData("김진호", 12345, 10000, 10.0);
		AccountData park = new AccountData();
		
		park.setName("박효신");
		park.setAccountNum(928375);
		park.setMoney(20000);
		park.setRate(20.0);
		
		kim.print();
		park.print();
	}

}
