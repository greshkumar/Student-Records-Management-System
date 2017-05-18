package gui;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MainApp1 extends JFrame implements ActionListener,FocusListener {
	MainApp1(){
		//JLabel jl = new JLabel("WELCOME TO Student Applications! ");
		setTitle("Database");
		setSize(850,600);
		JLabel back = new JLabel(new ImageIcon("src/update.jpg"));
		/*FlowLayout manager = new FlowLayout();
		setLayout(manager);*/
		//back.setLayout(new FlowLayout());
		JButton in = new JButton("Insert!");
		in.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GuiInsert obj = new GuiInsert();
			}
		});
		JButton search = new JButton("Search!");
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GuiSearch obj = new GuiSearch();
			}
		});

		JButton Delete = new JButton("Delete!");
		Delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GuiDelete obj = new GuiDelete();
			}
		});
		JButton Update = new JButton("Update!");
		Update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GuiUpdate obj = new GuiUpdate();
			}
		});
		JButton View = new JButton("View!");
		View.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GuiView obj = new GuiView();
			}
		});
		JButton exit = new JButton("Exit!");

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Thank you for using this application and now you're going to die!");
				System.exit(0);
			}

		});
		
		JPanel pain = new JPanel();
		//JPanel panel = new JPanel();
		
		pain.setBackground(Color.BLACK);
		/*GridLayout fam = new GridLayout(3, 3, 10, 10);
		pain.setLayout(fam);*/
		
		//pain.add(jl);
		pain.add(in);
		pain.add(search);
		pain.add(Delete);
		pain.add(Update);
		pain.add(View);
		pain.add(exit);
		pain.add(back);
		add(pain);
		 
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		MainApp1 app = new MainApp1();
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
