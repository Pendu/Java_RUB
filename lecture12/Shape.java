package lecture12;

import inf.v3d.view.Viewer;

public abstract class Shape {

	private double x;
	private double y;

	public Shape(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public abstract void draw(Viewer v);
	
	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public void moveTo(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
