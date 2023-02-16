package _20221019;

class Animal {
	void eat() {
		System.out.println("동물이 먹고 있습니다.");
	}
}

class Dog extends Animal {
	@Override
	void eat() {
		System.out.println("강아지가 먹고 있습니다.");
	}
}

public class Overriding {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.eat();
	}
}
