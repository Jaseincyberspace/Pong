import java.awt.Color;

public class Paddle extends Sprite {

	private static final int PADDLE_WIDTH = 20;
	private static final int PADDLE_HEIGHT = 120;
	private static final Color PADDLE_COLOUR = Color.white;
	private static final int DISTANCE_FROM_EDGE = 40;
	
	public Paddle (Player player, int panelWidth, int panelHeight) {
		setWidth(PADDLE_WIDTH);
		setHeight(PADDLE_HEIGHT);
		setColour(PADDLE_COLOUR);
		int xPos;
		if(player == Player.One) {
			xPos = DISTANCE_FROM_EDGE; // if player == Player.One then the paddle xPos just needs to be set to the DISANCE_FROM_EDGE of the JPanel.
		}
		else {
			xPos = panelWidth - DISTANCE_FROM_EDGE - getWidth(); // if player == Player.Two then the paddle needs to be at the right side of the JPanel, so we take the JPanel width and subtract the DISTANCE_FROM_EDGE then subtract the width of the panel.
		}
		setInitialPosition(xPos, panelHeight/2 - getHeight()/2);// divides the panel height by two and the height of the object by two to make sure the middle of the object is in the (vertical) middle of the JPanel.
		resetToInitialPosition(); // calling a method inherited from Sprite class
	}
	
}// end Paddle class
