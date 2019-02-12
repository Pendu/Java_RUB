package lecture12;

import inf.v3d.view.Viewer;

public class ShapesDemoProgram {

	public static void main(String[] args) {
		Viewer v = new Viewer();
		Line l = new Line(1.0, 0.0, 2.0, 2.0);
		Circle c = new Circle(0.0, 0.0, 1.0);
		Rectangle r = new Rectangle(3.0, -2.0, 1.0, 4.0);

		l.draw(v);
		c.draw(v);
		r.draw(v);
		v.setVisible(true);

	}
}
