package lecture08;

public class LUComplexityDemoProgram {

	public static void main(String[] args) {
		TimePlot tp1 = new TimePlot(5);
		TimePlot tp2 = new TimePlot(5);

		// warm up
		for (int i = 0; i < 100; i++) {
			Matrix a = MatrixUtilities.createFemMatrix(2, 10);
			LUDecomposition lud = new LUDecomposition(a);
			lud.solveFor(new Vector(a.getM()));
		}

		// run actual measurement
		tp1.setPlotTitle("LU decomposition");
		tp2.setPlotTitle("solve for b");
		tp1.setVisible(true);
		tp2.setVisible(true);

		for (int ne = 2; ne <= 95; ne++) {
			Matrix a = MatrixUtilities.createFemMatrix(2, ne);
			Vector b = new Vector(a.getM());

			for (int i = 0; i < tp1.countSamples(); i++) {
				tp1.start(0);
				LUDecomposition lud = new LUDecomposition(a);
				tp1.stop(0);
				tp2.start(0);
				lud.solveFor(b);
				tp2.stop(0);
			}
			tp1.addDataPoint(a.getM());
			tp2.addDataPoint(a.getM());
			tp1.repaint();
			tp2.repaint();
		}
	}
}
