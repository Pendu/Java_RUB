package lecture12;

import inf.v3d.obj.Polyline;
import inf.v3d.view.Viewer;

public class Line extends Shape {

	private double dx;
	private double dy;

	public Line(double x, double y, double dx, double dy) {
		super(x, y);
		this.dx = dx;
		this.dy = dy;
	}

	public void draw(Viewer v) {
		Polyline pl = new Polyline();
		double x = this.getX();
		double y = this.getY();

		pl.addVertex(x, y, 0);
		pl.addVertex(x + this.dx, y + this.dy, 0);
		pl.setColor("black");
		v.addObject3D(pl);
	}
}
