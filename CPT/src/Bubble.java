import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

class Bubble {
	// Instance Variables
	private int x, y;

	private int width;
	private int height;

	private Color color;
	private int speedY;

	// Constructors
	Bubble(int x, int y, int width, int height, Color color, int speedY) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.color = color;
		this.speedY = speedY;
	}

	Bubble() {
		x = 25;
		y = 25;
		width = 40;
		height = 40;
		int red = (int) (Math.random() * (256));// a random number 0-255
		int yellow = (int) (Math.random() * (256));// a random number 0-255
		int blue = (int) (Math.random() * (256));// a random number 0-255
		color = new Color(red, yellow, blue);// a random color
		speedY = 4;

	}

	// Setters

	public void setX(int newX) {
		x = newX;
	}

	public void setY(int newY) {
		y = newY;
	}

	public void setWidth(int newWidth) {
		width = newWidth;

	}

	public void setHeight(int newHeight) {
		height = newHeight;
	}

	public void setColor(Color newColor) {
		color = newColor;
	}

	public void setSpeedY(int newSpeedY) {
		speedY = newSpeedY;
	}

	// Getters

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Color getColor() {
		return color;
	}

	public double getSpeedY() {
		return speedY;
	}

	public void move() {
		y += speedY;

	}

	public void addSpeed(int i) {
		speedY += i;
	}

	// this method draws the circles
	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;

		g2D.setStroke(new BasicStroke(5));
		g2D.setPaint(color);
		g2D.fill(new Rectangle.Double(x, y, width, height));

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String toString() {
		return "Bubble:(" + x + "," + y + "), Width: " + width + " Height: " + height + " , color: " + color
				+ ", speedY " + speedY + ".";
	}

	public Bubble clone() {
		return new Bubble(x, y, width, height, color, speedY);
	}

}
