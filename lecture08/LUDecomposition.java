package lecture08;

public class LUDecomposition {

	private static final double EPS = 1e-14;

	private Matrix a;

	public LUDecomposition(Matrix a) {
		initialize(a);
		decompose();
	}

	private void initialize(Matrix a) {
		int n = a.getM();

		this.a = new Matrix(n, n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				this.a.set(i, j, a.get(i, j));
			}
		}
	}

	private void decompose() {
		int n = this.a.getM();

		for (int i = 0; i < n - 1; i++) {
			double aii = this.a.get(i, i);

			checkDiagonalElement(i, aii);
			for (int j = i + 1; j < n; j++) {
				double aji = this.a.get(j, i) / aii;
				this.a.set(j, i, aji);

				for (int k = i + 1; k < n; k++) {
					double aik = this.a.get(i, k);
					double ajk = this.a.get(j, k) - aik * aji;

					this.a.set(j, k, ajk);
				}
			}
		}
		checkDiagonalElement(n - 1, this.a.get(n - 1, n - 1));
	}

	private void checkDiagonalElement(int i, double aii) {
		if (Math.abs(aii) < EPS) {
			throw new IllegalArgumentException(
					"Zero diagonal element in row " + i);
		}
	}

	public Matrix getL() {
		int n = this.a.getM();
		Matrix l = new Matrix(n, n);

		for (int j = 0; j < n; j++) {
			l.set(j, j, 1);
			for (int i = j + 1; i < n; i++) {
				l.set(i, j, this.a.get(i, j));
			}
		}
		return l;
	}

	public Matrix getU() {
		int n = this.a.getM();
		Matrix u = new Matrix(n, n);

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				u.set(i, j, this.a.get(i, j));
			}
		}
		return u;
	}

	public Vector solveFor(Vector b) {
		Vector y = computeY(b);
		Vector x = computeX(y);

		return x;
	}

	public Vector computeX(Vector y) {
		int n = this.a.getM();
		Vector x = new Vector(n);

		x.set(n - 1, y.get(n - 1) / this.a.get(n - 1, n - 1));
		for (int i = n - 2; i >= 0; i--) {
			double s = 0;

			for (int j = i + 1; j < n; j++) {
				s += this.a.get(i, j) * x.get(j);
			}
			x.set(i, (y.get(i) - s) / this.a.get(i, i));
		}
		return x;
	}

	public Vector computeY(Vector z) {
		int n = this.a.getM();
		Vector y = new Vector(n);

		y.set(0, z.get(0));
		for (int i = 1; i < n; i++) {
			double s = 0;

			for (int j = 0; j < i; j++) {
				s += this.a.get(i, j) * y.get(j);
			}
			y.set(i, z.get(i) - s);
		}
		return y;
	}
}
