package _20220914;

import java.util.Random;

public class RandomNum {

	public static void main(String[] args) {
		Random random = new Random();
		int num = random.nextInt(10);
		String day;
		switch (num) {
		case 0:
			day = "일요일";
			break;
		case 1:
			day = "월요일";
			break;
		case 2:
			day = "화요일";
			break;
		case 3:
			day = "수요일";
			break;
		case 4:
			day = "목요일";
			break;
		case 5:
			day = "금요일";
			break;
		case 6:
			day = "토요일";
			break;
		default:
			day = "요일 없다";
			break;
		}
		System.out.println(num+day);
	}

}
