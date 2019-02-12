package lecture06;

public class PrimitiveTypeArrayDemoProgram {

	public static void main(String[] args) {
		int[] a = new int[3];
		char[] b = new char[0];
		double[] c = new double[100];
		boolean[] d = new boolean[1];

		System.out.println("length of a: " + a.length);
		System.out.println("length of b: " + b.length);
		System.out.println("length of c: " + c.length);
		System.out.println("length of d: " + d.length);

		a[0] = 55;
		a[2] = 33;
		
		System.out.println("a[0]: " + a[0]);
		System.out.println("a[1]: " + a[1]);
		System.out.println("a[2]: " + a[2]);
		System.out.println("c[0]: " + c[0]);
		System.out.println("d[0]: " + d[0]);

		for (int i = 0; i < c.length; i++) {
			c[i] = Math.random();
		}

		double s = 0;

		for (int i = 0; i < c.length; i++) {
			s += c[i];
		}
		System.out.println("Sum of c[i]: " + s);

		c[100] = 1;
		System.out.println(b[0]);
	}
}
