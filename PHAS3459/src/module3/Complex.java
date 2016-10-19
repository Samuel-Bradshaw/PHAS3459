package module3;

//This class represents complex numbers as two components (one for real, one for imaginary component)
//and contains some methods for complex number manipulations. 

public class Complex {

	//Member variables: 
	//x corresponds to the real component, 
	//y corresponds to the imaginary component:

	double x; double y;

	//Constructor
	public Complex(double real, double imaginary){
		x = real;
		y = imaginary;
	}

	//Re-styling the toString function used in ThreeVector class to represent complex numbers.
	public String toString() {
		return x+" + "+y+"i";
	} 

	double real(){
		return x;
	}

	double imag(){
		return y;
	}	

	double modulus(){
		// r^2 = x^2 + y^2
		return Math.sqrt((this.y*this.y) + (this.x*this.x));

	}

	double angle(){
		//We want the angle to be defined as anti-clockwise from the x-axis, ranging from 0 to 2*Pi. 

		double theta = 0; // - initialising angle.  

		// between 0 and pi/2, tan(theta) = y/x
		if((this.x > 0) && (this.y >= 0)){
			theta = Math.atan(this.y/this.x);}
		//between pi/2 and pi, theta = pi/2 + arctan(|x|/y)
		else if((this.x <= 0) && (this.y > 0)){
			theta = (Math.PI)/2 + Math.atan(Math.abs(this.x)/this.y);}
		//between pi and 3pi/2, theta = pi + arctan(y/x)
		else if((this.x < 0) && (this.y <= 0)){
			theta = Math.PI + Math.atan(this.y/this.x);}
		//between 3pi/2 and 2pi, theta = 3pi/2 + arctan(x/|y|)
		else if((this.x >= 0) && (this.y < 0)){
			theta = 3*(Math.PI)/2 + Math.atan(this.x/Math.abs(this.y));}

		return theta;
	}

	Complex conjugate(){
		return new Complex(x, -y);
	}

	Complex normalised() throws Exception{
		if((this.x == 0) && (this.y == 0)){
			throw new Exception("Complex number normalisation failure: cannot normalise zero.");
		}
		return new Complex(x/modulus(), y/modulus());
	}

	boolean equals(Complex c){
		if((this.x == c.x) && (this.y == c.y)){
			return true;} 
		else{
			return false;}
	}

	//Initialising variables x and y of a complex number given the modulus and argument. 
	Complex setFromModulusAngle(double mag, double ang){
		return new Complex( mag*Math.cos(ang), mag*Math.sin(ang));
	}

	static Complex add(Complex c1, Complex c2){
		return new Complex(c1.x + c2.x, c1.y + c2.y);
	}
	//subtracting c2 from c1. 
	static Complex subtract(Complex c1, Complex c2){
		return new Complex(c1.x - c2.x, c1.y - c2.y);
	}

	// c1*c2
	static Complex multiply(Complex c1, Complex c2){
		return new Complex( c1.x*c2.x - c1.y*c2.y,  // - real part of c1*c2.
				c1.x*c2.y + c2.x*c1.y); // - imaginary part of c1*c2.
	}
	// c1/c2
	static Complex divide(Complex c1, Complex c2) throws Exception{
		if ((c2.x == 0) && (c2.y == 0)) {
			throw new Exception("Denominator equal to 0 - cannot compute fraction.");
		}
		return new Complex( (c1.x*c2.x + c1.y*c2.y)/(c2.modulus()*c2.modulus()),   // - the real component of c1/c2.
				(c1.y*c2.x - c1.x*c2.y)/(c2.modulus()*c2.modulus()) ); // - the imaginary component of c1/c2.
	}

	//Defining static variables
	public static Complex ONE = new Complex(1, 0);
	public static Complex ZER0 = new Complex(0,0);
	public static Complex I = new Complex(0, 1);


}