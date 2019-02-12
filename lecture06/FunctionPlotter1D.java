package lecture06;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.sqrt;

import inf.v3d.obj.Arrow;
import inf.v3d.obj.Polyline;
import inf.v3d.obj.Tube;
import inf.v3d.view.Viewer;

import java.awt.Color;

public class FunctionPlotter1D {

	private double a;
	private double b;
	private int n = 500;
	private UserFunction f;
	private boolean useTube = true;
	private boolean includeXO = true;
	private boolean includeYO = true;

	public FunctionPlotter1D(double a, double b, UserFunction f) {
		this.a = a;
		this.b = b;
		this.f = f;
	}

	public void plot(Viewer v) {
		Polyline graph = new Polyline();
		Polyline boundary = new Polyline();
		Tube tube = new Tube(graph);
		double dx = (this.b - this.a) / (this.n - 1);
		double xMin = includeXO ? min(0, a) : a;
		double xMax = includeXO ? max(0, b) : b;
		double fMin = includeYO ? 0 : Double.MAX_VALUE;
		double fMax = includeYO ? 0 : Double.MIN_VALUE;

		for (int i = 0; i < this.n; i++) {
			double x = this.a + i * dx;
			double fx = this.f.valueAt(x);

			fMin = min(fx, fMin);
			fMax = max(fx, fMax);
			graph.addVertex(x, fx, 0);
		}

		double size = sqrt((fMax - fMin) * (this.b - this.a));
		Arrow a1 = new Arrow(max(0, xMin), fMin, 0, max(0, xMin), fMax, 0);
		Arrow a2 = new Arrow(xMin, 0, 0, xMax, 0, 0);
		Color c = Color.GRAY;
		a1.setColor(c);
		a2.setColor(c);

		a1.setRadius(size / 250);
		a2.setRadius(size / 250);
		graph.setColor("red");
		tube.setColor("red");
		tube.setRadius(size / 400);

		boundary.setColor("black");
		boundary.addVertex(xMin, fMin, 0);
		boundary.addVertex(xMax, fMin, 0);
		boundary.addVertex(xMax, fMax, 0);
		boundary.addVertex(xMin, fMax, 0);
		boundary.addVertex(xMin, fMin, 0);

		if (this.useTube) {
			v.addObject3D(tube);
		} else {
			v.addObject3D(graph);
		}
		v.addObject3D(boundary);
		v.addObject3D(a1);
		v.addObject3D(a2);
	}

	public void setIncludeXO(boolean b) {
		this.includeXO = b;
	}

	public void setIncludeYO(boolean b) {
		this.includeYO = b;
	}

	public void setN(int n) {
		this.n = n;
	}
}
