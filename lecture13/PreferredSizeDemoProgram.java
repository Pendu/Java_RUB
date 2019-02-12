package lecture13;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PreferredSizeDemoProgram {

	public static void main(String[] args) {
		JPanel p = new JPanel();
		JButton b1 = new JButton("Button A");
		JButton b2 = new JButton("Button with a long text");

		p.add(b1);
		p.add(b2);

		System.out.println(" p: " + p.getPreferredSize());
		System.out.println("b1: " + b1.getPreferredSize());
		System.out.println("b2: " + b2.getPreferredSize());
	}
}
