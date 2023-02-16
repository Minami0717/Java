package _20221013;

class PaymentEx {
	String name;
	int ml;
	int count;
	
	public PaymentEx(String name, int ml, int count) {
		this.name = name;
		this.ml = ml;
		this.count = count;
	}
	
	int total() {
		return this.ml * this.count;
	}
}

public class Drink {

	public static void main(String[] args) {
		PaymentEx coffee = new PaymentEx("커피", 200, 3);
		PaymentEx greenTea = new PaymentEx("녹차", 150, 2);
		System.out.println("상품명\t단위\t수량\t금액");
		System.out.printf("%s\t%d\t%d\t%d\n", coffee.name, coffee.ml, coffee.count, coffee.total());
		System.out.printf("%s\t%d\t%d\t%d\n", greenTea.name, greenTea.ml, greenTea.count, greenTea.total());
		System.out.printf("\n*** 합계금액 %d 원", coffee.total() + greenTea.total());
	}

}
