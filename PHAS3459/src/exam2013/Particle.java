package exam2013;

public class Particle {

	public int charge;
	public double momentum;
	public double theta;
	public double phi;
	
	Particle(int q, double p, double th, double ph){
		charge = q;
		momentum = p;
		theta = th;
		phi = ph;
	}
	
	int getCharge(){
		return charge;
	}
	
	double getMomentum(){
		return momentum;
	}
	
	double getTheta(){
		return theta;
	}
	double getPhi(){
		return phi;
	}
	
	public String toString(){
		String particleString = "(Charge:"+ charge+"; Momentum: "+momentum+"; theta: "+theta+"; Phi: "+phi+ ")";
		return particleString;
	}
	
}
