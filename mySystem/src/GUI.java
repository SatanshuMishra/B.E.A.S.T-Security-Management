import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener{
	
	int count = 0;
	
	
	private JFrame frame;
	private JPanel panel;
	private JButton button;
	private JLabel label;
	
	
	public GUI() {
		frame = new JFrame();
		panel = new JPanel();
		
		button = new JButton("Click Me!");
		button.addActionListener(this);
		
		label = new JLabel("Number of Clicks: " + count);
		
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(button);
		panel.add(label);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Our GUI");
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		label.setText("Number of Clicks: " + count);
	}
}
