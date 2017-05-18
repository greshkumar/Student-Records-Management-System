package gui;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class MainApp extends JFrame implements ActionListener,FocusListener {

	MainApp() {

		Looknfeel();
		//UserPass pass = new UserPass();
		setTitle("777");
		setSize(50, 250);

		JPanel panel = new JPanel();
		JButton insert1 = new JButton("Insert");
		insert1.setRequestFocusEnabled(false);
		insert1.addFocusListener(this);
		// insert1.addKeyListener(null);
		insert1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GuiInsert insert = new GuiInsert();
			}
		});
		JButton view1 = new JButton("View");
		view1.setRequestFocusEnabled(false);
		view1.addFocusListener(this);
		view1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
					JTable view = new JTable();
				
				// GuiView view = new GuiView();
			}
		});
		JButton search1 = new JButton("Search");
		search1.setRequestFocusEnabled(false);
		search1.addFocusListener(this);
		search1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GuiSearch search = new GuiSearch();
			}
		});
		JButton update1 = new JButton("Update");
		update1.setRequestFocusEnabled(false);
		update1.addFocusListener(this);
		update1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args) {
				GuiUpdate update = new GuiUpdate();
			}
		});
		JButton delete1 = new JButton("Delete");
		delete1.setRequestFocusEnabled(false);
		delete1.addFocusListener(this);
		delete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args) {
				GuiDelete delete = new GuiDelete();
			}
		});
		JButton exit = new JButton("Exit");
		exit.setRequestFocusEnabled(false);
		exit.addFocusListener(this);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args) {
				System.exit(0);
			}
		});
		panel.setBackground(Color.darkGray);
		panel.add(insert1);
		panel.add(view1);
		panel.add(update1);
		panel.add(delete1);
		panel.add(search1);
		panel.add(exit);
		add(panel);
		setVisible(true);
		/*
		 * else{ System.exit(0); }
		 */
	}

	static void Looknfeel(){
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	}
	public static void main(String[] args) {
		MainApp main = new MainApp();
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
