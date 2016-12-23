package module9;

import java.awt.Color;

/**
 * Class defining Planet objects to be graphically displayed in a
 * simplified representation of the solar system. 
 * @author Samuel Bradshaw
 */

public class Planet {

	//Polar coords
	int OrbitalRadius; 
	double angle;
	
	int Period;
	Color colour;
	int PlanetRadius;
	double angularVelocity;

	//Constructor
	Planet(int orbitalRadius, int period, Color col, int planetRadius){
		OrbitalRadius = orbitalRadius;
		Period = period; 
		colour = col;
		PlanetRadius = planetRadius;
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

	int getPlanetSize(){
		return PlanetRadius;
	}
	
	void updateAngle(int timestep){
		angle =  angularVelocity*timestep; 
	}
}
