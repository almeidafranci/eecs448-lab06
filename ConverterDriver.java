import javax.swing.JFrame;


public class ConverterDriver 
{
	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Safe Converter");
		Converter demo = new Converter();
		
		frame.getContentPane().add(demo.getContent());
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}