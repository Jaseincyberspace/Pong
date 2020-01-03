import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class PongPanel extends JPanel implements ActionListener, KeyListener {

	private final static Color BACKGROUND_COLOUR = Color.BLACK;
	private final static int TIMER_DELAY = 5;
		
	public PongPanel() {  // defines the background colour of the JPanel and instantiates a timer to manage the sequencing of things.
		setBackground(BACKGROUND_COLOUR);
		Timer timer = new Timer(TIMER_DELAY, this);
		timer.start();
		addKeyListener(this);
		setFocusable(true);
	}
	
	GameState gameState = GameState.Initialising; //Keeps track of what state the game is in
	// instantiate objects from their respective classes:
	Ball ball; 
	Paddle paddle1;
	Paddle paddle2;
	
	public void createObjects() { // adds the necessary attributes to the game objects by using their respective constructors. 
		ball = new Ball(getWidth(), getHeight());
		paddle1 = new Paddle(Player.One, getWidth(), getHeight());
		paddle2 = new Paddle(Player.Two, getWidth(), getHeight());
	}
	
	private void resetBall() {
		ball.resetToInitialPosition(); //resets ball to middle of screen
	}
	
	private final static int BALL_MOVEMENT_SPEED = 2;
	private void update() {
		switch(gameState) {
		case Initialising: {
			createObjects();
			gameState = GameState.Playing;
			ball.setXVelocity(BALL_MOVEMENT_SPEED);
			ball.setYVelocity(BALL_MOVEMENT_SPEED);
			break;
		}
		case Playing: {
			moveObject(paddle1); // move paddle 1
			moveObject(paddle2); // move paddle 2
			moveObject(ball);    // Move ball
			checkWallBounce();   // Check for wall bounce
			checkPaddleBounce(); // Check to see if ball rectangle intersects with paddle rectangle
			break;
		}
		case GameOver: {
			break;
		}
		}// end switch
	}// end update method
	
	private void moveObject(Sprite object) {
	      object.setXPosition(object.getXPosition() + object.getXVelocity(),getWidth());
	      object.setYPosition(object.getYPosition() + object.getYVelocity(),getHeight());
	 }// end moveObject method
	
	private void checkWallBounce()  { // uses conditional statements to test whether the ball is at the edge of the screen. If it is, reverse velocity.
		if(ball.getXPosition() <= 0) {
            // Hit left side of screen
            ball.setXVelocity(-ball.getXVelocity());
           resetBall();
       } else if(ball.getXPosition() >= getWidth() - ball.getWidth()) {
           // Hit right side of screen
           ball.setXVelocity(-ball.getXVelocity());
           resetBall();
       }
       if(ball.getYPosition() <= 0 || ball.getYPosition() >= getHeight() - ball.getHeight()) {
           // Hit top or bottom of screen
           ball.setYVelocity(-ball.getYVelocity());
       }
	}// end checkWallBounce method
	
	private void paintSprite(Graphics g, Sprite sprite) { // creates a Sprite class object called sprite and defines a colour, position and size.
		g.setColor(sprite.getColour());
		g.fillRect(sprite.getXPosition(), sprite.getYPosition(), sprite.getWidth(), sprite.getHeight());
	}
	
	private void checkPaddleBounce() {
		if(ball.getXVelocity() < 0 && ball.getRectangle().intersects(paddle1.getRectangle())) {
			ball.setXVelocity(BALL_MOVEMENT_SPEED);
		}
		if(ball.getXVelocity() > 0 && ball.getRectangle().intersects(paddle2.getRectangle())) {
			ball.setXVelocity(-BALL_MOVEMENT_SPEED);
		}
	}// end checkPaddleBounce method
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		paintDottedLine(g); // calls the white dotted line method as defined below.
		if(gameState != GameState.Initialising) { // paints the ball and paddles to the screen when GameState is not set to Initialising.
			paintSprite(g, ball);
			paintSprite(g, paddle1);
			paintSprite(g, paddle2);
		}
	}
	
private void paintDottedLine(Graphics g) { // defines a white dotted line that will go vertically down the centre of the screen
	Graphics2D g2d = (Graphics2D) g.create();
	Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] {9}, 0);
	g2d.setStroke(dashed);
	g2d.setPaint(Color.WHITE);
	g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight()); // starts drawing at x,y where x == half of the panel width and y == 0. Ends drawing at x,y where x == half of the panel width and y == the panel height
	g2d.dispose();
}
	
	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_W) { // handles movement of paddle 1
			paddle1.setYVelocity(-1);
		}
		else if(event.getKeyCode() == KeyEvent.VK_S) {
			paddle1.setYVelocity(1);
		}
		
		if(event.getKeyCode() == KeyEvent.VK_UP) { // handles movement of paddle 2
			paddle2.setYVelocity(-1);
		}
		else if(event.getKeyCode() == KeyEvent.VK_DOWN) {
			paddle2.setYVelocity(1);
		}
	}// end keyPressed method

	@Override
	public void keyReleased(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_W || event.getKeyCode() == KeyEvent.VK_S) {
			paddle1.setYVelocity(0);
		}
		if(event.getKeyCode() == KeyEvent.VK_UP || event.getKeyCode() == KeyEvent.VK_DOWN) {
			paddle2.setYVelocity(0);
		}
	}// end keyReleased method

	@Override
	public void actionPerformed(ActionEvent event) {
		update();
		repaint();
	}
	
}// end PongPanel class
