package lecture12;

import inf.v3d.view.Viewer;

public class DrawingDemoProgram {

	public static void main(String[] args) {
		Viewer v = new Viewer();
		Drawing d = new Drawing();

		d.addShape(new Line(1.0, 0.0, 2.0, 2.0));
		d.addShape(new Circle(0.0, 0.0, 1.0));
		d.addShape(new Rectangle(3.0, -2.0, 1.0, 4.0));
		d.draw(v);
		v.setVisible(true);
	}
}
