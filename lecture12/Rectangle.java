package lecture12;

import inf.v3d.obj.Polyline;
import inf.v3d.view.Viewer;

public class Rectangle extends Shape {

	private double w;
	private double h;

	public Rectangle(double x, double y, double w, double h) {
		super(x, y);
		this.w = w;
		this.h = h;
	}

	public void draw(Viewer v) {
		Polyline pl = new Polyline();
		double x = this.getX();
		double y = this.getY();

		pl.addVertex(x, y, 0);
		pl.addVertex(x + this.w, y, 0);
		pl.addVertex(x + this.w, y + this.h, 0);
		pl.addVertex(x, y + this.h, 0);
		pl.addVertex(x, y, 0);
		pl.setColor("black");
		v.addObject3D(pl);
	}
}
