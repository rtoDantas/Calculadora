package calculadora.cal.visao;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JPanel;

@SuppressWarnings("serial")

public class Display extends JPanel{

	private final Label label;
	
	public Display() {
		setBackground(new Color(46, 49, 50));
		label = new Label("123456,7");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("courier", Font.PLAIN, 30));
		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25));
		add(label);
		
	}
	
}
