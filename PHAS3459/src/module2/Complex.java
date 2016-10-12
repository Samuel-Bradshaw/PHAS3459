package module2;

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

	double real(){
		return x;
	}
	
	double imag(){
		return y;
	}
	
	double modulus(){
		//tan(theta) = y/x
		return Math.atan(this.y/this.x);
	}
}
