package lecture03;

import inf.v3d.obj.UnstructuredMesh;
import inf.v3d.view.Viewer;

public class Rectangle {

	private double x;
	private double y;
	private double w;
	private double h;

	public Rectangle(double x, double y, double w, double h) {
	
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;

	}
	
	public void draw(String color, Viewer v) {
		
		UnstructuredMesh um = new UnstructuredMesh();

		int id1 = um.addPoint(this.x, this.y, 0);
		int id2 = um.addPoint(this.x + this.w, this.y, 0);
		int id3 = um.addPoint(this.x + this.w, this.y + this.h, 0);
		int id4 = um.addPoint(this.x, this.y + this.h, 0);
		um.addCell(id1, id2, id3, id4);

		um.setColor(color);
		um.setOutlinesVisible(true);

		v.addObject3D(um);

	}	
}
