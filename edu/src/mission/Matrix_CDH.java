package mission;

public class Matrix_CDH {
	public static void main(String[] args) {
		int [][] a = {{1,2,3,4},{2,3,4,5},{3,4,5,6}};
		int [][] b = {{1,2,3},{2,3,4},{3,4,5},{4,5,6}};
		int [][] c = new int [a.length][b[0].length];
		for(int i = 0; i < c.length; i++) {
			for(int j = 0; j < c[0].length; j++) {
				for(int k = 0; k < b.length; k++) {
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		printMatrix(a);
		printMatrix(b);
		printMatrix(c);
		
		int [] d = {1,2,3,4,
				2,3,4,5,
				3,4,5,6
				};
		int [] e = {1,2,3,
				2,3,4,
				3,4,5,
				4,5,6
				};
		int [] f = new int [9];
		for(int i = 0; i < c.length; i++) {
			int j = 0;
			if(i % 3 == 0) {
				j += 4;
			}
			for(int k = j; k < 3; k++) {
				f[i] += d[k] * e[k*3];
			}
		}
		
		//printMatrix(f);
	}

	private static void printMatrix(int[][] c) {
		for(int i = 0; i < c.length; i++) {
			for(int j = 0; j < c[0].length; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
