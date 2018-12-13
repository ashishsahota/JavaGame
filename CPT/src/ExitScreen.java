import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;
import java.awt.*;

public class ExitScreen extends TheBubblesGame implements ActionListener {
	JLabel exitlabel = new JLabel();
	JButton exitbutton = new JButton();
	Font exitfont = new Font("Comic Sans MS", Font.PLAIN, 25);
	JPanel buttonlabel = new JPanel();

	// this make a another screen
	ExitScreen() {
		setBounds(700, 30, 500, 500);
		setVisible(true);
		setTitle("YOU LOSS");

		myTimer.stop(); // stopping the timer..THIS IS REQUIRED

		exitlabel.setFont(exitfont);
		exitlabel.setVisible(true);
		exitlabel.setForeground(Color.yellow);
		exitlabel.setText("   :( GAME OVER and you loss");
		exitlabel.setBounds(0, 20, 500, 100);

		getContentPane().add(exitlabel);
		exitbutton.setFont(exitfont);

		exitbutton.setText("EXIT");
		buttonlabel.add(exitbutton);
		exitbutton.addActionListener(this);

		buttonlabel.setBounds(0, 300, 50, 50);
		buttonlabel.setBackground(Color.BLACK);
		buttonlabel.setVisible(true);
		getContentPane().add(buttonlabel);
		getContentPane().setBackground(Color.BLACK);

		// Declare and initialize a Graphics2 Graphics g2 = new Graphics(g);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

}
