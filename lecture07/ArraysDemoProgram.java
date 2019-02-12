package lecture07;

import java.util.Arrays;

public class ArraysDemoProgram {

	public static void main(String[] args) {
		double[] x = new double[10];

		for (int i = 0; i < x.length; i++) {
			x[i] = Math.random();
		}

		Arrays.sort(x);
		int idx = Arrays.binarySearch(x, 0.5);

		System.out.println(idx);
		System.out.println(x);
		System.out.println(Arrays.toString(x));
	}
}
