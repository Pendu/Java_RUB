package lecture13;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventDemo2 extends JFrame {

	public EventDemo2() {
		setLayout(new FlowLayout());
		add(createButtonA());
		add(createButtonB());
		pack();
	}

	private JButton createButtonA() {
		JButton b = new JButton("Button A");

		b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("Button A clicked...");
			}
		});
		return b;
	}

	private JButton createButtonB() {
		JButton b = new JButton("Button B");

		b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("Button B clicked...");
			}
		});
		return b;
	}
}
