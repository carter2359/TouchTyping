/*
 *Date: November 6, 2019
 *Filename: TouchtyperPanel.java
 *Language: Java
 *Editor: Notepad++
 *Compiler: javac
 *Operating System Used: Windows 10
 */
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

/*
 *This class implements the first level of a simple touch typing
 *practice program.
 */
public class TouchtyperPanel extends JPanel {
	private final int WIDTH = 400, HEIGHT = 300;
	private final int DELAY = 18, IMAGE_SIZE = 50;

	private ImageIcon image; //current image
	private ImageIcon a, s, d, f;
	private ImageIcon j, k, l, semicolon;
	private Timer timer;
	private int x, y, moveX, moveY;
	private Random random;
	private int r;

/*
 *This method sets up the panel.
 */
	public TouchtyperPanel() {
		addKeyListener (new LetterListener());
		
		//images of the letters
		a = new ImageIcon("a.jpg");
		s = new ImageIcon("s.jpg");
		d = new ImageIcon("d.jpg");
		f = new ImageIcon("f.jpg");
		j = new ImageIcon("j.jpg");
		k = new ImageIcon("k.jpg");
		l = new ImageIcon("l.jpg");
		semicolon = new ImageIcon(";.jpg");
		
		random = new Random();
		
		image = a;

		x = 0;
		y = 40;
		moveX = moveY = 3;

		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.black);
		setFocusable(true);
		
		timer = new Timer(DELAY, new TouchtyperListener());
		timer.start();
	}
	
/*
 *This method produces the image in the current location.
 */
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		image.paintIcon(this, page, x, y);
	}

/*
 *This private class represents the action listener for the timer.
 */
	private class TouchtyperListener implements ActionListener {
		
/*
 *This method updates position of image and possibly the direction
 *of movement whenever the timer fires an action event.
 */
		public void actionPerformed(ActionEvent event) {
			x = x + moveX;
			y = y + moveY;

			if (x <= 0 || x >= WIDTH-IMAGE_SIZE)
				moveX = moveX * -1;

			if (y <= 0 || y >= HEIGHT-IMAGE_SIZE)
				moveY = moveY * -1;

			repaint();
		}
	}
	
/*
 *This private class represents the key listener for the program.
 *It contains code to generate the letters based on a random
 *generator and the user typing correctly.
 */
	private class LetterListener implements KeyListener {
		
/*
 *This method responds to the user typing the correct letter by changing the letter.
 */
		public void keyPressed(KeyEvent event) {
			switch (event.getKeyCode()) {
				case KeyEvent.VK_A:
					if(image==a){
						getNextLetter();
					}
					break;
				case KeyEvent.VK_S:
					if(image==s){
						getNextLetter();
					}
					break;
				case KeyEvent.VK_D:
					if(image==d){
						getNextLetter();
					}
					break;
				case KeyEvent.VK_F:
					if(image==f){
						getNextLetter();
					}
					break;
				case KeyEvent.VK_J:
					if(image==j){
						getNextLetter();
					}
					break;
				case KeyEvent.VK_K:
					if(image==k){
						getNextLetter();
					}
					break;
				case KeyEvent.VK_L:
					if(image==l){
						getNextLetter();
					}
					break;
				case KeyEvent.VK_SEMICOLON:
					if(image==semicolon){
						getNextLetter();
					}
					break;
			}
			repaint();
		}
		
/*
 *This method generates the next letter for the user.
 */
		public void getNextLetter() {
			r = random.nextInt(8);
			image = getLetter(r);
		}
		
/*
 *This method determines next letter by a random number generator.
 */
		public ImageIcon getLetter(int randomGenerated) {
			switch (randomGenerated) {
				case (0):
					return a;
				case (1):
					return s;
				case (2):
					return d;
				case (3):
					return f;
				case (4):
					return j;
				case (5):
					return k;
				case (6):
					return l;
				case (7):
					return semicolon;
			}
			return null;
		}
		
/*
 *Below are empty definitions for unused event methods.
 */
		public void keyTyped(KeyEvent event) {}
		public void keyReleased(KeyEvent event) {}
	}
}
