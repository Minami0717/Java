package _20221014;

public class DrinkData {
	String name;
	int ml;
	int num;
	int price;
	static int total = 0;
	
	DrinkData(String name, int ml, int num, int price) {
		this.name = name;
		this.ml = ml;
		this.num = num;
		this.price = price;
	}
}
