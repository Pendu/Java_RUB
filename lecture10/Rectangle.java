package lecture10;

import inf.v3d.obj.UnstructuredMesh;
import inf.v3d.view.Viewer;
import java.awt.geom.Rectangle2D.Double;

public class Rectangle extends Double {

	private static final long serialVersionUID = 1L;

	public Rectangle(double x1, double y1, double w, double h) {	
		super(x1, y1, w, h);
	}
	
	public boolean intersects(double x1, double y1, double x2, double y2) {
		return super.intersectsLine(x1, y1, x2, y2);
	}
	
	public double getH() {
		return this.getHeight();
	}
	
	public double getW() {
		return this.getWidth();
	}

	public void draw(String color, Viewer v) {	
		UnstructuredMesh um = new UnstructuredMesh();
		int id1 = um.addPoint(this.getX(), this.getY(), 0);
		int id2 = um.addPoint(this.getX() + this.getWidth(), this.getY(), 0);
		int id3 = um.addPoint(this.getX() + this.getWidth(), this.getY() + this.getHeight(), 0);
		int id4 = um.addPoint(this.getX(), this.getY() + this.getHeight(), 0);
		um.addCell(id1, id2, id3, id4);
		um.setColor(color);
		um.setOutlinesVisible(true);		
		v.addObject3D(um);
	}
	
	public String toString() {
		return super.toString();
	}
}
