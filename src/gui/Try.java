package gui;

import javax.swing.*;

public class Try extends JFrame {

	Try() {
		setTitle("777");
		setSize(300, 300);

		JLabel jb1 = new JLabel("Username: ");
		JLabel jb2 = new JLabel("Password");
		JTextField field1 = new JTextField(15);
		JTextField field2 = new JTextField(15);
		/*if (field1.equals("Manesh")) {
		}
		else{
			System.exit(0);
		}*/
		add(jb1);
		add(field1);
		add(jb2);
		add(field2);
		setVisible(true);
	}

	public static void main(String[] args) {

		Try mmm = new Try();
	}

}
