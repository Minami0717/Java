package _20221013;

import java.util.Scanner;

class Television {
	boolean isOn;
	int channel;
	int volume;
	
	public Television() {
		isOn = false;
		channel = 1;
		volume = 1;
	}
	
	void power_onoff() {
		if (isOn == false)
			isOn = true;
		else
			isOn = false;
		System.out.println(toString());
	}
	
	void ch_up() {
		if (isOn)
			channel++;
		else
			System.out.println("현재 TV 전원이 꺼져있습니다.\n");
		System.out.println(toString());
	}
	
	void ch_down() {
		if (isOn == false)
			System.out.println("현재 TV 전원이 꺼져있습니다.\n");
		else if (channel > 1)
			channel--;
		else
			System.out.println("현재 채널은 1번입니다.\n");
		System.out.println(toString());
	}
	
	void vol_up() {
		if (isOn)
			volume++;
		else
			System.out.println("현재 TV 전원이 꺼져있습니다.\n");
		System.out.println(toString());
	}
	
	void vol_down() {
		if (isOn == false)
			System.out.println("현재 TV 전원이 꺼져있습니다.\n");
		else if (volume > 0)
			volume--;
		else
			System.out.println("현재 볼륨은 0입니다.\n");
		System.out.println(toString());
	}
	
	void menu_prt() {
		System.out.println("\n1. 전원버튼\n2. 채널 업\n3. 채널 다운\n4. 볼륨 업\n5. 볼륨 다운\n6. 현재 TV 상태\n7. 종료\n");
	}
	
	public String toString() {
		String onoff;
		
		if (isOn)
			onoff = "켜진상태(true)";
		else
			onoff = "꺼진상태(false)";
		
		return "전원 : " + onoff + " 채널 : " + channel + " 볼륨 : " + volume;
	}
}

public class TelevisionMenu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Television tv = new Television();
		
		System.out.println("TV객체가 생성되었습니다.");
		System.out.println(tv.toString());

		while (true) {
			tv.menu_prt();
			
			System.out.print("메뉴 선택하세요. ");
			int menu = scanner.nextInt();
			
			switch (menu) {
			case 1:
				tv.power_onoff();
				break;
			case 2:
				tv.ch_up();
				break;
			case 3:
				tv.ch_down();
				break;
			case 4:
				tv.vol_up();
				break;
			case 5:
				tv.vol_down();
				break;
			case 6:
				System.out.println(tv.toString());
				break;
			case 7:
				System.out.println("종료합니다.");
				return;
			default:
				break;
			}
		}
		
	}

}
