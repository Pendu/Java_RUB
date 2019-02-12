package lecture07;

public class VarargsConstructorDemoProgram {

	public static void main(String[] args) {
		double[] x = { 9.0, 8.0, 7.0, 4.0 };

		Vector v1 = new Vector(4, 5, 6);
		Vector v2 = new Vector(x);
		Vector v3 = new Vector(1.0, 1.0, 1.0, 1.0, 1.0);

		v1.print("v1");
		v2.print("v2");
		v3.print("v3");
	}
}
