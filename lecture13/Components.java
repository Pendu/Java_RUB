package lecture13;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class Components extends JFrame {

	public Components() {
		setLayout(new FlowLayout());
		add(createButtons());
		add(createCheckBoxes());
		add(createComboBoxes());
		add(createLists());
		add(createRadioButtons());
		add(createSliders());
		add(createSpinners());
		add(createTextFields());
		add(createTextArea());
		add(createLabels());
		add(createProgressBars());
		setSize(950, 440);
	}

	private JPanel createButtons() {
		JPanel p = new JPanel();

		p.setBorder(BorderFactory
				.createTitledBorder("JButton"));
		p.add(new JButton("Button A"));
		p.add(new JButton("Button B"));
		return p;
	}

	private JPanel createCheckBoxes() {
		JPanel p = new JPanel();
		JCheckBox cbA = new JCheckBox("Check box A");
		JCheckBox cbB = new JCheckBox("Check box B", true);

		p.setBorder(BorderFactory
				.createTitledBorder("JCheckBox"));
		p.add(cbA);
		p.add(cbB);
		return p;
	}

	private JPanel createComboBoxes() {
		JPanel p = new JPanel();
		Object[] items1 = { "Potato", "Tomato", "Cucumber" };
		JComboBox cb1 = new JComboBox(items1);
		Object[] items2 = { "Mango", "Pineapple" };
		JComboBox cb2 = new JComboBox(items2);

		p.setBorder(BorderFactory
				.createTitledBorder("JComboBox"));
		p.add(cb1);
		p.add(cb2);
		return p;
	}

	private JPanel createLists() {
		JPanel p = new JPanel();
		String[] items1 = { "Potato", "Tomato", "Cucumber" };
		JList list1 = new JList(items1);
		Object[] items2 = { "Mango", "Pineapple" };
		JList list2 = new JList(items2);

		p.setBorder(BorderFactory.createTitledBorder("JList"));
		p.add(list1);
		p.add(list2);
		return p;
	}

	private JPanel createRadioButtons() {
		JPanel p = new JPanel();
		ButtonGroup bg = new ButtonGroup();
		JRadioButton rb1 = new JRadioButton("Radio 1");
		JRadioButton rb2 = new JRadioButton("Radio 2", true);
		JRadioButton rb3 = new JRadioButton("Radio 3");

		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		p.setBorder(BorderFactory
				.createTitledBorder("JRadioButton"));
		p.add(rb1);
		p.add(rb2);
		p.add(rb3);
		return p;
	}

	private JPanel createSliders() {
		JPanel p = new JPanel();
		JSlider s1 = new JSlider(0, 100);
		JSlider s2 = new JSlider(-100, 100);

		s1.setMajorTickSpacing(20);
		s1.setMinorTickSpacing(2);
		s1.setPaintTicks(true);
		s1.setPaintLabels(true);

		p.setBorder(BorderFactory
				.createTitledBorder("JSlider"));
		p.add(s1);
		p.add(s2);
		return p;
	}

	private JPanel createSpinners() {
		JPanel p = new JPanel();
		JSpinner s1 = new JSpinner(new SpinnerNumberModel(0.1,
				-1.5, 2, 0.1));
		JSpinner s2 = new JSpinner(new SpinnerNumberModel(0,
				-1000, 1000, 100));

		p.setBorder(BorderFactory
				.createTitledBorder("JSpinner"));
		p.add(s1);
		p.add(s2);
		return p;
	}

	private JPanel createTextFields() {
		JPanel p = new JPanel();
		JTextField tf1 = new JTextField("Pumpkin");
		JTextField tf2 = new JTextField(6);

		p.setBorder(BorderFactory
				.createTitledBorder("JTextField"));
		p.add(tf1);
		p.add(tf2);
		return p;
	}

	private JPanel createTextArea() {
		JPanel p = new JPanel();
		JTextArea ta = new JTextArea();
		JScrollPane sp = new JScrollPane(ta);

		sp.setPreferredSize(new Dimension(200, 100));
		p.setBorder(BorderFactory
				.createTitledBorder("JTextArea"));
		p.add(sp);
		return p;
	}

	private JPanel createLabels() {
		JPanel p = new JPanel();
		String t1 = "Label A";
		String t2 = "<html>You can <i>also</i> use <b>HTML</b><br/>to create more fancy labels";

		p
				.setBorder(BorderFactory
						.createTitledBorder("JLabel"));
		p.add(new JLabel(t1));
		p.add(new JLabel(t2));
		return p;
	}

	private JPanel createProgressBars() {
		JPanel p = new JPanel();
		JProgressBar pb1 = new JProgressBar(0, 200);
		JProgressBar pb2 = new JProgressBar(
				JProgressBar.VERTICAL, 0, 100);

		pb1.setValue(20);
		pb1.setString("10%");
		pb1.setStringPainted(true);
		pb2.setValue(50);
		p.setBorder(BorderFactory
				.createTitledBorder("JProgressBar"));
		p.add(pb1);
		p.add(pb2);
		return p;
	}
}
