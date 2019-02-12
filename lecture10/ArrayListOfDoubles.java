package lecture10;

public class ArrayListOfDoubles implements ListOfDoubles {

	private double[] values = new double[0];

	public void addFirst(double x) {
		int n = this.values.length;
		double[] tmp = new double[n + 1];

		tmp[0] = x;
		System.arraycopy(this.values, 0, tmp, 1, n);
		this.values = tmp;
	}

	public void print(String l) {
		System.out.print(l + "<");
		for (int i = 0; i < this.values.length; i++) {
			System.out.print(this.values[i]);
			System.out.print(" ");
		}
		System.out.println(">");
	}
}
