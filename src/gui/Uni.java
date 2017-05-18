package gui;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class Uni extends JFrame implements ActionListener {

	static Connection con;
	static PreparedStatement ps;
	static String url = "jdbc:mysql://localhost:3306/studentschema", username = "root", password = "admin",
			query = "Select * from student";
	static Statement st;
	static ResultSet rs;

	Uni() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			JOptionPane.showMessageDialog(null, "DriverLoaded Successfully");
			con = DriverManager.getConnection(url, username, password);

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		setTitle("Everything's messed");
		setSize(400, 400);
		FlowLayout manager = new FlowLayout();
		setLayout(manager);

		JLabel jl = new JLabel("ME");

		JButton jb = new JButton("Insert again");
		JButton del = new JButton("Delete");
		JButton search = new JButton("Search");

		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String txt1 = JOptionPane.showInputDialog("Enter Student ID: ");
				String txt2 = JOptionPane.showInputDialog("Enter Student Name: ");
				String txt3 = JOptionPane.showInputDialog("Enter Student Course: ");
				try {
					ps = con.prepareStatement("insert into student (`stdID`,`stdName`, `stdProgram`) Values(?,?,?)");
					ps.setString(1, txt1.toString());
					ps.setString(2, txt2.toString());
					ps.setString(3, txt3.toString());

					ps.execute();
					ps.close();

				} catch (Exception es) {
					JOptionPane.showMessageDialog(null, es.toString());
				}
			}

		});
		del.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	//			Delete obj = new Delete();

			}

		});
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		//		Delete obj = new Delete();

			}

		});

		JPanel pane = new JPanel();
		pane.setBackground(Color.red);
		
		pane.add(jl);
//		jl.setLayout(manager);
//		jl.setBackground(Color.CYAN);
		add(jb);
		add(del);
		add(search);
		add(pane);

		setVisible(true);
		//dispose();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
