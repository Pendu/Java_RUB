package lecture04;

import inf.v3d.view.Viewer;

public class RectangleProgram {

	public static void main(String[] args) {

		Rectangle r1 = new Rectangle(1.0, 1.0, 4.0, 4.0);
		Rectangle r2 = new Rectangle(2.0, 4.0, 8.0, 2.0);
		Rectangle r3 = new Rectangle(6.0, 2.0, 2.0, 5.0);

		Viewer viewer = new Viewer();

		r1.draw("red", viewer);
		r2.draw("green", viewer);
		r3.draw("blue", viewer);
		
		double a1 = r1.getArea();
		double a2 = r2.getArea();
		double a3 = r3.getArea();

		System.out.println("Area of rectangle 1: " + a1);
		System.out.println("Area of rectangle 2: " + a2);
		System.out.println("Area of rectangle 3: " + a3);
		
		double px = 3.5;
		double py = 4.5;

		boolean b1 = r1.isInside(px, py);
		boolean b2 = r2.isInside(px, py);
		boolean b3 = r3.isInside(px, py);

		System.out.println("Rectangle 1 contains p: " + b1);
		System.out.println("Rectangle 2 contains p: " + b2);
		System.out.println("Rectangle 3 contains p: " + b3);
		
		boolean b4 = r1.isIntersecting(r2);
		boolean b5 = r1.isIntersecting(r3);
		boolean b6 = r2.isIntersecting(r3);

		System.out.println("r1 intersects r2: " + b4);
		System.out.println("r1 intersects r3: " + b5);
		System.out.println("r2 intersects r3: " + b6);
		
		Rectangle r4 = r1.createUnion(r2);
		Rectangle r5 = r2.createUnion(r3);
		
		r4.draw("cyan"   , viewer);
		r5.draw("magenta", viewer);
		
		viewer.setVisible(true);
	}
}
