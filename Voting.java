import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.io.File;
import java.io.PrintWriter;

public class Voting
{
	private JPanel panel;
	private String nameA;
	private String nameB;
	private String nameC;
	private String nameD;
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
		nameA = "SpongeBob";
		nameB = "Patrick";
		nameC = "Squidward";
		nameD = "Mr. Krabs";
		candidateA = new JButton(nameA);
		candidateB = new JButton(nameB);
		candidateC = new JButton(nameC);
		candidateD = new JButton(nameD);
		firstName = new JTextField(9);
		lastName = new JTextField(9);
		label1 = new JLabel("First Name:");
		label2 = new JLabel("Last Name:");
		resultLabel = new JLabel("(Chose one of the candidates)");
		
		//Load the listener
		candidateA.addActionListener(VoteForA());
		candidateB.addActionListener(VoteForB());
		candidateC.addActionListener(VoteForC());
		candidateD.addActionListener(VoteForD());
		
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
	
	private void HandleVote(String candidate){
		String fName = firstName.getText();
		String lName = lastName.getText();

		if (!fName.equals("") && !lName.equals("")) {
			try {
				File file = new File(lName+"_"+fName+"_ballot.txt");
				if(file.createNewFile()){
					PrintWriter writer = new PrintWriter(lName+"_"+fName+"_ballot.txt", "UTF-8");
					writer.println(candidate);
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
	
	private ActionListener VoteForA()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				HandleVote(nameA);
			}
		};
		
		return listener;
	}
	
	private ActionListener VoteForB()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				HandleVote(nameB);
			}
		};
		
		return listener;
	}
	
	private ActionListener VoteForC()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				HandleVote(nameC);
			}
		};
		
		return listener;
	}
	
	private ActionListener VoteForD()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				HandleVote(nameD);
			}
		};
		
		return listener;
	}
}