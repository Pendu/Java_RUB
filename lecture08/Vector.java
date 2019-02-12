package lecture08;

import java.util.Arrays;

public class Vector {

	private double[] elements;

	public Vector(double... x) {
		this.elements = x;
	}

	public Vector(int n) {
		this.elements = new double[n];
	}

	@Override
	public String toString() {
		return Arrays.toString(this.elements);
	}

	public int getN() {
		return this.elements.length;
	}

	public void fill(double v) {
		Arrays.fill(this.elements, v);
	}

	public void set(int idx, double v) {
		if (idx >= 0 && idx < getN()) {
			this.elements[idx] = v;
		}
	}

	public double get(int idx) {
		if (idx >= 0 && idx < getN()) {
			return this.elements[idx];
		} else {
			return Double.NaN;
		}
	}

	public void print(String l) {
		System.out.print(l + " = (");
		System.out.printf("%12.5e", get(0));
		for (int i = 1; i < this.elements.length; i++) {
			System.out.printf(", %12.5e", get(i));
		}
		System.out.println(")^T");
	}

	public Vector multiply(double alpha) {
		int n = this.getN();
		Vector r = new Vector(n);

		for (int i = 0; i < n; i++) {
			r.set(i, alpha * this.get(i));
		}
		return r;
	}

	public Vector add(double alpha, Vector y) {
		Vector r = new Vector(this.getN());

		for (int i = 0; i < this.getN(); i++) {
			r.set(i, this.get(i) + alpha * y.get(i));
		}
		return r;
	}

	public double scalarProduct(Vector y) {
		double s = 0;

		for (int i = 0; i < this.getN(); i++) {
			s += this.get(i) * y.get(i);
		}
		return s;
	}

	public double twoNorm() {
		return Math.sqrt(this.scalarProduct(this));
	}

	public double oneNorm() {
		double s = 0;
		for (int i = 0; i < this.getN(); i++) {
			s += Math.abs(this.get(i));
		}
		return s;
	}

	public double maxNorm() {
		double max = 0;
		for (int i = 0; i < this.getN(); i++) {
			double v = Math.abs(this.get(i));
			if (max < v) {
				max = v;
			}
		}
		return max;
	}

	public Vector copy() {
		Vector c = new Vector(this.getN());
		for (int i = 0; i < this.getN(); i++) {
			c.set(i, this.get(i));
		}
		return c;
	}
}
