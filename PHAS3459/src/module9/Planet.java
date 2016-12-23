package module9;

import java.awt.Color;

public class Planet {
	
	int OrbitalRadius;
	int Period;
	Color colour;
	double angularVelocity;
	double angle;
	int PlanetSize;
	
	Planet(int orbitalRadius, int period, Color col, int planetSize){
		OrbitalRadius = orbitalRadius;
		Period = period; 
		colour = col;
		PlanetSize = planetSize;
		angularVelocity = 2*Math.PI/Period;
	}

	int getOrbitalRadius(){
		return OrbitalRadius;
	}
	Color getColor(){
		return colour;
	}
	int getPeriod(){
		return Period;
	}
	
	double getAngle(){
		return angle;
	}
	
	void updateAngle(int timestep){
		angle =  angularVelocity*timestep; 
	}
	
	int getPlanetSize(){
		return PlanetSize;
	}
}
