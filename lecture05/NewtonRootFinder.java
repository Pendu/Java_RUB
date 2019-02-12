package lecture05;

public class NewtonRootFinder {

	private static final double EPS = 1e-10;
	private static final double DELTA = 1e-7;
	private static final int MAX_ITER = 15;

	private double a;
	private double b;
	private UserFunction f;

	public NewtonRootFinder(double a, double b, UserFunction f) {
		this.a = a;
		this.b = b;
		this.f = f;
	}

	public double findRoot() {
		double x = this.a;
		double fx = this.f.valueAt(x);
		int step = 0;

		while (Math.abs(fx) >= EPS && step < MAX_ITER && x >= this.a
				&& x <= this.b) {
			double fp = (this.f.valueAt(x + DELTA) - fx) / DELTA;
			x = x - fx / fp;
			fx = this.f.valueAt(x);
			step++;
		}
		return x;
	}
}
