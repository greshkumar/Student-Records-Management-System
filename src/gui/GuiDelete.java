package gui;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
public class GuiDelete extends JFrame implements ActionListener,FocusListener {

	 Connection con;
	 PreparedStatement ps;
	 String url = "jdbc:mysql://localhost:3306/guischema", username = "root", password = "admin",
			query = "Select * from studentdatabase order by stdName";
	 Statement st;
	 ResultSet rs;
	GuiDelete(){
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			Class.forName("com.mysql.jdbc.Driver");
			//JOptionPane.showMessageDialog(null, "DriverLoaded Successfully");
			//System.out.println("Driver loaded successfully");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
			//System.out.println(ex.toString());
		}
		setTitle("777");
		setSize(200, 250);
		FlowLayout manager = new FlowLayout();
		setLayout(manager);

		JLabel jb1 = new JLabel("Enter ID");
		JTextField text1 = new JTextField(15);
		JButton btn1 = new JButton("Delete");
		JButton btn2 = new JButton("Cancel");
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// JOptionPane.showMessageDialog(null, "There");

				try {
					//JOptionPane.showInputDialog("Enter id to delete");
					ps = con.prepareStatement("Delete  from studentdatabase where stdID = ?");
					ps.setString(1,text1.getText());
					ps.execute();
					ps.close();
					//JOptionPane.showMessageDialog(null, "Deleted Successfully");
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
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	/*public static void main(String[] args) {
		GuiDelete delete = new GuiDelete();
	}*/

	@Override
	public void actionPerformed(ActionEvent e) {
	}
	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

}
