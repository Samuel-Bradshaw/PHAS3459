package module9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationPanel extends JPanel implements ActionListener {
	
	private final int delay = 50; // delay in ms between steps    
	private Timer animationTimer; // timer controlling frame rate 

	/**  Create panel   
	 * * @param width width of panel   
	 * * @param height height of panel     
	 * */ 
	AnimationPanel(int width, int height) {   
		//Set background colour to black
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(width,height));
		int size = Math.min(width, height) / 4;  
		animationTimer = new Timer(delay, this); 
		animationTimer.start(); 
	}

	//Pain Sun at centre of window
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
	    int width = getWidth();
	    int height = getHeight();
	    g.setColor(Color.YELLOW);
		g.fillOval(width/2,height/2,15,15);
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	  /** Start the animation */
	  public void start() {animationTimer.start();}

	  /** Stop the animation */
	  public void stop() {animationTimer.stop();}

}





