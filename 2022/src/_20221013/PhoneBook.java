package _20221013;

class PhoneBook {
	String name;
	String phone;
	String addr;
	
	PhoneBook(String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	
	void print() {
		System.out.printf("name: %s\n", name);
		System.out.printf("phone: %s\n", phone);
		if (this.addr != null)
			System.out.printf("addr: %s\n\n", addr);
	}
}