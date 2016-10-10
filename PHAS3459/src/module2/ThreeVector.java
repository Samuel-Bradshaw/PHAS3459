package module2;

import java.lang.Math;


public class ThreeVector {
	
	// member variables
	double x; double y; double z; 	
	
	//method returning magnitude of vector
	double magnitude(){
		 return Math.sqrt((x*x)+(y*y)+(z*z));}
	
	//constructor
	public ThreeVector(double x1, double y1, double z1) {
		x = x1;
		y = y1;
		z = z1;}
		
	ThreeVector unitVector(){
		x = x1/magnitude
	}
	
	
	


		ThreeVector unitVector(double x, double y, double z){ 
			return (x, y, z)/magnitude(x, y, z); 
	}
	
	
  
 
	 

	}

