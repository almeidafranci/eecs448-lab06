import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.io.File;
import java.io.PrintWriter;

public class Voting
{
	private JPanel panel;
	private JButton candidateA;
	private JButton candidateB;
	private JButton candidateC;
	private JButton candidateD;
	private JTextField firstName;
	private JTextField lastName;
	private JLabel label1;
	private JLabel label2;
	private JLabel resultLabel;
	
	public Voting()
	{
		panel = new JPanel();
		candidateA = new JButton("A");
		candidateB = new JButton("B");
		candidateC = new JButton("C");
		candidateD = new JButton("D");
		firstName = new JTextField(6);
		lastName = new JTextField(6);
		label1 = new JLabel("First Name:");
		label2 = new JLabel("Last Name:");
		resultLabel = new JLabel("(The conversion will be shown here)");
		
		//Load the listener
		candidateA.addActionListener(VoteForA());
		
		//load the panel
		panel.add(label1);
		panel.add(firstName);
		panel.add(label2);
		panel.add(lastName);
		panel.add(candidateA);
		panel.add(candidateB);
		panel.add(candidateC);
		panel.add(candidateD);
		panel.add(resultLabel);
	}
	
	public Component getContent()
	{
		return (panel);
	}
	
	private ActionListener VoteForA()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String fName = firstName.getText();
				String lName = lastName.getText();

				if (!fName.equals("") && !lName.equals("")) {
					try {
						File file = new File(lName+"_"+fName+"_ballot.txt");
						if(file.createNewFile()){
							PrintWriter writer = new PrintWriter(lName+"_"+fName+"_ballot.txt", "UTF-8");
							writer.println("Candidate A");
							writer.close();
							resultLabel.setText("Thank you for your vote!");
						} else {
							resultLabel.setText("You already voted");
						}
					} catch (Exception ne) {
						resultLabel.setText("Something went wrong.");
					}
				} else {
					resultLabel.setText("Provide a Name and a Last Name");
				}

			}
		};
		
		return listener;
	}
}