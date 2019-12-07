import javax.swing.JFrame; // The JFrame class provides us with a straightforward way to create a full-featured window and to easily customise it to our needs. By default, the graphical style of the window created – such as the border, window edges, and the minimise and close buttons – will be determined by your operating system.

public class Pong extends JFrame {			// To use JFrame, we need to “extend” from the JFrame class.
	// Set constants for important values that must not change
	private final static String WINDOW_TITLE = "Pong";
	private final static int WINDOW_WIDTH = 800;
	private final static int WINDOW_HEIGHT = 600;
	
	// Constructor for Pong class, which extends JFrame class. 
	public Pong() {		
		setTitle(WINDOW_TITLE); 	// Accessing attributes of the JFrame class and giving them values.
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);  // displays the JFrame in the centre of the primary monitor.
		add(new PongPanel());	// adds a JPanel which fits inside the JFrame and displays graphics.
	}

	public static void main(String[] args) {
		new Pong(); // instantiate the Pong class, thus creating a new GUI window for the application to display output to.


	}// end main method
}// end Pong class
