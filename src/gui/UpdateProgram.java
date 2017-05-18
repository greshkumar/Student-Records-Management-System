package gui;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
public class UpdateProgram extends JFrame implements ActionListener,FocusListener {

	String url = "jdbc:mysql://localhost:3306/guischema", username = "root", password = "admin",
			query = "Select * from studentdatabase order by stdName";
	Connection con;
	 PreparedStatement ps;
	 Statement st;
	 ResultSet rs;

	UpdateProgram(){
		Looknfeel();
		try {
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
			//System.out.println(ex.toString());
		}
		setTitle("444");
		setSize(200,250);
		FlowLayout manager = new FlowLayout();
		setLayout(manager);

		JLabel jb1 = new JLabel("Enter id");
		JTextField text1 = new JTextField(15);
		JLabel jb2 = new JLabel("Updated Program");
		JTextField text2 = new JTextField(15);
		JButton btn1 = new JButton("Update");
		JButton btn2 = new JButton("Cancel");
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// JOptionPane.showMessageDialog(null, "There");
				
				try {
					ps = con.prepareStatement("update  studentdatabase set stdProgram = ? where stdID = ?");
					ps.setString(1, text2.getText());
					ps.setString(2, text1.getText());
					ps.execute();
					ps.close();
					JOptionPane.showMessageDialog(null, "Updated");
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
		add(jb1);
		add(text1);
		add(jb2);
		add(text2);
		add(btn1);
		add(btn2);
		addWindowFocusListener(new WindowFocusListener(){
			
			@Override
			public void windowLostFocus(WindowEvent e) {
				setAlwaysOnTop(true);
				toFront();
				requestFocus();
			}
			@Override
			public void windowGainedFocus(WindowEvent e) {
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
