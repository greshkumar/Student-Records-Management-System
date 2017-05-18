package gui;

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;


public class JTable extends JFrame implements ActionListener,FocusListener,Runnable {
	 Connection con;
	 PreparedStatement ps;
	 String url = "jdbc:mysql://localhost:3306/guischema", username = "root", password = "admin",
			query = "Select * from studentdatabase order by stdName";
	 Statement st;
	 ResultSet rs;

	private JPanel contentPane;
	private javax.swing.JTable table;

	
	public JTable() {
		
		//	Thread mythread = new Thread(new JTable());
			try {
				Class.forName("com.mysql.jdbc.Driver");
				//JOptionPane.showMessageDialog(null, "DriverLoaded Sucessfully");
				// System.out.println("Driver loaded successfully");
				con = DriverManager.getConnection(url, username, password);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString());
				//System.out.println(ex.toString());
			}
			Looknfeel();
			requestFocus();
			
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 11, 350, 239);
		contentPane.add(scrollPane);
		
		table = new javax.swing.JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"StdID", "stdName","stdProgram"
			}
		));
		
		scrollPane.setViewportView(table);
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			int rows = 0;
		while(rs.next()){
			//mythread.start();
			//table.setValueAt(rs.getInt(0), rows, 0);
			table.setValueAt(rs.getString(1), rows, 0);
			table.setValueAt(rs.getString(2), rows, 1);
			table.setValueAt(rs.getString(3), rows, 2);
			rows++;
		}
		st.close();
		
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
		
		}
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
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
}
