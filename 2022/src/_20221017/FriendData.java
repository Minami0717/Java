package _20221017;

public class FriendData {
	String name;
	String phone;
	String addr;
	
	FriendData(String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	
	void print() {
		System.out.printf("\n이름: %s\n", name);
		System.out.printf("전화: %s\n", phone);
		System.out.printf("주소: %s\n", addr);
	}
}

class SchoolData extends FriendData{
	String major;
	String year;
	
	SchoolData(String name, String phone, String addr, String major, String year) {
		super(name, phone, addr);
		this.major = major;
		this.year = year;
	}

	@Override
	void print() {
		super.print();
		System.out.printf("전공: %s\n", major);
		System.out.printf("학년: %s\n", year);
	}
}

class CompanyData extends FriendData{
	String company;
	
	CompanyData(String name, String phone, String addr, String company) {
		super(name, phone, addr);
		this.company = company;
	}

	@Override
	void print() {
		super.print();
		System.out.printf("회사: %s\n", company);
	}
}