package 자료구조.ch02;

import java.util.Arrays;

class PhyscData2 implements Comparable<PhyscData2>{
	String name;
	int height;
	double vision;
	
	public PhyscData2(String name, int height, double vision) {
		this.name = name; this.height = height; this.vision = vision;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", height=" + height + ", vision=" + vision + "]";
	}

	@Override
	public int compareTo(PhyscData2 o) {
		int result = this.name.compareTo(o.name);
		if(result != 0) {
			return result;
		}
		int heightResult = this.height - o.height;
		if(heightResult != 0) {
			return heightResult;
		}
		double visionResult = this.vision - o.vision;
		if(visionResult > 0) {
			return 1;
		}
		else if(visionResult < 0) {
			return -1;
		}
		return 0;
	}
	

}
public class 실습2_14객체배열정렬 {

	public static void main(String[] args) {
		PhyscData2[] data = {
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("홍동", 164, 1.3),
				new PhyscData2("홍길", 152, 0.7),
				new PhyscData2("김홍길동", 172, 0.3),
				new PhyscData2("이길동", 182, 0.6),
				new PhyscData2("박길동", 167, 0.2),
				new PhyscData2("최길동", 169, 0.5),
		};
		showData(data);
		sortData(data);
		showData(data);
	}

	static void showData(PhyscData2[] data) {
		for(int i = 0; i < data.length; i++) {
			System.out.println(data[i].toString());
		}
		System.out.println();
	}
	static void sortData(PhyscData2[] data) {
		//Arrays.sort(data);
		for(int i = 0; i < data.length; i++) {
			for(int j = 1; j < data.length - i; j++) {
				if(data[j-1].compareTo(data[j]) > 0) {
					swap(data, j, j-1);
				}
			}
		}
	}
	static void swap(PhyscData2[]arr, int ind1, int ind2) {
		PhyscData2 temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}
}

