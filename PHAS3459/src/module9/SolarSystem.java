package module9;

import javax.swing.*;
import java.awt.*;

/**
 * Main class that creates and display a JFrame containing a JLabel 
 * and a simplified graphical representation of the solar system
 * where the planets are depicted as having circular orbits.
 * @author Samuel Bradshaw
 */

public class SolarSystem {

	/** Create and display a JFrame containing a JLabel. */  
	private static void createAndDisplayGui() {    
		JFrame frame = new JFrame("Solar System");    // Exit application if window is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

		JPanel guipanel = new AnimationGuiPanel(); 
		guipanel.setBackground(Color.BLACK);
		frame.add(guipanel); 
		frame.setVisible(true); // Display the resulting frame  
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {   
			public void run() {     
				createAndDisplayGui();
			}
		});
	}
}