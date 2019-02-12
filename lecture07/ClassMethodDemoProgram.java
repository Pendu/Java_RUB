package lecture07;

import java.util.Arrays;

public class ClassMethodDemoProgram {

	public static void main(String[] args) {
		double[] a = new double[10];

		Arrays.fill(a, Math.PI);
		System.out.println("a = " + Arrays.toString(a));
	}
}
