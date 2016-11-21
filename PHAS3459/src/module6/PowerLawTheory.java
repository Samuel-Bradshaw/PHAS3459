package module6;

public class PowerLawTheory implements Theory{

	//Member variables
	double n;
	
	//Constructor
	PowerLawTheory(double n1){
		n = n1;
	}
	
	public double y(double x) {
		return Math.pow(x, n);
	}
	

}
