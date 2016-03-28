import javax.swing.JFrame;


public class VotingDriver
{
	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Voting System");
		Voting votingDisplay = new Voting();
		
		frame.getContentPane().add(votingDisplay.getContent());
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}