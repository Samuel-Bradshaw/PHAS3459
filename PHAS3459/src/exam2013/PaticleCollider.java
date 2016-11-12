package exam2013;

import java.io.*;
import java.net.URL;
import java.util.*;

public class PaticleCollider {

	static String particleDataURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/particles.txt";

	//Returns a HashMap of separate events in the form HashMap<Identification label of trigger, ArrayList<Particles in event>>
	static HashMap<String, ArrayList<Particle>> Events(String url) throws IOException {
		//Reading the data
		URL url1 = new URL(url); 
		InputStream istream = url1.openStream(); 
		InputStreamReader isr = new InputStreamReader(istream); 
		BufferedReader buffr = new BufferedReader(isr); 

		//Initialise the HashMap
		HashMap<String, ArrayList<Particle>> events = new HashMap<String, ArrayList<Particle>>();

		try(Scanner scanner1 = new Scanner(buffr);
				){ 
			while(scanner1.hasNext()){

				String token1 = scanner1.next();

				if(Character.isLetter(token1.charAt(0))){ //If first letter of line is a character,
					int ntracks = scanner1.nextInt();		// this indicates a new event
					String eventcode = scanner1.next();
					//Initialise the ArrayList of particles for each new event:
					ArrayList<Particle> eventParticlei = new ArrayList<Particle>();

					for(int i = 0; i < ntracks ; i++){
						//Create new particle objects and add them to the ArrayList of Particles in each event 
						int charge = scanner1.nextInt(); 
						double momentum = scanner1.nextDouble();
						double theta = scanner1.nextDouble();
						double phi = scanner1.nextDouble();
						Particle par1 = new Particle(charge, momentum, theta, phi);
						eventParticlei.add(par1);
						//Add event to HashMap of separate events. 
						events.put(eventcode, eventParticlei);
					}
				}
			}
		}
		return events;

	}

	//ArrayList<Double> InvariantMass(ArrayList<Particle> eventParticles){
		//for(int i = 0; i < eventParticles.size(); i++){
			//Particle particlei = eventParticles.get(i);
			//int chargei = particlei.getCharge();
			//compare charges that are opposite
			//for(int j = i + 1; j < eventParticles.size() - 1; j++){ 
				//if(eventParticles.get(j).getCharge()!= chargei){
					//here calculate the invariant mass
				//}
			//}
			
		//}
		
		
		
	}
	
	public static void main(String[] args) {

		try {
			HashMap<String, ArrayList<Particle>> particleData = Events(particleDataURL);
			System.out.println(particleData.entrySet());
			
			

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
