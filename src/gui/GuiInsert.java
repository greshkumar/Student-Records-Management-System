package gui;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;

public class GuiInsert extends JFrame implements ActionListener,FocusListener {
	Connection con;
	 PreparedStatement ps;
	 String url = "jdbc:mysql://localhost:3306/guischema", username = "root", password = "admin",
			query = "Select * from studentdatabase order by stdName";
	 Statement st;
	 ResultSet rs;
	//static Scanner input = new Scanner(System.in);

	GuiInsert() {
		Looknfeel();
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
			//System.out.println(ex.toString());
		}
		setTitle("777");
		setSize(200, 250);
		FlowLayout manager = new FlowLayout();
		setLayout(manager);
		JLabel label1 = new JLabel("Name:  ");
		JLabel label2 = new JLabel("Course  ");
		//JLabel label3 = new JLabel("Course: ");
		JTextField text1 = new JTextField(15);
		JTextField text2 = new JTextField(15);
		//JTextField text3 = new JTextField(15);

		JButton btn1 = new JButton("Insert");
		JButton btn2 = new JButton("Cancel");
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// JOptionPane.showMessageDialog(null, "There");

				try {
					ps = con.prepareStatement("insert into studentdatabase(`stdName`,`stdProgram`) values(?,?)");
					ps.setString(1, text1.getText());
					ps.setString(2, text2.getText());
					//ps.setString(2, text3.getText());
					ps.execute();
					ps.close();
					JOptionPane.showMessageDialog(null, "Inserted Successfully");
				} catch (Exception ex) {
					System.out.println(ex.toString());
				}
				
			}
		});
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});

		add(label1);
		add(text1);
		add(label2);
		add(text2);
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
	}
	static void Looknfeel(){
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	}
/*
	public static void main(String[] args) {

		GuiInsert gui = new GuiInsert();
	}*/

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
