import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;

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
				resultLabel.setText(input);
			}
		};
		
		return listener;
	}	
}