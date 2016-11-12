package exam2013;

import java.util.*;

public class Events {

	ArrayList<Particle> particleData = new ArrayList<Particle>();
	public static String triggerCode;
	
	Events(String code, ArrayList<Particle> particles){
		triggerCode = code;
		particleData = particles;
	}
	
}
