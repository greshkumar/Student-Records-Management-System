package gui;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.sql.*;
import java.util.Scanner;

import javax.swing.*;

public class GuiView extends JFrame implements ActionListener {

	 Connection con;
	 PreparedStatement ps;
	 String url = "jdbc:mysql://localhost:3306/guischema", username = "root", password = "admin",
			query = "Select * from studentdatabase order by stdName";
	 Statement st;
	 ResultSet rs;

	GuiView() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			JOptionPane.showMessageDialog(null, "DriverLoaded Sucessfully");
			// System.out.println("Driver loaded successfully");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		setTitle("777");
		setSize(200, 250);
		FlowLayout manager = new FlowLayout();
		setLayout(manager);

		JButton btn1 = new JButton("View");
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// JOptionPane.showMessageDialog(null, "There");
				try {
					st = con.createStatement();
					rs = st.executeQuery(query);
					String[] columnNames = { "ID", "Name", "Program" };
					String[][] data = { { rs.getString(1) + ".	" + rs.getString(2) + "	   " + rs.getString(3)
							+ "  	" + rs.getString(4) } };
					//JTable table = new JTable(data, columnNames);
					//JScrollPane scrollPane = new JScrollPane(table);
					//table.setFillsViewportHeight(true);
					//add(table);
					st.close();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.toString());
					//System.out.println(ex.toString());
				}
			}
		});
		add(btn1);

		setVisible(true);
	}

	/*public static void main(String[] args) {
		GuiView view = new GuiView();

	}*/

	@Override
	public void actionPerformed(ActionEvent e) {

	}


}
