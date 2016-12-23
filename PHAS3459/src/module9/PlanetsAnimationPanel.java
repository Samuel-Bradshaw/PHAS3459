package module9;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Class extending the JPanel class for a simplified graphical representation of the solar system
 * where the planets are depicted as having circular orbits. 
 * Implements ActionListener for the motion of the planets around the sun.  
 * @author Samuel Bradshaw
 *
 */

public class PlanetsAnimationPanel extends JPanel implements ActionListener {

	ArrayList<Planet> Planets = new ArrayList< Planet>(); //The planets we want to displace graphically 
	private int delay = 10; // delay in ms between steps 
	private int delta = 0;    
	private Timer animationTimer; // timer controlling frame rate 

	//Constructor
	PlanetsAnimationPanel(ArrayList<Planet> planets, int width, int height) {   
		//Set background colour to black
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(width,height));

		Planets = planets;
		animationTimer = new Timer(delay, this); 
	}

	//Override the superclass's paintComponent method
	protected void paintComponent(Graphics g){
		super.paintComponent(g);

		//Centred origin coords:
		int x0 = getWidth()/2;
		int y0 = getHeight()/2;

		//Represent the Planets as graphics:
		for(Planet planeti : Planets){ 						
			
			//Polar coordinates of the planet, in relation to the sun centred at the origin:
			int R = planeti.getOrbitalRadius();
			double angle = planeti.getAngle();
			//Cartesian coordinates of the planet:
			int x = (int) Math.round(x0 + R*Math.cos(angle));
			int y = (int) Math.round(y0 + R*Math.sin(angle));
	
			int r = planeti.getPlanetSize();
			g.fillOval(x - (r/2), y - (r/2), r, r); 
			
			g.setColor(planeti.getColor());
		}
	}

	/**
	 * Method painting the planets in their updated position in each time step.
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e){
		for(int i = 0; i < Planets.size(); i++){
			Planet planeti = Planets.get(i);
			Planets.remove(planeti); 		// Remove the planet object from the ArrayList
			planeti.updateAngle(delta);		// the ArrayList before adding the updated planet
			Planets.add(planeti);			// object back. 
			delta = delta+1;
			repaint();
		}
	}

	/** Start the animation */
	public void start() {	
		animationTimer.start();
	}

	/** Stop the animation */
	public void stop() {
		animationTimer.stop();
	}

}
