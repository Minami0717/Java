package _20221013;

public class PhoneBook01 {

	public static void main(String[] args) {
		PhoneBook jinho = new PhoneBook("김진호", "1234-1111", "대구시 북구");
		PhoneBook yujin = new PhoneBook("고유진", "1234-2222", null);
		jinho.print();
		yujin.print();
	}
}
