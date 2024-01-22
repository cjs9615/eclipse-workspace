package 자료구조.ch02;

public class 실습2_14스트링배열정렬 {
	public static void main(String[] args) {
		String []data = {"apple","grape","persimmon", "pear","blueberry", "strawberry", "melon", "oriental melon"};
		
		showData(data);
		sortData(data);
		showData(data);
	}
	static void showData(String[]arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print("'"+ arr[i] + "' ");
		}
		System.out.println();
	}

	static void swap(String[]arr, int ind1, int ind2) {
		String temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}
	static void sortData(String []arr) {
		//compareto사용
		for(int i = 0; i < arr.length; i++) {
			for(int j = 1; j < arr.length - i; j++) {
				if(arr[j].compareTo(arr[j-1]) < 0) {
					swap(arr, j, j-1);
				}
			}
		}
	}
}
