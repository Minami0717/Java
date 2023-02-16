package _20221130;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		// ArrayList
		// - 배열을 가변으로 다룰 수 있음
		// - 객체의 삽입, 삭제, 이동이 쉽도록 구성
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		arrayList.add(1);
		arrayList.add(3);
		arrayList.add(10);
		arrayList.add(null);

		for (int i = 0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i) + " ");
		}
		
		arrayList.add(2, 5);
		System.out.println();
		
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i) + " ");
		}
		
		arrayList.remove(3);
		System.out.println();
		
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i) + " ");
		}
		
		System.out.println();
		System.out.println(arrayList.size());
		arrayList.clear();
		System.out.println(arrayList.size());
		System.out.println(arrayList);
	}

}
