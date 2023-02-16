package _20221017;

class Car {
	int speed;
	int gear;
	String color;
	
	public void setGear(int gear) {
		this.gear = gear;
	}
	
	public void speedUp(int speed) {
		this.speed += speed;
	}
	
	public void speedDown(int speed) {
		this.speed -= speed;
	}
}

class SportsCar extends Car {
	boolean turbo;
	
	public void setTurbo(boolean turbo) {
		this.turbo = turbo;
	}
}

public class SportsCarEx {

	public static void main(String[] args) {
		SportsCar sportsCar = new SportsCar();
		
		sportsCar.color = "Red";
		sportsCar.speed = 70;
		sportsCar.setGear(3);
		sportsCar.setTurbo(true);
		
		System.out.printf("color=%s, speed=%d, gear=%d, turbo=%s", sportsCar.color, sportsCar.speed, sportsCar.gear, sportsCar.turbo);
	}

}
