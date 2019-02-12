package lecture08;

import inf.jlinalg.Array2DMatrix;
import inf.minife.fe.AssemblerJob;
import inf.minife.fe.IsoVolume;
import inf.minife.fe.Model;
import inf.minife.fe.Element.EDKind;
import inf.minife.sample.e1d.GridRoof;
import inf.minife.sample.e3d.ScordelisLoShellHVersion;
import inf.v3d.obj.MatrixPlotGroup;

public class MatrixUtilities {

	public static Matrix createRandomMatrix(int m, int n) {
		Matrix r = new Matrix(m, n);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				r.set(i, j, -100 + 200 * Math.random());
			}
		}
		return r;
	}

	public static Matrix createTriangleMatrix(int n) {
		Matrix r = createRandomMatrix(n, n);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				r.set(i, j, 0);
			}
		}
		return r;
	}

	public static Matrix createSingularMatrix(int n, int d) {
		Matrix r;
		if (d == n) {
			r = new Matrix(n, n);
		} else {
			r = createRandomMatrix(n, n);
			for (int i = n - d; i < n; i++) {
				for (int j = 0; j < n; j++) {
					r.set(i, j, r.get(i - n + d, j));
				}
			}
		}
		return r;
	}

	public static Matrix createLaplacian1DMatrix(int n) {
		Matrix r = new Matrix(n, n);

		for (int i = 0; i < n; i++) {
			if (i > 0) {
				r.set(i - 1, i, -1);
			}
			r.set(i, i, 2);
			if (i < n - 1) {
				r.set(i + 1, i, -1);
			}
		}
		return r;
	}

	public static Matrix createFemMatrix(int n1, int n2) {
		Model m = ScordelisLoShellHVersion.create(
				IsoVolume.TYPE, n1, n2);
		return createMMatrix(m);
	}

	public static Matrix createFemMatrix2(int n) {
		Model m = GridRoof.create(n, n);
		return createMMatrix(m);
	}

	private static Matrix createMMatrix(Model m) {
		m.preAnalysis();
		int n = m.getAssembler().getDOFCount();

		Matrix r = new Matrix(n, n);
		AssemblerJob job = new AssemblerJob();
		Array2DMatrix tmp = new Array2DMatrix(n, n);

		job.addMatrixTask(EDKind.STIFFNESS_MATRIX, 1.0, tmp);
		m.getAssembler().process(job);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				r.set(i, j, tmp.get(i, j));
			}
		}
		return r;
	}

	public static void plot(String l, Matrix a,
			MatrixPlotGroup mpg) {
		int m = a.getM();
		int n = a.getN();

		mpg.addMatrix(l, m, n);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				mpg.setValue(l, i, j, a.get(i, j));
			}
		}
	}

	public static void plot(String l, Vector x,
			MatrixPlotGroup mpg) {
		int n = x.getN();

		mpg.addMatrix(l, n, 1);
		for (int i = 0; i < n; i++) {
			mpg.setValue(l, i, 0, x.get(i));
		}
	}
}
