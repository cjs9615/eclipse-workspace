package mission;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.Random;

public class SelectionSort {
	private int [] createArr() {
		int arr[] = new int[10];
		Random random = new Random();
		for(int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(1,101);
			for(int j = 0; j < i; j++) {
				while(arr[i] == arr[j]) {
					arr[i] = random.nextInt(1,101);
				}
			}
		}
		return arr;
	}
	private int [] readFile() {
		int arr[] = new int[10];
		try(BufferedReader br = new BufferedReader(new FileReader("sortinput.txt"))) {
			for(int i = 0; i < arr.length; i++) {
				String s = br.readLine();
				arr[i] = Integer.parseInt(s);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
	private void createFile() {
		int arr[] = new int[10];
		Random random = new Random();
		try{BufferedWriter bw = new BufferedWriter(new FileWriter("sortinput.txt"));
			for(int i = 0; i < arr.length; i++) {
				arr[i] = random.nextInt(1,101);
				for(int j = 0; j < i; j++) {
					while(arr[i] == arr[j]) {
						arr[i] = random.nextInt(1,101);
					}
				}
				bw.write(arr[i] + "\n");
			}
			bw.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	private void printArr(int arr[]) {
		for(int i: arr) {
			System.out.print(i + " ");
		}
		System.out.println("\n" + "=".repeat(30));
	}
	private int [] selectionSort(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			int max = 0;
			int index = 0;
			for(int j = 0; j < arr.length-i; j++) {
				if(arr[j] > max) {
					max = arr[j];
					index = j;
				}
			}
			arr[index] = arr[arr.length-i-1];
			arr[arr.length-i-1] = max;
		}
		return arr;
	}
	private int [] bubbleSort(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			int big = 0;
			int small = 0;
			for(int j = 1; j < arr.length-i; j++) {
				if(arr[j] < arr[j-1]) {
					big = arr[j-1];
					small = arr[j];
					arr[j-1] = small;
					arr[j] = big;
				}
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		SelectionSort ss = new SelectionSort();
		ss.createFile();
		System.out.println();
		int arr[] = ss.readFile();
		ss.printArr(arr);
		int arr1[] = ss.selectionSort(arr);
		int arr2[] = ss.bubbleSort(arr);
		ss.printArr(arr1);
		ss.printArr(arr2);
	}
}
