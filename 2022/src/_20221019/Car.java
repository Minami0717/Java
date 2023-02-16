package _20221019;

public class Car {
	int gasoline;
	
	Car(int gasoline) {
		this.gasoline = gasoline;
	}
}

class HybridCar extends Car {
	int electric;
	
	HybridCar(int gasoline, int electric) {
		super(gasoline);
		this.electric = electric;
	}
}

class HybridWaterCar extends HybridCar {
	int water;
	
	HybridWaterCar(int gasoline, int electric, int water) {
		super(gasoline, electric);
		this.water = water;
	}
	
	public void showCurrent() {
		System.out.println("잔여 가솔린: "+gasoline);
		System.out.println("잔여 전기량: "+electric);
		System.out.println("잔여 워터량: "+water);
	}
}