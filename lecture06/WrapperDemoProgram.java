package lecture06;

public class WrapperDemoProgram {

	public static void main(String[] args) {
		double x = Double.POSITIVE_INFINITY;
		double y = Double.parseDouble("1.399");
		double z = Math.sqrt(-1);

		System.out.println("      x = " + x);
		System.out.println("  2 * y = " + 2 * y);
		System.out.println("      z = " + z);
		System.out.println("x is NaN: " + Double.isNaN(x));
		System.out.println("z is NaN: " + Double.isNaN(z));
	}
}
