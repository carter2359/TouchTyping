/*
 *Date: November 5, 2019
 *Filename: Touchtype.java
 *Language: Java
 *Editor: Notepad++
 *Compiler: javac
 *Operating System Used: Windows 10
 */
 
import javax.swing.*;

/*
 *This class runs a touch typing practice program.
 */
public class Touchtyper {
	
/*
 *This method displays the main frame of the program.
 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Touchtyper");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new TouchtyperPanel());

		frame.pack();
		frame.setVisible(true);
	}
}
