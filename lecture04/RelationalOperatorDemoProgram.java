package lecture04;

public class RelationalOperatorDemoProgram {

	public static void main(String[] args) {
		double a = 1.2;
		double b = 5.9;
		boolean b1 = (a == b);
		boolean b2 = (a != b);
		boolean b3 = (a < b);
		boolean b4 = (a <= b);
		boolean b5 = (a > b);
		boolean b6 = (a >= b);
		boolean b7 = (b1 == b2);
		boolean b8 = (b1 != b2);
		System.out.println("b1: " + b1);
		System.out.println("b2: " + b2);
		System.out.println("b3: " + b3);
		System.out.println("b4: " + b4);
		System.out.println("b5: " + b5);
		System.out.println("b6: " + b6);
		System.out.println("b7: " + b7);
		System.out.println("b8: " + b8);
	}

}
