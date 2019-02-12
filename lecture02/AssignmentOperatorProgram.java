package lecture02;

import inf.v3d.obj.Sphere;
import inf.v3d.view.Viewer;

public class AssignmentOperatorProgram {
	public static void main(String[] args) {
		// Declaration of variable s
		Sphere s;
		// Create new sphere object and assign it to variable s1
		Sphere s1 = new Sphere(0, 0, 0);
		// Create new sphere object and assign it to variable s1
		Sphere s2 = new Sphere(2, 0, 0);
		// Create new viewer object and assign it to variable v
		Viewer v = new Viewer();
		// Add the two spheres to the viewer
		v.addObject3D(s1);
		v.addObject3D(s2);

		s = s2;
		s.setColor("red");
		s2 = s1;
		s2.setRadius(0.5);
		s = s2;
		s.setColor("blue");
		// Set viewer object visible = show the viewer program
		v.setVisible(true);
	}
}
