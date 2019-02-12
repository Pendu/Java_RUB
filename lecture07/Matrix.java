package lecture07;

public class Matrix {

	private double[][] elements;

	public Matrix(int m, int n) {
		this.elements = new double[m][n];
	}

	public Matrix(int m, int n, double... values) {
		this(m, n);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				this.set(i, j, values[i * n + j]);
			}
		}
	}

	public int getM() {
		return this.elements.length;
	}

	public int getN() {
		return this.elements[0].length;
	}

	public void set(int i, int j, double v) {
		this.elements[i][j] = v;
	}

	public void setRow(int idx, double... values) {
		for (int i = 0; i < this.getN(); i++) {
			this.set(idx, i, values[i]);
		}
	}

	public double get(int i, int j) {
		return this.elements[i][j];
	}

	public void print(String l) {
		int m = getM();
		System.out.println(l + " = ");
		for (int i = 0; i < m; i++) {
			System.out.print("|");
			for (int j = 0; j < getN(); j++) {
				System.out.printf(" %12.5e", get(i, j));
			}
			System.out.println(" |");
		}
	}

	public Matrix transpose() {
		int m = this.getM();
		int n = this.getN();
		Matrix r = new Matrix(n, m);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				r.set(j, i, this.get(i, j));
			}
		}
		return r;
	}

	public double maxNorm() {
		double mn = Double.NEGATIVE_INFINITY;

		for (int i = 0; i < this.getM(); i++) {
			for (int j = 0; j < this.getN(); j++) {
				double v = Math.abs(this.get(i, j));

				if (v > mn) {
					mn = v;
				}
			}
		}
		return mn;
	}

	public Matrix add(double alpha, Matrix b) {
		int m = this.getM();
		int n = this.getN();
		Matrix r = new Matrix(m, n);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				r.set(i, j, this.get(i, j) + alpha
						* b.get(i, j));
			}
		}
		return r;
	}

	public Vector multiply(double alpha, Vector x) {
		Vector r = new Vector(this.getM());

		for (int i = 0; i < this.getM(); i++) {
			double s = 0;

			for (int j = 0; j < this.getN(); j++) {
				s += this.get(i, j) * x.get(j);
			}
			r.set(i, alpha * s);
		}
		return r;
	}

	public Matrix multiply(double alpha, Matrix b) {
		Matrix r = new Matrix(this.getM(), b.getN());

		for (int i = 0; i < this.getM(); i++) {
			for (int j = 0; j < b.getN(); j++) {
				double s = 0;

				for (int k = 0; k < this.getN(); k++) {
					s += this.get(i, k) * b.get(k, j);
				}
				r.set(i, j, alpha * s);
			}
		}
		return r;
	}
}
