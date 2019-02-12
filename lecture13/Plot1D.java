package lecture13;

import inf.math.UserFunction;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ptolemy.plot.Plot;

public class Plot1D extends JFrame {

	private static final int NP = 200;

	private JTextField aTf = new JTextField("0");
	private JTextField bTf = new JTextField("1");
	private JTextField fctTf = new JTextField("sin(4*PI*x)");
	private JCheckBox showGridCb = new JCheckBox("Show grid");
	private Plot plot = new Plot();

	public Plot1D() {
		setTitle("Plot 1D");
		setLayout(new BorderLayout(5, 5));

		add(createWestPanel(), BorderLayout.WEST);
		add(this.plot, BorderLayout.CENTER);
		add(createSouthPanel(), BorderLayout.SOUTH);
		setSize(600, 400);
	}

	private JPanel createWestPanel() {
		JPanel wp = new JPanel(new BorderLayout());
		wp.add(createSettingsPanel(), BorderLayout.NORTH);
		return wp;
	}

	private JPanel createSettingsPanel() {
		JPanel sp = new JPanel(new BorderLayout(5, 5));
		JPanel p1 = new JPanel(new GridLayout(3, 1, 0, 2));
		JPanel p2 = new JPanel(new GridLayout(3, 1, 0, 2));

		p1.add(new JLabel("f(x) = ", JLabel.RIGHT));
		p1.add(new JLabel("a = ", JLabel.RIGHT));
		p1.add(new JLabel("b = ", JLabel.RIGHT));

		p2.add(this.fctTf);
		p2.add(this.aTf);
		p2.add(this.bTf);

		sp.setBorder(BorderFactory
				.createTitledBorder("Settings"));
		sp.add(p1, BorderLayout.WEST);
		sp.add(p2, BorderLayout.CENTER);
		sp.add(this.showGridCb, BorderLayout.SOUTH);
		return sp;
	}

	private JPanel createSouthPanel() {
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(createPlotButton());
		p.add(createExitButton());
		return p;
	}

	private JButton createExitButton() {
		JButton b = new JButton("Exit");

		b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		return b;
	}

	private JButton createPlotButton() {
		JButton b = new JButton("Plot");

		b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				plot();
			}
		});
		return b;
	}

	private void plot() {
		try {
			double a = Double.parseDouble(this.aTf.getText());
			double b = Double.parseDouble(this.bTf.getText());
			double dx = (b - a) / (NP - 1);
			UserFunction uf = new UserFunction(this.fctTf
					.getText(), "x");

			this.plot.clear(true);
			this.plot.setGrid(this.showGridCb.isSelected());
			for (int i = 0; i < NP; i++) {
				double x = a + i * dx;
				double y = uf.valueAt(x);

				this.plot.addPoint(0, x, y, true);
			}
			this.plot.repaint();
		} catch (Exception e) {
			JOptionPane
					.showMessageDialog(this, e.getMessage());
		}
	}
}
