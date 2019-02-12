package lecture07;

public class VectorDemo2 {

	public static void main(String[] args) {
		Vector x1 = new Vector(1.0, 44.0, 1.0);

		double[] values = { 3, 5, 6, 7, 43, 243, 462534, 7 };
		Vector x2 = new Vector(values);

		double s = x2.scalarProduct(x1);
		System.out.println(s);
	}
}
