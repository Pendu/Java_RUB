package lecture03;

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

		viewer.setVisible(true);
	}
}
