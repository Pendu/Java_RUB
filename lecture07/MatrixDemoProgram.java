package lecture07;

public class MatrixDemoProgram {

	public static void main(String[] args) {
		Matrix a = new Matrix(3, 3, Math.cos(Math.PI / 4),
				-Math.sin(Math.PI / 4), 0.0, Math.sin(Math.PI / 4),
				Math.cos(Math.PI / 4), 0.0, 0.0, 0.0, 1.0);
		Matrix b = a.transpose();
		Matrix c = a.multiply(1.0, b);
		Vector x = new Vector(1.0, 0.0, 0.0);
		Vector y = a.multiply(2.0, x);

		a.print("a");
		b.print("b");
		c.print("c");
		x.print("x");
		y.print("y");
	}
}
