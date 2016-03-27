import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Random;

public class Dice
{
	private JPanel panel;
	private JButton button;
	private JTextField text;
	private JLabel label;
	private JLabel resultLabel;
	
	public Dice()
	{
		panel = new JPanel();
		button = new JButton("Roll");
		text = new JTextField(3);
		label = new JLabel("Enter a number of sides for the Dice:");
		resultLabel = new JLabel("(Your number will show here)");
		
		//Load the listener
		button.addActionListener(buttonListener());	
		
		//load the panel
		panel.add(label);
		panel.add(text);
		panel.add(button);
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
					Integer sides = Integer.parseInt(input); // Convert String to Integer
					Random randomGenerator = new Random(); // Create the random generator
					Integer randomInt = 1 + randomGenerator.nextInt(sides); // Generate an Integer with sides as range
					String newText = "Your number is: " + String.format("%d",randomInt); // Convert Integer to String and generate message
					resultLabel.setText(newText); // Display generated number
				} catch (NumberFormatException ne) {
					resultLabel.setText("Invalid input");
				}
			}
		};
		
		return listener;
	}	
}