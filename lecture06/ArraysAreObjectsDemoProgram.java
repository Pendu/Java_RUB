package lecture06;

public class ArraysAreObjectsDemoProgram {

	public static void main(String[] args) {
		double[] a = { 5.1, 7.0, 3.0 };
		double[] b = { 5.1, 7.0, 3.0 };

		a = b;
		b[1] = 42.0;
		System.out.println("a[1]: " + a[1]);
	}
}
