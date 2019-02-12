package lecture08;

import java.util.Arrays;
import javax.swing.JFrame;
import ptolemy.plot.Plot;

public class TimePlot extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int N = 10;

	private int[] p;
	private long[] startTime;
	private double[][] samples;
	private Plot plot = new Plot();

	public TimePlot(int ns) {
		if (ns % 2 != 1) {
			throw new IllegalArgumentException(
					"nm must be uneven");
		}
		this.p = new int[N];
		this.startTime = new long[N];
		this.samples = new double[N][ns];
		this.plot.setXLabel("N");
		this.plot.setYLabel("t[s]");
		this.plot.setSize(600, 400);
		this.add(this.plot);
		this.pack();
	}

	public int countSamples() {
		return this.samples[0].length;
	}

	public void addDataPoint(int n) {
		for (int idx = 0; idx < N; idx++) {
			if (this.p[idx] != 0) {
				if (this.p[idx] != this.countSamples()) {
					throw new IllegalStateException(
							"Not enough points added");
				}
				this.plot.addPoint(idx, n, this.getT(idx),
						true);
			}
		}
		Arrays.fill(this.p, 0);
	}

	private double getT(int idx) {
		for (double[] d : this.samples) {
			Arrays.sort(d);
		}
		return this.samples[idx][this.countSamples() / 2];
	}

	public void setLegend(int idx, String label) {
		this.plot.addLegend(idx, label);
	}

	public void start(int idx) {
		this.startTime[idx] = System.nanoTime();
	}

	public void stop(int idx) {
		double tu = (System.nanoTime() - this.startTime[idx]) * 1e-9;
		this.samples[idx][this.p[idx]++] = tu;
	}

	public void setPlotTitle(String title) {
		this.plot.setTitle(title);
	}
}
