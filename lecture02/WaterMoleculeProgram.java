package lecture02;

import inf.v3d.obj.Sphere;
import inf.v3d.view.Viewer;

public class WaterMoleculeProgram {

	public static void main(String[] args) {

		Viewer v = new Viewer();
		Sphere oxygen = new Sphere(0.00, 0.00, 0.00);
		Sphere hydrogen1 = new Sphere(0.75, 0.59, 0.00);
		Sphere hydrogen2 = new Sphere(-0.75, 0.59, 0.00);

		oxygen.setColor("red");
		hydrogen1.setRadius(0.675);
		hydrogen2.setRadius(0.675);

		v.addObject3D(oxygen);
		v.addObject3D(hydrogen1);
		v.addObject3D(hydrogen2);

		v.setVisible(true);
	}
}
