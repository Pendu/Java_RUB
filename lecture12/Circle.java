package lecture12;

import inf.v3d.obj.Polyline;
import inf.v3d.view.Viewer;

public class Circle extends Shape {

	private static final int N = 20;
	private double r;

	public Circle(double x, double y, double r) {
		super(x, y);
		this.r = r;
	}

	public void draw(Viewer v) {
		Polyline pl = new Polyline();
		double dphi = 2 * Math.PI / (N - 1);
		for (int i = 0; i < N; i++) {
			double px = this.getX() + this.r * Math.cos(i * dphi);
			double py = this.getY() + this.r * Math.sin(i * dphi);
			pl.addVertex(px, py, 0);
		}
		pl.setColor("black");
		v.addObject3D(pl);
	}
}
