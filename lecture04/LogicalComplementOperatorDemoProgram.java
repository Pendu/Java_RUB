package lecture04;

public class LogicalComplementOperatorDemoProgram {

	public static void main(String[] args) {
		boolean a = false;
		double  b = 1.2;
		double  c = 5.9;

		boolean c1 = !a;
		boolean c2 = !((b == c) && c1);
		boolean c3 = !(b != c);

		System.out.println("c1: " + c1);
		System.out.println("c2: " + c2);
		System.out.println("c3: " + c3);
	}
	
}
