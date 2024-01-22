package 자료구조.ch03;

import java.util.Arrays;


//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData implements Comparable<PhyscData>{
	String name;
	int height;
	double vision;

	public PhyscData(String name, int height, double vision){
		this.name = name; this.height = height; this.vision = vision;
	}
	
	@Override
	public int compareTo(PhyscData p) {
		int nameResult = this.name.compareTo(p.name);
		if(nameResult != 0) {
			return nameResult;
		}
		int heightResult = this.height - p.height;
		if(heightResult != 0) {
			return heightResult;
		}
		double visionResult = this.vision - p.vision;
		if(visionResult > 0) {
			return 1;
		}
		else if(visionResult < 0) {
			return -1;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		return "[name=" + name + "\t height=" + height + "\t vision=" + vision + "]";
	}
	
}
public class 실습3_6_1객체배열이진탐색 {
	static void showData(PhyscData[]arr) {
		for (PhyscData physcData: arr) {
			System.out.println(physcData);
		}
		System.out.println();
	}
	static void sortData(PhyscData arr[]) {
		//Arrays.sort(arr);
		for(int i = 0; i < arr.length; i++) {
			for(int j = 1; j < arr.length - i; j++) {
				if(arr[j-1].compareTo(arr[j]) > 0) {
					swap(arr, j, j-1);
				}
			}
		}
	}
	static void swap(PhyscData[]arr, int ind1, int ind2) {
		PhyscData temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}
	static int linearSearch(PhyscData arr[], PhyscData key) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].compareTo(key) == 0) {
				return i;
			}
		}
		return -1;
	}
	static int binarySearch(PhyscData arr[], PhyscData key) {
		int pl = 0;
		int pr = arr.length - 1;
		
		do {
			int pc = (pl + pr)/2;
			if(arr[pc].compareTo(key) == 0) {
				return pc;
			}
			else if(arr[pc].compareTo(key) < 0) {
				pl = pc + 1;
			}
			else {
				pr = pc - 1;
			}
		} while(pl <= pr);
		
		return -1;
	}
	public static void main(String[] args) {
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("길동", 182, 0.6),
				new PhyscData("길동", 167, 0.2),
				new PhyscData("길동", 167, 0.5),
		};
		showData(data);
		sortData(data);
		showData(data);
		PhyscData key = new PhyscData("길동", 167, 0.2);
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);
		key = new PhyscData("길동", 167, 0.5);

		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		result = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + result);
	}
	
}
