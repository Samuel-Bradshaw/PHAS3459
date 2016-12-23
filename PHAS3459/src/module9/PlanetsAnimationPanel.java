package module9;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PlanetsAnimationPanel extends JPanel implements ActionListener {

	ArrayList<Planet> Planets = new ArrayList< Planet>();
	private int delay = 10;
	private int delta = 10; // delay in ms between steps    
	private Timer animationTimer; // timer controlling frame rate 


	PlanetsAnimationPanel(ArrayList<Planet> planets, int width, int height) {   
		//Set background colour to black
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(width,height));
		
		Planets = planets;
		animationTimer = new Timer(delay, this); 
	}

	protected void paintComponent(Graphics g){
		super.paintComponent(g);

		//origin coords
		int x0 = getWidth()/2;
		int y0 = getHeight()/2;
		
		for(Planet planeti : Planets){
		int r = planeti.getOrbitalRadius();
		double angle = planeti.getAngle();
		int x = (int) Math.round(x0 + r*Math.cos(angle));
		int y = (int) Math.round(y0 + r*Math.sin(angle));
		g.setColor(planeti.getColor());
		g.fillOval(x, y, planeti.getPlanetSize(), planeti.getPlanetSize());
		}
	}

	public void actionPerformed(ActionEvent e){
		for(int i = 0; i < Planets.size(); i++){
		Planet planeti = Planets.get(i);
		Planets.remove(planeti);
		planeti.updateAngle(delta);
		Planets.add(planeti);
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
