package 자료구조.ch06;

import java.util.Arrays;

//PhyscData 클래스를 Comparable로 수정해야 한다.
//stack을 이용한 객체들의 non-recursive MergeSort 구현

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

public class Chap6_Test_MergeSort {
	//MergeSort() 구현 소스 코드를 사용하여 객체들의 정렬 소스코드로 수정한다.
	
	static void merge(PhyscData[] a, int lefta, int righta, int leftb, int rightb) {
		PhyscData[] temp = new PhyscData[a.length];
		int ix = 0;
		int p = lefta;
		int q = leftb;

		while (p <= righta && q <= rightb) {
			if (a[p].compareTo(a[q]) < 0)
				temp[ix++] = a[p++];
			else if (a[p].compareTo(a[q]) > 0)
				temp[ix++] = a[q++];
			else {
				temp[ix++] = a[p++];
				temp[ix++] = a[q++];
			}
		}
		while (p > righta && q <= rightb)
			temp[ix++] = a[q++];
		while (p <= righta && q > rightb)
			temp[ix++] = a[p++];

		for (int j = 0; j < ix; j++) {
			a[lefta + j] = temp[j];
		}

	}

	static void MergeSort(PhyscData[] a, int left, int right) {
		int mid = (left + right) / 2;
		if (left == right)
			return;
		MergeSort(a, left, mid);
		MergeSort(a, mid + 1, right);
		merge(a, left, mid, mid + 1, right);
		return;
	}

	public static void main(String[] args) {
		PhyscData[] x = {
			         new PhyscData("강민하", 162, 0.3),
			         new PhyscData("장경오", 171, 1.7),
			         new PhyscData("박준서", 171, 2.0),
			         new PhyscData("유서범", 171, 1.5),
			         new PhyscData("유서범", 168, 0.4),
			         new PhyscData("장경오", 171, 1.2),
			         new PhyscData("황지안", 169, 0.8),
		};
		int nx = x.length;

		MergeSort(x, 0, nx - 1); // 배열 x를 퀵정렬
		System.out.println("오름차순으로 정렬했습니다.");
		System.out.println("■ 신체검사 리스트 ■");
		System.out.println(" 이름     키  시력");
		System.out.println("------------------");
		for (int i = 0; i < x.length; i++)
			System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
	}

}
