package module2;

//Class which simulates a falling particle of a chosen mass and drag coefficient
//falling under the effects of gravity. 

public class FallingParticle {
	
	//Member variables:
	double m; // mass of particle
	double d; // drag coefficient
	double t = 0; // time elapsed
	double z; // vertical position of particle, measured upwards
	double v = 0; // the velocity of the particle measured upwards
	static double g = 9.8; //acceleration due to gravity in m/s^2

	public FallingParticle(double mass, double dragcoefficient){
		m = mass;
		d = dragcoefficient;
	}
	
	void setZ(double initialheight){
		z = initialheight;}
	
	double getZ(){
		return z;}
	
	void setV(double initialvelocity){
		v = initialvelocity;}
	
	double getV(){
		return v;}
	
	double getT(){
		return t;}
	
	//Updating the velocity and position after each time step
	void doTimeStep(double deltaT){
		double a = (d*(v*v)/m) - g;
		v = v + (a*deltaT);
		z = z + (v*deltaT);}
	
	double drop(double deltaT){
		t = 0; //resetting the time to t=0 for each drop simulated
		while(z > 0){
			doTimeStep(deltaT);
			t = t + deltaT;}
		return t; 
	}
}
