import java.awt.Color;
import java.awt.Rectangle;

public class Sprite {
	private int initialXPosition, initialYPosition;
	private int xPosition, yPosition;
	private int xVelocity, yVelocity;
	private int width, height;
	private Color colour;
	
	// GETTERS:
	public int getXPosition() {return xPosition;}
	public int getYPosition() {return yPosition;}
	public int getXVelocity() {return xVelocity;}
	public int getYVelocity() {return yVelocity;}
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	public Color getColour() {return colour;}
	
	// SETTERS:
	public void setInitialPosition(int initialX, int initialY) { // defines what the starting position of an object should be
		initialXPosition = initialX;
		initialYPosition = initialY;
	}
	
	public void resetToInitialPosition() { // actions the setInitialPosition method because it assigns the starting positions to the object based on the values defined in the setInitialPosition method 
		setXPosition(initialXPosition);
		setYPosition(initialYPosition);
	}
	// These next two (four really) setters use method overloading. This means that the system will determine which version of the method should be run based on which paremeters are passed when the method is invoked. 
	// i.e. If setXPosition is called and one int is passed to it, the first version of the setter will run. if two ints are passed, the second version of the setter will run.
	public void setXPosition(int newXPosition) {
		xPosition = newXPosition;
	}
	public void setYPosition(int newYPosition) {
		yPosition = newYPosition;
	}
	
	public void setXPosition(int newXPosition, int panelWidth) { // panelWidth and panelHeight are default attributes of JPanel. This method will be called from within PongPanel class so when it is called it will have access to integer values for panelWidth and panelHeight which will be passed as arguments to these methods.
		xPosition = newXPosition;
		if(xPosition < 0) {  // if the horizontal position is off the left edge of the panel then we override it to be at the edge of the panel
			xPosition = 0;
		}
		else if(xPosition + width > panelWidth) { // if the horizontal position is off the right end of the panel then we override it to be at the right edge of the panel. We need to take into account the width of the object otherwise it would still overflow the edge of the panel.
			xPosition = panelWidth - width;
		}
	}
	
	public void setYPosition(int newYPosition, int panelHeight) { // if the vertical position is off the top of the panel then we override it to be at the top of the panel
		yPosition = newYPosition;
		if(yPosition < 0) {
			yPosition = 0;
		}
		else if(yPosition + width > panelHeight) { // if the vertical position is off the bottom of the panel then we override it to be at the bottom of the panel. We need to take into account the height of the object otherwise it would still overflow the bottom of the panel.
			yPosition = panelHeight - height;
		}
	}
	
	public void setXVelocity(int newXVelocity) {
		xVelocity = newXVelocity;
	}
	
	public void setYVelocity(int newYVelocity) {
		yVelocity = newYVelocity;
	}
	
	public void setWidth(int newWidth) {
		width = newWidth;
	}
	
	public void setHeight(int newHeight) {
		height = newHeight;
	}
	
	public void setColour(Color newColour) {
		colour = newColour;
	}
	
	public Rectangle getRectangle() {
		return new Rectangle(getXPosition(), getYPosition(), getWidth(), getHeight());
	}
}// end Sprite class
