import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;

public class Converter
{
	private JPanel panel;
	private JButton buttonFToC;
	private JButton buttonCToF;
	private JTextField text;
	private JLabel label;
	private JLabel resultLabel;
	
	public Converter()
	{
		panel = new JPanel();
		buttonFToC = new JButton("F to C");
		buttonCToF = new JButton("C to F");
		text = new JTextField(3);
		label = new JLabel("Enter a temperature to convert:");
		resultLabel = new JLabel("(The conversion will be shows here)");
		
		//Load the listener
		buttonFToC.addActionListener(FToCListener());
		buttonCToF.addActionListener(CToFListener());
		
		//load the panel
		panel.add(label);
		panel.add(text);
		panel.add(buttonFToC);
		panel.add(buttonCToF);
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
					String newText = "Temp in C: " + String.format("%.2f",tempInC); // Convert double to String with 2 decimal places
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
					String newText = "Temp in F: " + String.format("%.2f",tempInF); // Convert double to String with 2 decimal places
					resultLabel.setText(newText); // Display temperature
				} catch (NumberFormatException ne) {
					resultLabel.setText("Invalid input");
				}
			}
		};
		
		return listener;
	}
}