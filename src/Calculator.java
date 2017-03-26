import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Calculator extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	JButton button = new JButton();
	JTextArea display = new JTextArea();
	Double zmienna = null;
	Character znak = null;
	
	public Calculator()
	{
		setTitle("Calculator");
		setSize(280,260);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setBounds(300,280,300,280);
		
		setResizable(false);
		
		display.setEditable(false);
		display.setSize(280, 50);
		display.setLocation(3, 3);
		display.setBackground(Color.lightGray);
		
		
		Font czcionka = new Font("Calibri",Font.PLAIN,16);
		display.setFont(czcionka);
		display.setForeground(Color.white);
		display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		
		JPanel pane = new JPanel(new GridBagLayout());
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		pane.setBackground(Color.BLACK);
		
		zwrocGuzik(pane,"7", 0, 0, zwrocAkcjeNumeryczna(7));
		zwrocGuzik(pane,"8", 1, 0, zwrocAkcjeNumeryczna(8));
		zwrocGuzik(pane,"9", 2, 0, zwrocAkcjeNumeryczna(9));
		zwrocGuzik(pane,"%", 3, 0, zwrocAkcjeProcent());
		zwrocGuzikWiekszy(pane,"C", 4, 0, zwrocAkcjeKasowania());
		
		zwrocGuzik(pane,"4", 0, 1, zwrocAkcjeNumeryczna(4));
		zwrocGuzik(pane,"5", 1, 1, zwrocAkcjeNumeryczna(5));
		zwrocGuzik(pane,"6", 2, 1, zwrocAkcjeNumeryczna(6));
		zwrocGuzik(pane,"/", 3, 1, zwrocAkcjeDzielenia());
		
		zwrocGuzik(pane,"1", 0, 2, zwrocAkcjeNumeryczna(1));
		zwrocGuzik(pane,"2", 1, 2, zwrocAkcjeNumeryczna(2));
		zwrocGuzik(pane,"3", 2, 2, zwrocAkcjeNumeryczna(3));
		zwrocGuzik(pane,"*", 3, 2, zwrocAkcjeMnozenia());
		
		zwrocGuzik(pane,",", 0, 3, zwrocAkcjePrzecinka());
		zwrocGuzik(pane,"0", 1, 3, zwrocAkcjeNumeryczna(0));
		zwrocGuzik(pane,"+", 2, 3, zwrocAkcjeDodawania());
		zwrocGuzik(pane,"-", 3, 3, zwrocAkcjeOdejmowania());
	
		zwrocGuzikWiekszy(pane,"=", 4, 2, zwrocAkcjeRownania());
	
		
		this.getContentPane().add(display);
		this.getContentPane().add(pane);
		
		setVisible(true);
	}
	
	private void zwrocGuzik(JPanel rodzic, String etykieta, int kolumna, int wiersz, ActionListener akcjaGuzika) 
	{
		JButton przycisk = new JButton(etykieta);
		przycisk.setMaximumSize(new Dimension(100,120));
		GridBagConstraints parametry = new GridBagConstraints();
		parametry.gridx = kolumna;
		parametry.gridy = wiersz;
		przycisk.setPreferredSize(new Dimension(50,35));
		Font czcionka = new Font("Calibri", Font.BOLD ,15);
		przycisk.setFont(czcionka);
		parametry.insets = new Insets(2, 2, 2, 2);
		rodzic.add(przycisk, parametry);
		przycisk.addActionListener(akcjaGuzika);
		przycisk.setBackground(Color.lightGray);
	}
	
	private void zwrocGuzikWiekszy(JPanel rodzic, String etykieta, int kolumna, int wiersz, ActionListener akcjaGuzika) 
	{
		JButton przycisk = new JButton(etykieta);
		przycisk.setMaximumSize(new Dimension(100,120));
		GridBagConstraints parametry = new GridBagConstraints();
		parametry.gridx = kolumna;
		parametry.gridy = wiersz;
		parametry.gridwidth = 1;
		parametry.gridheight = 2;
		przycisk.setPreferredSize(new Dimension(50,74));
		Font czcionka = new Font("Calibri", Font.BOLD ,15);
		przycisk.setFont(czcionka);
		przycisk.setForeground(Color.white);
		parametry.insets = new Insets(2, 2, 2, 2);
		rodzic.add(przycisk, parametry);
		przycisk.addActionListener(akcjaGuzika);
		Color kolor = new Color(6,5,4);
		przycisk.setBackground(kolor);
	}
	
	
	private ActionListener zwrocAkcjeNumeryczna(int numer)
	{
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String aktualnaWartosc = display.getText();
				aktualnaWartosc = aktualnaWartosc + numer; 
				
				display.setText(aktualnaWartosc);
			}
		};	
	}
	
	private ActionListener zwrocAkcjeDodawania()
	{
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String aktualnaWartosc = display.getText();
				zmienna = Double.valueOf(aktualnaWartosc);
				display.setText("");
				znak = '+';
			}
		};
	}
	
	private ActionListener zwrocAkcjePrzecinka()
	{
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String aktualnaWartosc = display.getText();
				display.setText(aktualnaWartosc + ".");
			}
		};
	}
	
	private ActionListener zwrocAkcjeProcent()
	{
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String aktualnaWartosc = display.getText();
				Double wartosc = Double.valueOf(aktualnaWartosc);
				wartosc = wartosc/100;
				display.setText(""+wartosc);
			}
		};
	}
	
	private ActionListener zwrocAkcjeRownania()
	{
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String wartosc = display.getText();
				Double liczba = Double.valueOf(wartosc);
				Double wynik = null;
				
				switch (znak)
				{
				case '+':
					wynik = liczba + zmienna;
					break;
					
				case '-':
					wynik = zmienna - liczba;
					break;
					
				case '*':
					wynik = (liczba * zmienna);
					break;
					
				case '/':
					wynik = zmienna / liczba;
					break;
				}
	
				display.setText(wynik.toString());
				
			}
		};
	}
	
	private ActionListener zwrocAkcjeOdejmowania()
	{
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String aktualnaWartosc = display.getText();
				zmienna = Double.valueOf(aktualnaWartosc);
				display.setText("");
				znak = '-';
			}
		};
	}
	
	private ActionListener zwrocAkcjeMnozenia()
	{
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String aktualnaWartosc = display.getText();
				zmienna = Double.valueOf(aktualnaWartosc);
				display.setText("");
				znak = '*';	
			}
		};
	}
	
	private ActionListener zwrocAkcjeDzielenia()
	{
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String aktualnaWartosc = display.getText();
				zmienna = Double.valueOf(aktualnaWartosc);
				display.setText("");
				znak = '/';
			}
		};
	}
	
	private ActionListener zwrocAkcjeKasowania()
	{
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				display.setText("");
			}
		};
	}
}
