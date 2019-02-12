package lecture04;

public class ConditionalOperatorDemoProgram {

	public static void main(String[] args) {
		boolean a = true;
		boolean b = false;
		boolean c1 = (a && a);
		boolean c2 = (a && b);
		boolean c3 = (b && b);
		boolean c4 = (a || a);
		boolean c5 = (a || b);
		boolean c6 = (b || b);
		boolean c7 = (b && b || a);
		boolean c8 = (b && (b || a));
		System.out.println("c1: " + c1);
		System.out.println("c2: " + c2);
		System.out.println("c3: " + c3);
		System.out.println("c4: " + c4);
		System.out.println("c5: " + c5);
		System.out.println("c6: " + c6);
		System.out.println("c7: " + c7);
		System.out.println("c8: " + c8);
	}

}
