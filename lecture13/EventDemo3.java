package lecture13;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventDemo3 extends JFrame implements
		ActionListener {

	private JButton aButton = new JButton("Button A");
	private JButton bButton = new JButton("Button B");

	public EventDemo3() {
		setLayout(new FlowLayout());
		this.aButton.addActionListener(this);
		this.bButton.addActionListener(this);
		add(this.aButton);
		add(this.bButton);
		pack();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.aButton) {
			System.out.println("Button A clicked...");
		} else if (e.getSource() == this.bButton) {
			System.out.println("Button B clicked...");
		}
	}
}
