import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Button extends JButton{
	
	
	public Button (JPanel rodzic, String etykieta, int kolumna, int wiersz, ActionListener akcjaGuzika) 
	{
		super(etykieta);
		setMaximumSize(new Dimension(100,120));
		GridBagConstraints parametry = new GridBagConstraints();
		parametry.gridx = kolumna;
		parametry.gridy = wiersz;
		setPreferredSize(new Dimension(50,35));
		Font czcionka = new Font("Calibri", Font.BOLD ,15);
		setFont(czcionka);
		parametry.insets = new Insets(2, 2, 2, 2);
		
		rodzic.add(this,parametry);
		addActionListener(akcjaGuzika);
		setBackground(Color.lightGray);
	}
	
	
	
}
