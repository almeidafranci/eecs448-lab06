import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;

public class Converter
{
	private JPanel panel;
	private JButton buttonFToC;
	private JButton buttonCToF;
	private JButton buttonFToK;
	private JButton buttonKToF;
	private JButton buttonCToK;
	private JButton buttonKToC;
	private JTextField text;
	private JLabel label;
	private JLabel resultLabel;
	
	public Converter()
	{
		panel = new JPanel();
		buttonFToC = new JButton("F to C");
		buttonCToF = new JButton("C to F");
		buttonFToK = new JButton("F to K");
		buttonKToF = new JButton("K to F");
		buttonCToK = new JButton("C to K");
		buttonKToC = new JButton("K to C");
		text = new JTextField(3);
		label = new JLabel("Enter a temperature to convert:");
		resultLabel = new JLabel("(The conversion will be shown here)");
		
		//Load the listener
		buttonFToC.addActionListener(FToCListener());
		buttonCToF.addActionListener(CToFListener());
		buttonFToK.addActionListener(FToKListener());
		
		//load the panel
		panel.add(label);
		panel.add(text);
		panel.add(buttonFToC);
		panel.add(buttonCToF);
		panel.add(buttonFToK);
		panel.add(buttonKToF);
		panel.add(buttonCToK);
		panel.add(buttonKToC);
		panel.add(resultLabel);
	}
	
	public Component getContent()
	{
		return (panel);
	}
	
	private ActionListener FToCListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();

				try {
					double tempInF = Double.parseDouble(input); // Convert String to double
					double tempInC = (tempInF-32)*(5.0/9.0); // Convert F to C
					String newText = String.format("%.2f",tempInF) + " F = " + String.format("%.2f",tempInC) + " C"; // Prepare message
					resultLabel.setText(newText); // Display temperature
				} catch (NumberFormatException ne) {
					resultLabel.setText("Invalid input");
				}
			}
		};
		
		return listener;
	}

	private ActionListener CToFListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();

				try {
					double tempInC = Double.parseDouble(input); // Convert String to double
					double tempInF = (tempInC*(9.0/5.0))+32; // Convert C to F
					String newText = String.format("%.2f",tempInC) + " C = " + String.format("%.2f",tempInF) + " F"; // Prepare message
					resultLabel.setText(newText); // Display temperature
				} catch (NumberFormatException ne) {
					resultLabel.setText("Invalid input");
				}
			}
		};
		
		return listener;
	}

	private ActionListener FToKListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();

				try {
					double tempInF = Double.parseDouble(input); // Convert String to double
					double tempInK = (tempInF+459.67)*(5.0/9.0); // Convert F to K
					String newText = String.format("%.2f",tempInF) + " F = " + String.format("%.2f",tempInK) + " K"; // Prepare message
					resultLabel.setText(newText); // Display temperature
				} catch (NumberFormatException ne) {
					resultLabel.setText("Invalid input");
				}
			}
		};
		
		return listener;
	}
}