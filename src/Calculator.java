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
	Display display = new Display();
	Double zmienna = null;
	Character znak = null;
	
	public Calculator()
	{
		setTitle("Calculator");
		setSize(280,260);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setBounds(300,280,300,280);
		
		setResizable(false);
		
		
		JPanel pane = new JPanel(new GridBagLayout());
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		pane.setBackground(Color.BLACK);
		
		new Button(pane,"7", 0, 0, zwrocAkcjeNumeryczna(7));
		new Button(pane,"8", 1, 0, zwrocAkcjeNumeryczna(8));
		new Button(pane,"9", 2, 0, zwrocAkcjeNumeryczna(9));
		new Button(pane,"%", 3, 0, zwrocAkcjeProcent());
		new ButtonWiekszy(pane,"C", 4, 0, zwrocAkcjeKasowania());
		
		new Button(pane,"4", 0, 1, zwrocAkcjeNumeryczna(4));
		new Button(pane,"5", 1, 1, zwrocAkcjeNumeryczna(5));
		new Button(pane,"6", 2, 1, zwrocAkcjeNumeryczna(6));
		new Button(pane,"/", 3, 1, zwrocAkcjeDzielenia());
		
		new Button(pane,"1", 0, 2, zwrocAkcjeNumeryczna(1));
		new Button(pane,"2", 1, 2, zwrocAkcjeNumeryczna(2));
		new Button(pane,"3", 2, 2, zwrocAkcjeNumeryczna(3));
		new Button(pane,"*", 3, 2, zwrocAkcjeMnozenia());
		
		new Button(pane,",", 0, 3, zwrocAkcjePrzecinka());
		new Button(pane,"0", 1, 3, zwrocAkcjeNumeryczna(0));
		new Button(pane,"+", 2, 3, zwrocAkcjeDodawania());
		new Button(pane,"-", 3, 3, zwrocAkcjeOdejmowania());
	
		new ButtonWiekszy(pane,"=", 4, 2, zwrocAkcjeRownania());
		
		this.getContentPane().add(display);
		this.getContentPane().add(pane);
		
		setVisible(true);
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
