package _20221013;

class Box {
	int width;
	int length;
	int height;
	int volume;
	
	public Box(int w, int l, int h) {
		width = w;
		length = l;
		height = h;
	}
	
	public int getVolume() {
		volume = width * length * height;
		return volume;
	}
}

public class BoxVolume {

	public static void main(String[] args) {
		Box box = new Box(20, 20, 30);
		System.out.printf("상자의 부피는 %d입니다", box.getVolume());
	}

}
