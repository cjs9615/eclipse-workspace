package 자료구조.ch03;


//3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
//comparator 구현 실습
import java.util.Arrays;
import java.util.Random;
public class 실습3_4정수배열이진탐색 {
	static void inputData(int data[]) {
		Random rand = new Random();
		for(int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(50);
		}
	}
	static void showData(int data[]) {
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
	static void swap(int[]arr, int ind1, int ind2) {
		int temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}
	static void sortData(int data[]) {
		for(int i = 0; i < data.length; i++) {
			for(int j = 1; j < data.length - i; j++) {
				if(data[j] < data[j-1]) {
					swap(data, j, j-1);
				}
			}
		}
	}
	static int linearSearch(int data[], int key) {
		for(int i = 0; i < data.length; i++) {
			if(data[i] == key) {
				return i;
			}
		}
		return -1;
	}
	static int binarySearch(int data[], int key) {
		int pl = 0;
		int pr = data.length - 1;
		do {
			int pc = (pl + pr)/2;
			if (data[pc] == key) {
				return pc;
			}
			else if(data[pc] < key) {
				pl = pc + 1;
			}
			else {
				pr = pc - 1;
			}
		} while (pl <= pr);
			
		return -1;
	}
	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data);
		showData(data);
		sortData(data);
		System.out.println();
		for (int num: data) {
			System.out.print(num+" ");
		}
		System.out.println();
		int key = 33;
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);

		key = 39;
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + idx);

	}
}