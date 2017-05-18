package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.DropMode;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Gui {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblWelcome = new JLabel("                                                         WELCOME");
		lblWelcome.setVerticalAlignment(SwingConstants.TOP);
		frame.getContentPane().add(lblWelcome, BorderLayout.NORTH);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setVerticalAlignment(SwingConstants.TOP);
		frame.getContentPane().add(lblUsername, BorderLayout.WEST);
		
		textField = new JTextField();
		textField.setDropMode(DropMode.ON);
		frame.getContentPane().add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		Button button = new Button("Ok");
		button.setForeground(new Color(0, 102, 255));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frame.getContentPane().add(button, BorderLayout.EAST);
	}

}
