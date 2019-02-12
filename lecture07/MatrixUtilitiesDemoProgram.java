package lecture07;

import inf.v3d.obj.MatrixPlotGroup;
import inf.v3d.view.Viewer;

public class MatrixUtilitiesDemoProgram {

	public static void main(String[] args) {
		Viewer v = new Viewer();
		Matrix a = MatrixUtilities.createFemMatrix(2, 5);
		Vector x = new Vector(a.getM());
		x.fill(5e2);
		Vector b = a.multiply(1.0, x);

		MatrixPlotGroup mpg = new MatrixPlotGroup();
		MatrixUtilities.plot("A", a, mpg);
		MatrixUtilities.plot("x", x, mpg);
		mpg.addLabel("=");
		MatrixUtilities.plot("b", b, mpg);
		mpg.createColors();

		v.addObject3D(mpg);
		v.setVisible(true);
	}
}
