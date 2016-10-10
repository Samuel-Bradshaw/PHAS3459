package module2;

import java.lang.Math;


public class ThreeVector {
	
	double magnitude(double x, double y, double z){
		 return Math.sqrt((x*x)+(y*y)+(z*z));}
	
	ThreeVector unitVector(double x, double y, double z){ //do I define the method here 
		return (x, y, z)/Math.sqrt((x*x)+(y*y)+(z*z));    // or inside the main part? 
	} // how do I store a vector? 
 
	public static void main(String[] args) {
		
		ThreeVector tv = new ThreeVector();
		

	}

}
