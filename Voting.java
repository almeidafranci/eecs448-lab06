import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.io.File;
import java.nio.file;

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
							Charset charset = Charset.forName("US-ASCII");
							String s = "camdidate a";
							try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
							    writer.write(s, 0, s.length());
							} catch (IOException x) {
							    System.err.format("IOException: %s%n", x);
							}
							resultLabel.setText("ok");
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