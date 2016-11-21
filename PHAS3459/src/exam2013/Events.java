package exam2013;

import java.util.*;

public class Events {

	ArrayList<Particle> particleData = new ArrayList<Particle>();
	public String triggerCode;
	
	Events(String code, ArrayList<Particle> particles){
		triggerCode = code;
		particleData = particles;
	}
	
}
