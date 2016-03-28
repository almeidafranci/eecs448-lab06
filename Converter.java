import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;

public class Converter
{
	private JPanel panel;
	private JButton button;
	private JButton button2;
	private JTextField text;
	private JLabel label;
	private JLabel resultLabel;
	
	public Converter()
	{
		panel = new JPanel();
		button = new JButton("Convert");
		button2 = new JButton("Convert C to F");
		text = new JTextField(3);//3 cols, not 20 chars
		label = new JLabel("Enter a temperature from F to C");
		resultLabel = new JLabel("(The conversion will be shows here)");
		
		//Load the listener
		button.addActionListener(buttonListener());
		
		//load the panel
		panel.add(label);
		panel.add(text);
		panel.add(button);
		panel.add(button2);
		panel.add(resultLabel);
	}
	
	public Component getContent()
	{
		return (panel);
	}
	
	private ActionListener buttonListener()
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
}