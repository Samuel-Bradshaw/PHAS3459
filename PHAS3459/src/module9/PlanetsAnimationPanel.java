package module9;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PlanetsAnimationPanel extends JPanel implements ActionListener {

	int OrbitalRadius;
	int Period;
	Color colour;
	double angularVelocity;
	double angle = 0.0;
	
	private static int delta = 1; // delay in ms between steps    
	private static Timer animationTimer; // timer controlling frame rate 


	PlanetsAnimationPanel(int orbitalRadius, int period, Color col) {   
		OrbitalRadius = orbitalRadius;
		Period = period; 
		colour = col;
		angularVelocity = 2*Math.PI/Period;
		
		animationTimer = new Timer(delta, this); 
	     
	}

	protected void paintComponent(Graphics g){
		super.paintComponent(g);

		//origin coords
		int x0 = getWidth()/2;
		int y0 = getHeight()/2;

		int r = OrbitalRadius;

		int x = (int) Math.round(x0 + r*Math.cos(angle));
		int y = (int) Math.round(y0 + r*Math.sin(angle));

		
		g.setColor(colour);
		g.fillOval(x, y, 10, 10);

	}

	public void actionPerformed(ActionEvent e) {

	//	double angularVelocity = 2*Math.PI/Period;
		angle = angularVelocity*delta; 
		delta = delta+1;

		repaint();

	}

	/** Start the animation */
	public static void start() {
		
		animationTimer.start();
	}

	/** Stop the animation */
	public static void stop() {
		animationTimer.stop();
	}

}
