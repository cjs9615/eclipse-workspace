package 자료구조.ch02;

//3번 실습
//교재 62 - 두 배열의 비교
//교재 79 - 다차원배열
import java.util.Random;
public class 실습2_7다차원배열 {
	public static void main(String[] args) {
		int [][]A = new int[2][3];
		int [][]B = new int[3][4];
		int [][]C = new int[2][4];
		int [][]D = new int[2][3];
		inputData(A);inputData(B);inputData(D);
		System.out.println("A[][]");
		showData(A);
		System.out.println("D[][]");
		showData(D);
		System.out.println();
		System.out.println("B[][]");
		showData(B);
		int [][]E = addMatrix(A,D);
		System.out.println("E[][]");
		showData(E);
		int [][]F = multiplyMatrix(A,B);
		System.out.println("F[][]");
		showData(F);
		int [][]G = transposeMatrix(A);
		showData(G);
		int [][]H = {{1,2},{2,3}};
		int [][]I = {{1,2},{2,3}};
		boolean result = equals(H, I);
		System.out.println(" equals(H,I)= " + result);
	}
	static void inputData(int [][]data) {
		Random rand = new Random();
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[0].length; j++) {
				data[i][j] = rand.nextInt(10);
			}
		}
	}
	static void showData(int[][]items) {
		for(int i = 0; i < items.length; i++) {
			for(int j = 0; j < items[0].length; j++) {
				System.out.print(items[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	static boolean equals(int[][]a, int[][]b) {
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				if(a[i][j] != b[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	static int[][] addMatrix(int [][]X, int[][]Y) {
		int [][] result = new int[X.length][X[0].length];
		for(int i = 0; i < X.length; i++) {
			for(int j = 0; j < X[0].length; j++) {
				result[i][j] = X[i][j] + Y[i][j];
			}
		}
		return result;
	}
	static int[][] multiplyMatrix(int[][] X, int[][] Y) {
		int [][] result = new int[X.length][Y[0].length];
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[0].length; j++) {
				for(int k = 0; k < Y.length;k++) {
					result[i][j] += X[i][k] * Y[k][j]; 
				}
			}
		}
		return result;
	}
	static int[][] transposeMatrix(int[][] a) {
		int [][] result = new int[a[0].length][a.length];
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[0].length; j++) {
				result[i][j] = a[j][i];
			}
		}
		return result;
	}

}

