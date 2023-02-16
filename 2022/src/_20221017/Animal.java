package _20221017;

class Animal {
	void eat() {
		System.out.println("eat()가 호출되었음");
	}
	
	void sleep() {
		System.out.println("sleep()가 호출되었음");
	}
}

class Lion extends Animal{
	void roar() {
		System.out.println("roar()가 호출되었음");
	}
}

class Eagle extends Animal{
	void fly() {
		System.out.println("fly()가 호출되었음");
	}
}