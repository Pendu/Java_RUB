package lecture06;

public class ObjectTypeArrayDemoProgram {

	public static void main(String[] args) {
		Rectangle[] rs = new Rectangle[2];
		Rectangle r1 = new Rectangle(0, 0, 1, 1);

		rs[0] = r1;
		rs[1] = new Rectangle(1.0, 0.0, 0.5, 1.5);
		System.out.println("rs[0]: " + rs[0].isInside(0, 0));
		System.out.println("rs[1]: " + rs[1].isInside(0, 0));
	}
}
