package module9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AnimationGuiPanel extends JPanel implements ActionListener {
	private AnimationPanel animPanel; // panel containing animation
	private JButton startButton;
	private JButton stopButton;
	private JButton exitButton;

	/** Create JPanel containing animation panel and buttons. */
	public AnimationGuiPanel() {
		super();
		setPreferredSize(new Dimension(600,600));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

		animPanel = new AnimationPanel(400,400);
		
		PlanetsAnimationPanel Mars = new PlanetsAnimationPanel(50,2000, Color.RED);
		PlanetsAnimationPanel Earth = new PlanetsAnimationPanel(100,4000, Color.GREEN);
		
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

		add(animPanel);
		add(buttonPanel);
	}

	/** Respond to button clicks */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==startButton) start();
		else if (e.getSource()==stopButton) stop();
		else if (e.getSource()==exitButton) System.exit(0);
	}

	/** Start animation when applet is started */
	public void start() {animPanel.start();}

	/** Stop animation when applet is stopped */
	public void stop() {animPanel.stop();}
}
