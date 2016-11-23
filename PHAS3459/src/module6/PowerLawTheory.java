package module6;

/**Implements the function y = x^n **/

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
	
	public String toString(){
		return "y = x^"+n;
	}

}
