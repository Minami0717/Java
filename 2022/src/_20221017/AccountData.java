package _20221017;

public class AccountData {
	private String name;
	private int accountNum;
	private int money;
	private double rate;
	private int total;
	
	public AccountData(String name, int accountNum, int money, double rate) {
		this.name = name;
		this.accountNum = accountNum;
		this.money = money;
		this.rate = rate;
	}
	
	public AccountData() {
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAccountNum() {
		return accountNum;
	}
	
	public int getMoney() {
		return money;
	}
	
	public double getRate() {
		return rate;
	}
	
	public int getTotal() {
		this.total += money + (money*rate/100);
		return total;
	}
	
	void print() {
		System.out.println("예금주: " + this.getName());
		System.out.println("계좌번호: " + this.getAccountNum());
		System.out.println("예금액: " + this.getMoney());
		System.out.println("이율: " + this.getRate());
		System.out.println("원리금합계: " + this.getTotal());
		System.out.println();
	}
}
