package module2;

/**
 * Represents 3-Dimensional vectors and some 3D vector manipulations. 
*/

import java.lang.Math;

public class ThreeVector {
	
	// member variables
	double x; double y; double z; 	
	
	//constructor
	public ThreeVector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		}
	
	//method returning magnitude of vector
	double magnitude(){
		 return Math.sqrt((x*x) + (y*y) + (z*z)); }
	
	//unit vector calculator method
	public ThreeVector unitVector(){
		double a = x/Math.sqrt((x*x) + (y*y) + (z*z));
		double b = y/Math.sqrt((x*x) + (y*y) + (z*z));
		double c = z/Math.sqrt((x*x) + (y*y) + (z*z)); 
		return new ThreeVector(a, b, c);
	}
	
	 public String toString() {
		  return "("+x+", "+y+", "+z+")";}
		 
	 static double scalarProduct(ThreeVector a, ThreeVector b){
		  return (a.x)*(b.x)+(a.y)*(b.y)+(a.z)*(b.z);}
		 
	 static ThreeVector vectorProduct(ThreeVector a, ThreeVector b){
		  return new ThreeVector(((a.y)*(b.z)-(a.z)*(b.y)), ((a.z)*(b.x)-(a.x)*(b.z)),((a.x)*(b.y)-(a.y)*(b.x)));} 
		 
	 static ThreeVector add(ThreeVector a, ThreeVector b){
		 return new ThreeVector(a.x + b.x, a.y + b.y, a.z + b.z);
	 }
	 
	 static double angle(ThreeVector a, ThreeVector b){
		 return Math.acos( //Using the formula for the dot or scalar product between two vectors to find the angle between them.
				 scalarProduct(a, b)/ (a.magnitude()*b.magnitude())
				 			);}
	 
	 //Non-static
	 double scalarProduct(ThreeVector b){
		  return (this.x)*(b.x)+(this.y)*(b.y)+(this.z)*(b.z);}
}


