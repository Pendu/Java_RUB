package lecture13;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventDemo1 extends JFrame {

	public EventDemo1() {
		setLayout(new FlowLayout());
		add(createButtonA());
		add(createButtonB());
		pack();
	}

	private JButton createButtonA() {
		JButton b = new JButton("Button A");
		ActionListener al = new AListener();
		
		b.addActionListener(al);
		return b;
	}

	private JButton createButtonB() {
		JButton b = new JButton("Button B");
		ActionListener al = new BListener();
		
		b.addActionListener(al);
		return b;
	}
}
