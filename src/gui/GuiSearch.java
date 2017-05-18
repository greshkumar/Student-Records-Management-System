package gui;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class GuiSearch extends JFrame implements ActionListener,FocusListener {

	 Connection con;
	 PreparedStatement ps;
	 String url = "jdbc:mysql://localhost:3306/guischema", username = "root", password = "admin",
			query = "Select * from studentdatabase order by stdName";
	 Statement st;
	 ResultSet rs;

	GuiSearch() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			// JOptionPane.showMessageDialog(null, "Driver Loaded");
			// System.out.println("Driver loaded successfully");

		} catch (Exception ex) {
			// JOptionPane.showMessageDialog(null, ex.toString());
		}
		setTitle("777");
		setSize(200, 250);
		FlowLayout manager = new FlowLayout();
		setLayout(manager);
		requestFocus();

		JLabel jb1 = new JLabel("Enter id");
		JTextField text1 = new JTextField(15);
		JButton btn1 = new JButton("Search");
		JButton btn2 = new JButton("Cancel");
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// JOptionPane.showMessageDialog(null, "There");

				int flag = 0;
				try {
					ps = con.prepareStatement("Select * from studentdatabase where stdID = ? ");
					ps.setString(1, text1.getText());
					rs = ps.executeQuery();
					while (rs.next()) {
						flag++;
						JOptionPane.showMessageDialog(null, rs.getString(1) + " " + rs.getString(2) + " "
								+ rs.getString(3) + " " + rs.getString(4));
					}
					if(flag == 0){
						JOptionPane.showMessageDialog(null, "No Data Present");
					}
					
					ps.close();
					// JOptionPane.showMessageDialog(null, "Deleted
					// Successfully");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.toString());
					// System.out.println(ex.toString());
				}
			}
		});
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		add(jb1);
		add(text1);
		add(btn1);
		add(btn2);

		addWindowFocusListener(new WindowFocusListener(){
			
			@Override
			public void windowLostFocus(WindowEvent e) {
				// TODO Auto-generated method stub
				setAlwaysOnTop(true);
				toFront();
				requestFocus();
			}
			@Override
			public void windowGainedFocus(WindowEvent e) {
				// TODO Auto-generated method stub
			hasFocus();
			}

		
			});
		setVisible(true);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		GuiSearch gui = new GuiSearch();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

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
