package module9;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Class extending the JPanel class for a simplified graphical representation of the solar system
 * where the planets are depicted as having circular orbits. 
 * The method AnimationGuiPanel() creates a PlanetsAnimationPanel JPanel.
 * The GUI Panel adds start, stop and exit buttons to the JPanel
 * @author Samuel Bradshaw
 */

public class AnimationGuiPanel extends JPanel implements ActionListener {

	private PlanetsAnimationPanel animPanel; // panel containing animation
	private JButton startButton;
	private JButton stopButton;
	private JButton exitButton;

	/** Create JPanel containing animation panel and buttons. */
	public AnimationGuiPanel() {
		super();
		setPreferredSize(new Dimension(600,600));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

		// Add Graphics to GUI
		
		//Create an ArrayList of Planets (including the sun as a planet) to display graphically:
		ArrayList<Planet> planets = new ArrayList<Planet>();
		//Add the planets to the ArrayList:
		// - The relative data taken for each planet are approximations taken from google. 
		Planet Mercury = new Planet(60, 1752, Color.GRAY, 8);
		Planet Venus = new Planet(142, 4454, Color.WHITE, 19);
		Planet Earth = new Planet(200, 7300, Color.GREEN, 20);
		Planet Mars = new Planet(276, 13724, Color.RED, 11);
		Planet Sun = new Planet(0, 1, Color.YELLOW, 30);
		planets.add(Mars);
		planets.add(Earth);
		planets.add(Mercury);
		planets.add(Venus);
		planets.add(Sun);

		animPanel = new PlanetsAnimationPanel(planets, 600, 600);
		add(animPanel);

		// Add buttons to GUI
		
		startButton = new JButton("Start");
		stopButton  = new JButton("Stop");
		exitButton = new JButton("Exit");

		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		exitButton.addActionListener(this);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(
				buttonPanel,BoxLayout.X_AXIS));
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(exitButton);

		add(buttonPanel);
	}

	/** Respond to button clicks */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==startButton) start();
		else if (e.getSource()==stopButton) stop();
		else if (e.getSource()==exitButton) System.exit(0);
	}

	/** Start animation when applet is started */
	public void start() {
		animPanel.start();
	}

	/** Stop animation when applet is stopped */
	public void stop() {
		animPanel.stop();
	}
}
