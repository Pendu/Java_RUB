package lecture05;

import inf.v3d.obj.Sphere;
import inf.v3d.view.Viewer;

public class NewtonRootFinderTest {	
	
	public static void main(String[] args) {		

		UserFunction f = new UserFunction("pow(x-2,6)/55-0.01", "x");	

		double a = 0.0;
		double b = 2.0;
		NewtonRootFinder rf = new NewtonRootFinder(a, b, f);		
		double x = rf.findRoot();	
		System.out.println("Found approximate root x=" + x + " with f(x)=" + f.valueAt(x));
		
		// Visualization
		Viewer v = new Viewer();

		FunctionPlotter1D fp = new FunctionPlotter1D(a, b, f);
		fp.plot(v);
		
		Sphere root = new Sphere(x, 0.0, 0.0);		
		root.setColor("green");
		root.setRadius((b - a) / 100);
		v.addObject3D(root);
		
		v.setVisible(true);
		
	}
}