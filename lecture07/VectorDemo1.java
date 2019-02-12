package lecture07;

public class VectorDemo1 {

	public static void main(String[] args) {
		Vector x = new Vector(2.0, 3.0, 4.0, 5.0);
		Vector y = new Vector(4);
		Vector z1, z2;

		y.set(0, 10.0);
		y.set(2, 2.0);
		z1 = x.multiply(2.0);
		z2 = x.add(-1.0, y);

		x.print(" x");
		y.print(" y");
		z1.print("z1");
		z2.print("z2");

		System.out.println("(x, y) = " + x.scalarProduct(y));
		System.out.println("sqrt(x, x) = " + Math.sqrt(x.scalarProduct(x)));
		System.out.println("||x||2 = " + x.twoNorm());
		System.out.println("||x||1 = " + x.oneNorm());
		System.out.println("||x||i = " + x.maxNorm());
	}
}
