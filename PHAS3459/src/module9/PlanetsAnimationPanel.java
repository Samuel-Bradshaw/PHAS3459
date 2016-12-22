package module9;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PlanetsAnimationPanel extends JPanel implements ActionListener {
	
	int orbitalRadius;
	int Period;
	Color colour;
	
	private final int delay = 50; // delay in ms between steps    
	private Timer animationTimer; // timer controlling frame rate 

	PlanetsAnimationPanel(int orbitalRadius, int Period) {   
		//setPreferredSize(new Dimension(width,height));
		//int size = Math.min(width, height) / 4;  
		animationTimer = new Timer(delay, this); 
		animationTimer.start(); 
	}

	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
	    int width = getWidth();
	    int height = getHeight();
	    g.setColor(colour);
		g.fillOval(width/2,orbitalRadius,10,10);
		
	}
		
	public void actionPerformed(ActionEvent e) {
		
		repaint();
		
	}
	
	

}
