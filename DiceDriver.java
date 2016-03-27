import javax.swing.JFrame;


public class DiceDriver
{
	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Dice Program");
		Dice diceDisplay = new Dice();
		
		frame.getContentPane().add(diceDisplay.getContent());
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}