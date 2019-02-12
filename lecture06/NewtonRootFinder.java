package lecture06;

public class NewtonRootFinder {

	private static final double EPS = 1e-10;
	private static final double DELTA = 1e-7;
	private static final int MAX_ITER = 15;
	private static final int N_PIECES = 20;

	private double a;
	private double b;
	private UserFunction f;

	public NewtonRootFinder(double a, double b, UserFunction f) {
		this.a = a;
		this.b = b;
		this.f = f;
	}

	public double findRoot() {
		double x = this.findInitialGuess();
		double fx = this.f.valueAt(x);
		int step = 0;

		while (Math.abs(fx) >= EPS && step < MAX_ITER && x >= this.a
				&& x <= this.b) {
			double fp = (this.f.valueAt(x + DELTA) - fx) / DELTA;
			x = x - fx / fp;
			fx = this.f.valueAt(x);
			step++;
		}
		if (Math.abs(fx) < EPS) {
			return x;
		} else {
			return Double.NaN;
		}

	}

	private double findInitialGuess() {

		double bestX = 0;
		double bestFx = Double.POSITIVE_INFINITY;
		double dx = (this.b - this.a) / N_PIECES;

		for (int i = 0; i <= N_PIECES; i++) {
			double x = this.a + i * dx;
			double fx = this.f.valueAt(x);

			if (Math.abs(fx) < bestFx) {
				bestX = x;
				bestFx = Math.abs(fx);
			}
		}
		return bestX;
	}

}
