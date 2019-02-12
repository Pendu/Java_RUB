package lecture12;

import inf.v3d.view.Viewer;

import java.util.LinkedList;
import java.util.List;

public class Drawing {

	private List<Shape> shapes = new LinkedList<Shape>();

	public void addShape(Shape s) {
		this.shapes.add(s);
	}

	public void draw(Viewer v) {
		for (Shape s : this.shapes) {
			s.draw(v);
		}
	}
}
