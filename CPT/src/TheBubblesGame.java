
/*The Bubble Game*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class TheBubblesGame extends JFrame {
	JLabel label;
	Bubble bubble1, bubble2, bubble3, bubble4;
	private int playerY = 770;

	Timer myTimer;// a Timer used to generate action events
	BufferedImage bImage;
	Graphics g;
	ImageIcon iIcon;
	public int playerX = 310;
	private int score = 0;
	boolean gameover = false;

	private boolean play = false;

	private int[] randomred = new int[5];//made array for randomred (R,G,B)
	private int[] randomgreen = new int[5];//made array for randomgreen(R,G,B)
	private int[] randomblue = new int[5];//made array for randomblue (R,G,B)
	private Color[] colourarray = new Color[5]; //colour array of random colours//

	private int[] x = new int[5];//array to make random x
	private int[] y = new int[5];//array to store random y

	
	String key = "";
	Font scoreFont = new Font("Comic Sans MS", Font.PLAIN, 25);

	// the Bubbles constructor
	public TheBubblesGame() {
		// array for randomred (R,G,B), makes and store randomred
		for (int i = 0; i < 5; i++) {
			int random = (int) ((255 - 1 + 1) * Math.random() + 1);
			randomred[i] = random;
		}

		// array for randomgreen (R,G,B), makes and store randomgreen
		for (int i = 0; i < 5; i++) {
			int random = (int) ((255 - 1 + 1) * Math.random() + 1);
			randomgreen[i] = random;
		}

		// array for randomblue (R,G,B), makes and store randomblue
		for (int i = 0; i < 5; i++) {
			int random = (int) ((255 - 1 + 1) * Math.random() + 1);
			randomblue[i] = random;
		}

		// colour array
		for (int i = 0; i < 5; i++) {
			colourarray[i] = new Color(randomred[i], randomgreen[i], randomblue[i]);
		}

		// randomize x
		for (int i = 0; i < 5; i++) {
			x[i] = (int) ((550 - 15 + 1) * Math.random() + 15);
		}

		/// for level1
		y[0] = -200;
		for (int i = 1; i < 5; i++) {
			y[i] = y[i - 1] - 200;
		}

		for (int i = 0; i < 5; i++) {
			System.out.println("Y at " + i + " is " + y[i]);
		}
		// these lines set the window's properties
		setTitle("Catch the Square");// sets the title for the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 30, 600, 800);
		// the code below makes a Graphics object on which we can paint stuff
		// and associates this Graphics object with a label to be displayed
		// in our window.
		label = new JLabel();// a JLabel that covers the frame, used to display an image
		// a BufferedImage is a virtual image object, like a canvas
		bImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		g = bImage.getGraphics();// access the graphics object of the BufferedImage

		// by invoking the Circle class constructor with 4 parameters

		bubble1 = new Bubble();// parameterless constructor
		bubble2 = new Bubble(x[0], y[0], 40, 40, colourarray[0], 4);// red 250
		bubble3 = new Bubble(x[1], y[1], 40, 40, colourarray[1], 4);// blue 450
		bubble4 = new Bubble(x[2], y[2], 40, 40, colourarray[2], 4);// green 650
		
		
		
//the code below is for making the white paddle move left and right, acoording to the keys you use
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				Bubble x = new Bubble();

				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					key = "left";
					if (playerX < 50) {
						playerX = 30;
					} else {
						playerX -= 50;
					}
					playerX -= 30;

				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					key = "right";
					if (playerX >= 450) {
						playerX = 480;
					} else {
						playerX += 50;
					}
				}
			}

		});

		// a Timer object used to control the FPS for this animation
		myTimer = new Timer(48, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				moveBubbles();
				g.setColor(Color.BLACK);// a black background
				g.fillRect(0, 0, getWidth(), getHeight());// clear the frame

				drawBubbles();
				drawPaddle(g);
				iIcon = new ImageIcon(bImage);// makes an ImageIcon from BufferedImage
				label.setIcon(iIcon);// applies the image onto label that covers the frame
				add(label);// this adds the label with the image onto the frame
				setVisible(true);// makes the frame visible

				repaint();

			}
		});
		myTimer.start();

		// we print out information about bubbles
		// Java will automatically call the toString() method
		System.out.println("bubble1 " + bubble1);
		System.out.println("bubble2 " + bubble2);
		System.out.println("bubble3 " + bubble3);
		System.out.println("bubble4 " + bubble4);

	}

	public void drawPaddle(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		// paddle
		g2.setColor(Color.WHITE);
		g2.fillRect(playerX, playerY, 120, 20);
		repaint();

	}

	
	//boolean variables to check if level 1 bubbles have dropped
	private boolean firstb1 = false; 
	private boolean firstb2 = false;
	private boolean firstb3 = false;
	private boolean firstb4 = false;
	
	
	//boolean variables to check if level 2 bubbles have drop
	private boolean secondb1 = false;
	private boolean secondb2 = false;
	private boolean secondb3 = false;
	private boolean secondb4 = false;
			

	
	
	
	public void moveBubbles() {

		
		//this code below is to make the bubble go continously and change the speed
		if (bubble1.getY() >= 800 && score <= 65) {
			bubble1.setX((int) ((550 - 15 + 1) * Math.random() + 15));
			bubble1.setY(-25);
			firstb1 = true;

		}
		else if (bubble1.getY() >= 800 && score >= 120&&score<=204) {
			if (firstb1==true) {
			bubble1.setX((int) ((550 - 15 + 1) * Math.random() + 15));
			bubble1.setY(-25);
			bubble1.setSpeedY(8);
			firstb1=false;
			}else {
				bubble1.setX((int) ((550 - 15 + 1) * Math.random() + 15));
				bubble1.setY(-25);
				secondb1=true;
			}
		}
		else if (bubble1.getY()>=800 && score >=232) {
			if (secondb1 ==true) {
				bubble1.setX((int) ((550 - 15 + 1) * Math.random() + 15));
				bubble1.setY(-25);
				bubble1.setSpeedY(12);
				secondb1=false;
			}
			else {
				bubble1.setX((int) ((550 - 15 + 1) * Math.random() + 15));
				bubble1.setY(-25);
			}
		}
		bubble1.move();
		

		
		
		
		
		
		
		if (bubble2.getY() >= 800 && score <= 65) {
			bubble2.setX((int) ((550 - 15 + 1) * Math.random() + 15));
			bubble2.setY(-25);
			firstb2 = true;

		} else if (bubble2.getY() >= 800 && score >=120&&score<=204) {
			if (firstb2==true) {
			bubble2.setX((int) ((550 - 15 + 1) * Math.random() + 15));
			bubble2.setY(-225);
			bubble2.setSpeedY(8);
			firstb2=false;
			}
			else {
				bubble2.setX((int) ((550 - 15 + 1) * Math.random() + 15));
				bubble2.setY(-25);
				secondb2=true;
			}
		}
		else if (bubble2.getY()>=800 && score >=232) {
			if (secondb2==true) {
				bubble2.setX((int) ((550 - 15 + 1) * Math.random() + 15));
				bubble2.setY(-225);
				bubble2.setSpeedY(12);
				secondb2=false;
			}
			else {
				bubble2.setX((int) ((550 - 15 + 1) * Math.random() + 15));
				bubble2.setY(-25);
			}
		}
		bubble2.move();

		
		
		
		
		
		if (bubble3.getY() >= 800 && score <= 65) {
			bubble3.setX((int) ((550 - 15 + 1) * Math.random() + 15));
			bubble3.setY(-25);
			firstb3 = true;

		} else if (bubble3.getY() >= 800&&score>=120&&score<=204) {
			if (firstb3==true) {
			bubble3.setX((int) ((550 - 15 + 1) * Math.random() + 15));
			bubble3.setY(-425);
			bubble3.setSpeedY(8);
			firstb3=false;
			}
		
		else {
			bubble3.setX((int) ((550 - 15 + 1) * Math.random() + 15));
			bubble3.setY(-25);
			secondb3=true;
		}
		}
		else if (bubble3.getY()>=800 && score >=232) {
			if (secondb3==true) {
				bubble3.setX((int) ((550 - 15 + 1) * Math.random() + 15));
				bubble3.setY(-425);
				bubble3.setSpeedY(12);
				secondb3=false;
			}
			else {
				bubble3.setX((int) ((550 - 15 + 1) * Math.random() + 15));
				bubble3.setY(-25);
			
			}
		}
		bubble3.move();
		
		

		if (bubble4.getY() >= 800 && score <= 65) {
			bubble4.setX((int) ((550 - 15 + 1) * Math.random() + 15));
			bubble4.setY(-25);
			firstb4 = true;

		} else if (bubble4.getY() >= 800 && score >=120&&score<=204) {
			if (firstb4==true) {
			bubble4.setX((int) ((550 - 15 + 1) * Math.random() + 15));
			bubble4.setY(-625);
			bubble4.setSpeedY(8);
			firstb4=false;
			}
		
		else {
			bubble4.setX((int) ((550 - 15 + 1) * Math.random() + 15));
			bubble4.setY(-25);
			secondb4=true;
		}
		}
		else if (bubble4.getY()>=800 && score >=232) {
			if (secondb4==true) {
			bubble4.setX((int) ((550 - 15 + 1) * Math.random() + 15));
			bubble4.setY(-625);
			bubble4.setSpeedY(12);
			secondb4=false;
		}
		else {
			bubble4.setX((int) ((550 - 15 + 1) * Math.random() + 15));
			bubble4.setY(-25);
		}
		}
		bubble4.move();

	
	}

	public void drawBubbles() {
		bubble1.draw(g);
		bubble2.draw(g);
		bubble3.draw(g);
		bubble4.draw(g);
		g.setFont(scoreFont);
		g.setColor(Color.white);
		g.drawString("SCORE: " + score, 410, 40);

		
		//the code below checks for collison, increases the score if the square hits the paddle
		//and pauses the screen and bring new one if the square touches the ground
		if (new Rectangle(bubble1.getX(), bubble1.getY(), bubble1.getWidth(), bubble1.getHeight())
				.intersects(new Rectangle(playerX, playerY, 120, 20))) {

			score++;
		} else if (new Rectangle(bubble1.getX(), bubble1.getY(), bubble1.getWidth(), bubble1.getHeight())
				.intersects(new Rectangle(playerX + 120, playerY, getWidth() - playerX + 120, 20))) {
		
			myTimer.stop();
			setVisible(false);
			exit();

		} else if (new Rectangle(bubble1.getX(), bubble1.getY(), bubble1.getWidth(), bubble1.getHeight())
				.intersects(new Rectangle(0, playerY, playerX - 1, 20))) {
			
			myTimer.stop();
			setVisible(false);
			exit();

		}

		
		if (new Rectangle(bubble2.getX(), bubble2.getY(), bubble2.getWidth(), bubble2.getHeight())
				.intersects(new Rectangle(playerX, playerY, 120, 20))) {
			score++;

		} else if (new Rectangle(bubble2.getX(), bubble2.getY(), bubble2.getWidth(), bubble2.getHeight())
				.intersects(new Rectangle(playerX + 120, playerY, getWidth() - playerX + 120, 20))) {
			myTimer.stop();
			setVisible(false);
			exit();
		} else if (new Rectangle(bubble2.getX(), bubble2.getY(), bubble2.getWidth(), bubble2.getHeight())
				.intersects(new Rectangle(0, playerY, playerX - 1, 20))) {
			myTimer.stop();
			setVisible(false);
			exit();

		}
		
		

		if (new Rectangle(bubble3.getX(), bubble3.getY(), bubble3.getWidth(), bubble3.getHeight())
				.intersects(new Rectangle(playerX, playerY, 120, 20))) {
			score++;

		} else if (new Rectangle(bubble3.getX(), bubble3.getY(), bubble3.getWidth(), bubble3.getHeight())
				.intersects(new Rectangle(playerX + 120, playerY, getWidth() - playerX + 120, 20))) {
			
			myTimer.stop();
			setVisible(false);
			exit();
		} else if (new Rectangle(bubble3.getX(), bubble3.getY(), bubble3.getWidth(), bubble3.getHeight())
				.intersects(new Rectangle(0, playerY, playerX - 1, 20))) {
			
			myTimer.stop();
			setVisible(false);
			exit();

		}
		
		

		if (new Rectangle(bubble4.getX(), bubble4.getY(), bubble4.getWidth(), bubble4.getHeight())
				.intersects(new Rectangle(playerX, playerY, 120, 20))) {
			score++;
			
		} else if (new Rectangle(bubble4.getX(), bubble4.getY(), bubble4.getWidth(), bubble4.getHeight())
				.intersects(new Rectangle(playerX + 120, playerY, getWidth() - playerX + 120, 20))) {
			
			myTimer.stop();
			setVisible(false);
			exit();
		} else if (new Rectangle(bubble4.getX(), bubble4.getY(), bubble4.getWidth(), bubble4.getHeight())
				.intersects(new Rectangle(0, playerY, playerX - 1, 20))) {

			myTimer.stop();
			setVisible(false);
			exit();
		}
		

		
	}

	public void exit() {
		myTimer.stop();
		setVisible(false);
		new ExitScreen(); // calling exit screen class
	}

}
