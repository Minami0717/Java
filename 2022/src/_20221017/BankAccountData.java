package _20221017;

public class BankAccountData {
	private String name;
	private String accountNum;
	private int money;
	private String password;
	
	BankAccountData(String name, String accountNum, int money, String password) {
		this.name = name;
		this.accountNum = accountNum;
		this.money = money;
		this.password = password;
	}
	
	void list() {
		System.out.println("계좌번호: "+this.accountNum);
		System.out.println("계좌주: "+this.name);
		System.out.println("잔고: "+this.money);
		System.out.println();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
