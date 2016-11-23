package module6;

/**Implements the function y =  y = a x^2 + b x + c **/

public class QuadraticTheory implements Theory{

	//Member variables
	double a;
	double b;
	double c;
	
	//Constructor
	QuadraticTheory(double a1, double b1, double c1){
		a = a1;
		b = b1;
		c= c1;
	}
	
	//returns y for y = a x^2 + b x + c
	public double y(double x) {
		return a*Math.pow(x, 2) + b*x + c; 
	}

	public String toString(){
		return "y = "+a+"x^2 + "+b+"x + "+c;
		
	}
}
