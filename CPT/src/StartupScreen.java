
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

///this is a class for the main screen that pops up first
public class StartupScreen extends JComponent implements ActionListener {
	JFrame startup = new JFrame();// frame for the main scree
	Graphics g;

	JButton playbutton = new JButton("PLAY");
	JButton infobutton = new JButton("How to play");

	JPanel titlename = new JPanel();
	Font titleFont = new Font("Comic Sans MS", Font.PLAIN, 55);
	Font buttonFont = new Font("Comic Sans MS", Font.PLAIN, 40);
	JPanel buttonpanel = new JPanel();

	JLabel Gname = new JLabel(" CATCH THE SQUARE ");

	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.setColor(Color.red);
		g.fillRect(0, 0, 600, 266);
	}

	public StartupScreen() {

		startup.setTitle("Catch the square");// sets the title for the frame
		startup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startup.setBounds(30, 30, 600, 800);
		startup.setVisible(true);
		startup.getContentPane().setBackground(Color.BLACK);
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 10.0;
		gc.weighty = 10.0;
		gc.insets = new Insets(5, 5, 5, 5);
		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.fill = GridBagConstraints.NONE;
		startup.setLayout(new GridBagLayout());

		JPanel empty1 = new JPanel();
		empty1.setBackground(Color.black);

		gc.gridwidth = 3;
		startup.add(empty1, gc);

		titlename.setBackground(Color.BLACK);
		Gname.setForeground(Color.YELLOW);
		Gname.setFont(titleFont);
		titlename.add(Gname);
		gc.gridwidth = 3;
		gc.gridy = 1;
		startup.add(titlename, gc);

		gc.gridwidth = 1;
		gc.gridy = 2;
		gc.gridx = 1;
		playbutton.setActionCommand("Play Button");
		playbutton.setFont(buttonFont);
		playbutton.addActionListener(this);
		startup.add(playbutton, gc);

		gc.gridx = 2;
		infobutton.setActionCommand("info");
		infobutton.setFont(buttonFont);
		infobutton.addActionListener(this);
		startup.add(infobutton, gc);
	}

	public void actionPerformed(ActionEvent e) {
		// to check if a person presses instruction button
		if (e.getActionCommand().equals("info")) {
			JOptionPane.showMessageDialog(null, "Your goal is not not let any square drop, and try to catch the square"
					+ " using the paddle. You have wait unitil the square fully goes down the paddle. You can use the edge of the paddle to catch ",
					"Instrcutions", JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getActionCommand().equals("Play Button")) {// to check
			startup.setVisible(false);
			TheBubblesGame window = new TheBubblesGame();// creates the main window
		}

	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				StartupScreen start = new StartupScreen();

			}
		});
	}

}
