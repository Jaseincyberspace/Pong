
public class Sprite {
	private int initialXPosition, initialYPosition;
	private int xPosition, yPosition;
	private int xVelocity, yVelocity;
	private int width, height;
	
	// GETTERS:
	public int getXPosition() {
		return xPosition;
	}
	
	public int getYPosition() {
		return yPosition;
	}
	
	public int getXVelocity() {
		return xVelocity;
	}
	
	public int getYVelocity() {
		return yVelocity;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	// SETTERS:
	public void setInitialPosition(int initialX, int initialY) {
		initialXPosition = initialX;
		initialYPosition = initialY;
	}
	
	public void resetToInitialPosition() {
		setXPosition(initialXPosition);
		setYPosition(initialYPosition);
	}
	// These next two (four really) setters use method overloading. This means that the system will determine which version of the method should be run based on which paremeters are passed when the method is invoked. 
	// i.e. If setXPosition is called and one int is passed to it, the first version of the setter will run. if two ints are passed, the second version of the setter will run.
	public void setXPosition(int newXPosition) {
		xPosition = newXPosition;
	}
	public void setYPosition(int newYPosition) {
		xPosition = newYPosition;
	}
	
	public void setXPosition(int newXPosition, int panelWidth) {
		xPosition = newXPosition;
		if(xPosition < 0) {
			xPosition = 0;
		}
		else if(xPosition + width > panelWidth) {
			xPosition = panelWidth - width;
		}
	}
	
	public void setYPosition(int newYPosition, int panelHeight) {
		yPosition = newYPosition;
		if(yPosition < 0) {
			yPosition = 0;
		}
		else if(yPosition + width > panelHeight) {
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
	
}// end Sprite class
