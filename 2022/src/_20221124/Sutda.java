package _20221124;

import java.util.Random;
import java.util.Scanner;

class Result {
	int score;
	String result;
	
	Result(int score, String result) {
		this.score = score;
		this.result = result;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getResult() {
		return result;
	}
}

public class Sutda {
	
	public Sutda() {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		int money = 100000;
		
		
		System.out.println("1. 게임 시작 2. 게임 종료");
		System.out.print("선택 : ");
		int i = scanner.nextInt();
		
		while (i == 1) {
			int com1 = random.nextInt(10)+1;
			int com2 = random.nextInt(10)+1;
			int user1 = random.nextInt(10)+1;
			int user2 = random.nextInt(10)+1;
			
			Result comResult = r(com1, com2);
			Result userResult = r(user1, user2);
			
			System.out.print("시작 베팅금 : ");
			int betMoney = scanner.nextInt();
			money -= betMoney;
			
			System.out.println("소지금 : " + money);
			System.out.println("\n컴퓨터 : " + com1);
			System.out.println("사용자 : " + user1);
			
			int n = 0;
			while (n != 4) {
				System.out.println("\n현재 베팅금 : " + betMoney);
				System.out.println("1. 하프 : +" + betMoney * 2);
				System.out.println("2. 콜 : +" + betMoney);
				System.out.println("3. 쿼터 : +" + (betMoney + betMoney/2));
				System.out.println("4. 다이");
				System.out.print("선택 : ");
				n = scanner.nextInt();
				System.out.println();
				
				if (n == 1) {
					money -= betMoney * 2;
					betMoney += betMoney * 4;
					System.out.println("소지금 : " + money);
				}
				else if (n == 2) {
					money -= betMoney;
					betMoney += betMoney * 2;
					System.out.println("소지금 : " + money);
					break;
				}
				else if (n == 3) {
					money -= (betMoney + betMoney/2);
					betMoney += (betMoney + betMoney/2) * 2;
					System.out.println("소지금 : " + money);
				}
			}
			
			System.out.println("\n컴퓨터 : " + com1 + " " + com2 + " " + comResult.result);
			System.out.println("사용자 : " + user1 + " " + user2 + " " + userResult.result);
			
			if (comResult.score > userResult.score || n == 4) {
				System.out.println("패배");
				System.out.println("소지금 : " + money);
			}
			else if (comResult.score < userResult.score) {
				money += betMoney;
				System.out.println("승리");
				System.out.println("소지금 : " + money);
			}
			else {
				System.out.println("재경기");
			}
			
			System.out.println("\n1. 다시하기 2. 게임 종료");
			i = scanner.nextInt();
		}
		
		System.out.println("게임을 종료합니다.");
	}
	
	public void game() {
		
	}
	
	public Result r(int num1, int num2) {
		int score = 0;
		String result = "";
		
		if ((num1 == 3 && num2 == 8) || (num1 == 8 && num2 == 3)) {
			score = 3838;
			result = "38광땡";
		}
		else if ((num1 == 1 && num2 == 8) || (num1 == 8 && num2 == 1)) {
			score = 1818;
			result = "18광땡";
		}
		else if ((num1 == 1 && num2 == 3) || (num1 == 3 && num2 == 1)) {
			score = 1313;
			result = "13광땡";
		}
		else if ((num1 == 1 && num2 == 2) || (num1 == 2 && num2 == 1)) {
			score = 90;
			result = "알리";
		}
		else if ((num1 == 1 && num2 == 4) || (num1 == 4 && num2 == 1)) {
			score = 80;
			result = "독사";
		}
		else if ((num1 == 1 && num2 == 9) || (num1 == 9 && num2 == 1)) {
			score = 70;
			result = "구삥";
		}
		else if ((num1 == 1 && num2 == 10) || (num1 == 10 && num2 == 1)) {
			score = 60;
			result = "장삥";
		}
		else if ((num1 == 10 && num2 == 4) || (num1 == 4 && num2 == 10)) {
			score = 50;
			result = "장사";
		}
		else if ((num1 == 4 && num2 == 6) || (num1 == 6 && num2 == 4)) {
			score = 40;
			result = "세륙";
		}
		else if (num1 == num2) {
			result = num1 + "땡";
			if (num1 == 10)
				score = 1000;
			else if (num1 == 9)
				score = 900;
			else if (num1 == 8)
				score = 800;
			else if (num1 == 7)
				score = 700;
			else if (num1 == 6)
				score = 600;
			else if (num1 == 5)
				score = 500;
			else if (num1 == 4)
				score = 400;
			else if (num1 == 3)
				score = 300;
			else if (num1 == 2)
				score = 200;
			else if (num1 == 1)
				score = 100;
		}
		else {
			score = num1 + num2;
			String s = Integer.toString(score);
			
			if (s.length() == 2) {
				result = s.substring(1) + "끗";
				score = Integer.parseInt(s.substring(1));
			}
			else if (s.equals("10") || s.equals("0"))
				result = "망통";
			else
				result = s + "끗";
		}
		
		return new Result(score, result);
	}

	public static void main(String[] args) {
		new Sutda();
	}
}
