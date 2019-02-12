package lecture08;

import inf.v3d.obj.MatrixPlotGroup;
import inf.v3d.view.Viewer;

public class LUSolveDemoProgram {

	public static void main(String[] args) {
		Matrix a = MatrixUtilities.createFemMatrix(5, 3);
		int n = a.getM();
		LUDecomposition lud = new LUDecomposition(a);
		Vector b = new Vector(n);

		for (int i = 0; i < n; i++) {
			b.set(i, 1e11 * (-1 + 2 * Math.random()));
		}

		b.set(0, 0);

		Vector x = lud.solveFor(b);
		Vector r = a.multiply(1.0, x).add(-1, b);

		System.out.println("||A||max = " + a.maxNorm());
		System.out.println("||r||max = " + r.maxNorm());

		Viewer v = new Viewer();
		MatrixPlotGroup mpg = new MatrixPlotGroup();
		MatrixUtilities.plot("A", a, mpg);
		MatrixUtilities.plot("x", x, mpg);
		mpg.addLabel("=");
		MatrixUtilities.plot("b", b, mpg);
		mpg.addLabel(" ");
		MatrixUtilities.plot("r = Ax - b", r, mpg);
		mpg.createColors();

		v.addObject3D(mpg);
		v.setVisible(true);
	}
}
