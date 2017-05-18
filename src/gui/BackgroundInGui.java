package gui;
import java.awt.Color;

import javax.swing.*;
public class BackgroundInGui extends JFrame {

	BackgroundInGui(){
		setTitle("777");
		
		JFrame myWindow = new JFrame("Hola!");
		setSize(300,300);
		 getContentPane().setBackground(new Color(70,80,70));
		// myWindow.setBackground(Color.BLUE);
      
		setVisible(true);
	}
	public static void main(String[] args) {

		BackgroundInGui in = new BackgroundInGui();
	}

}
