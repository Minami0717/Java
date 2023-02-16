package _20221014;

public class FriendData {
	String name;
	String phone;
	int birth;
	String addr;
	
	FriendData(String name, String phone, int birth, String addr) {
		this.name = name;
		this.phone = phone;
		this.birth = birth;
		this.addr = addr;
	}
	
	void print() {
		System.out.printf("\n이름: %s\n", name);
		System.out.printf("전화: %s\n", phone);
		System.out.printf("생년월일: %d\n", birth);
		if (this.addr != null)
			System.out.printf("주소: %s\n", addr);
	}
}
