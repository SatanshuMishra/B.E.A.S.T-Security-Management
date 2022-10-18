import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUITerminal{
	private JFrame frame;
	private JPanel panel;
    private JLabel username;
    private JTextField userField;
	private JLabel passwordLabel;
    private JPasswordField passwordField;
    JButton loginBtn;
    private JLabel successLabel;
    private JPanel success;
	
	public GUITerminal() {
		frame = new JFrame();
        panel = new JPanel();
        success = new JPanel();
        
        panel.setLayout(null);

        // USERNAME LABEL
        username = new JLabel("USERNAME");
        username.setBounds(10, 20, 80, 25);
        panel.add(username);

        // USERNAME FIELD
        userField = new JTextField(20);
        userField.setBounds(100, 20, 165, 25);
        panel.add(userField);
        
        // PASSWORD LABEL
        passwordLabel = new JLabel("PASSWORD");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        // PASSWORD FIELD
        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 50, 165, 25);
        panel.add(passwordField);

        // SUCCESS LABEL
        successLabel = new JLabel("SUCCESS");
        successLabel.setBounds(10, 100, 80, 25);
        successLabel.setBackground(Color.green);
        success.add(successLabel);

        // LOGIN BUTTON
        loginBtn = new JButton("LOGIN");
        loginBtn.setBounds(10, 80, 80, 25);
        loginBtn.setBackground(Color.WHITE);
        loginBtn.addActionListener(new buttonListener());
        panel.add(loginBtn);

        // FRAME SETTINGS
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("ACCESS TERMINAL");
        frame.add(panel);
		
        frame.setVisible(true);
	}

    class buttonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == loginBtn){
                String user = userField.getText();
                String password = new String(passwordField.getPassword());
                System.out.println("User: " + user + " Password: " + password);
                frame.remove(panel);
                frame.add(success);
            }
        }
    }

}


