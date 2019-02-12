package lecture07;

public class MatrixDemo2 {

	public static void main(String[] args) {
		Matrix a = new Matrix(3, 3);
		Matrix b = new Matrix(3, 4, 3, 5, 8, 1, 4, 1, 3, 2, 8,
				5, 9, 3);

		Matrix bt = b.transpose();

		Matrix c = bt.multiply(1, b);

		a.setRow(0, -398347, 2, 1);
		a.setRow(1, 1, 2, 3);

		a.print("a=");
		b.print("b=");
		bt.print("bt=");
		c.print("c=");
	}
}
