import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;

import javax.swing.JTextArea;

public class Display extends JTextArea{
	
	public Display(){
		
		setEditable(false);
		setSize(280, 50);
		setLocation(3, 3);
		setBackground(Color.lightGray);
		
		Font czcionka = new Font("Calibri",Font.PLAIN,16);
		setFont(czcionka);
		setForeground(Color.white);
		setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	}

}
