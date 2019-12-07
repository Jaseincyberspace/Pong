import java.awt.Color;

public class Ball extends Sprite { 	// This is a subclass of Sprite, so it can access the getters and setters from Sprite to define the width and positioning of the ball. 

	private static final  Color BALL_COLOUR = Color.WHITE;
	private static final int BALL_WIDTH = 25;
	private static final int BALL_HEIGHT = 25;
	

	public Ball(int panelWidth, int panelHeight) { // Constructor for the ball. When a ball needs to be constructed, this method is called. Note: panelWidth and panelHeight are passed as arguments from pongPanel class to Sprite class and then inherited to here from Sprite class.
		setWidth(BALL_WIDTH);
		setHeight(BALL_HEIGHT);
		setColour(BALL_COLOUR);
		setInitialPosition(panelWidth / 2 - (getWidth() / 2), panelHeight / 2 - (getHeight() / 2)); // divides the panel size by two and the size of the object by two to make sure the middle of the object is in the middle of the JPanel.
		resetToInitialPosition(); // calling a method inherited from Sprite class
	}
	
}// end Ball class
