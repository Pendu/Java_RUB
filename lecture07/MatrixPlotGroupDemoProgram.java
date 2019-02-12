package lecture07;

import inf.v3d.obj.MatrixPlotGroup;
import inf.v3d.view.Viewer;

public class MatrixPlotGroupDemoProgram {

	public static void main(String[] args) {
		Matrix a = new Matrix(3, 4);
		Vector x = new Vector(4);
		a.setRow(0, -6, 2, 3, 4);
		a.setRow(1, -2, -2, 1, 5);
		a.setRow(2, 1, 2, 2, 1);
		x.fill(2);
		Vector b = a.multiply(1, x);

		Viewer v = new Viewer();
		MatrixPlotGroup mpg = new MatrixPlotGroup();
		mpg.addMatrix("A", 3, 4);
		mpg.addMatrix("x", 3, 1);
		mpg.addMatrix("b", 3, 1);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				mpg.setValue("A", i, j, a.get(i, j));
			}
			mpg.setValue("b", i, 0, b.get(i));
			mpg.setValue("x", i, 0, x.get(i));
		}
		mpg.createColors();
		v.addObject3D(mpg);
		v.setVisible(true);
	}
}
