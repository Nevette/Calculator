import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonWiekszy extends JButton{

	public ButtonWiekszy(JPanel rodzic, String etykieta, int kolumna, int wiersz, ActionListener akcjaGuzika) 
	{
		super(etykieta);
		setMaximumSize(new Dimension(100,120));
		GridBagConstraints parametry = new GridBagConstraints();
		parametry.gridx = kolumna;
		parametry.gridy = wiersz;
		parametry.gridwidth = 1;
		parametry.gridheight = 2;
		setPreferredSize(new Dimension(50,74));
		Font czcionka = new Font("Calibri", Font.BOLD ,15);
		setFont(czcionka);
		setForeground(Color.white);
		parametry.insets = new Insets(2, 2, 2, 2);
		
		rodzic.add(this, parametry);
		addActionListener(akcjaGuzika);
		Color kolor = new Color(6,5,4);
		setBackground(kolor);
	}

}
