package lecture06;

public class ArraysOfArraysDemoProgram {

	public static void main(String[] args) {
		int cnt = 0;
		double[][] a = new double[2][3];
		int[][][] b = new int[3][2][3];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = cnt++;
			}
		}

		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				for (int k = 0; k < b[i][j].length; k++) {
					b[i][j][k] = cnt++;
				}
			}
		}

		System.out.println("a=");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf("%5.1f", a[i][j]);
			}
			System.out.println();
		}

		System.out.println();
		for (int i = 0; i < b.length; i++) {
			System.out.println("b[" + i + "]=");
			for (int j = 0; j < b[i].length; j++) {
				for (int k = 0; k < b[i][j].length; k++) {
					System.out.printf("%3d", b[i][j][k]);
				}
				System.out.println();
			}
			System.out.println();
		}

	}
}
