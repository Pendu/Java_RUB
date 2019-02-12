package lecture07;

import inf.v3d.obj.MatrixPlotGroup;
import inf.v3d.view.Viewer;

public class MatrixPlotDemoProgram {

	public static void main(String[] args) {
		Viewer v = new Viewer();
		Matrix a = MatrixUtilities.createFemMatrix(3, 5);
		MatrixPlotGroup mpg = new MatrixPlotGroup();

		MatrixUtilities.plot("A", a, mpg);
		mpg.createColors();

		v.addObject3D(mpg);
		v.setVisible(true);
	}
}
