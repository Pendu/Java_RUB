package lecture08;

public class LUDecompositionDemoProgram {

	public static void main(String[] args) {
		try {
			Matrix a = MatrixUtilities.createSingularMatrix(4, 1);
			LUDecomposition lud = new LUDecomposition(a);

			Matrix l = lud.getL();
			Matrix u = lud.getU();

			l.print("l");
			u.print("u");
			
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Continues");
	}
}
