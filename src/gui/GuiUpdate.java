package gui;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class GuiUpdate extends JFrame implements ActionListener,FocusListener {

	 Connection con;
	 PreparedStatement ps;
	 String url = "jdbc:mysql://localhost:3306/guischema", username = "root", password = "admin",
			query = "Select * from studentdatabase order by stdName";
	 Statement st;
	 ResultSet rs;

	GuiUpdate() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//JOptionPane.showMessageDialog(null, "Driver Loaded");
			// System.out.println("Driver loaded successfully");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		setTitle("777");
		setSize(200, 250);
		FlowLayout manager = new FlowLayout();
		setLayout(manager);

		/*JLabel jb1 = new JLabel("Enter id");
		JTextField text1 = new JTextField(15);*/
		JButton btn1 = new JButton("Update Name");
		JButton btn2 = new JButton("Update Program");
		JButton btn3 = new JButton("Cancel");
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				UpdateName name = new UpdateName();
			}
		});
		btn2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				UpdateProgram pro = new UpdateProgram();
				
			}
			
		});
				// JOptionPane.showMessageDialog(null, "There");
	

		btn3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		add(btn1);
		add(btn2);
		add(btn3);
		setVisible(true);
	//	setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/*public static void main(String[] args) {
		GuiUpdate gui = new GuiUpdate();
	}
*/
	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

}
