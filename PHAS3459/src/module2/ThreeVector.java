package module2;

import java.lang.Math;


public class ThreeVector {
	
	// member variables
	double x; double y; double z; 	
	
	//constructor
	public ThreeVector(double x1, double y1, double z1) {
		x = x1;
		y = y1;
		z = z1;
		}
	
	//returning the vector x component
	//	public double getx(){
		//return x;	
		//}
	//returning the vector y component
		//public double gety(){
		//return y;	
		//}	
	//returning the vector z component
		//	public double getz(){
			//return z;	
			//}
		
	
	//method returning magnitude of vector
	double magnitude(){
		 return Math.sqrt( (x*x) + (y*y) + (z*z) );
		 }
	
	public ThreeVector unitVector(){
		double a = x/Math.sqrt((x*x) + (y*y) + (z*z));
		double b = y/Math.sqrt((x*x) + (y*y) + (z*z));
		double c = z/Math.sqrt((x*x) + (y*y) + (z*z)); 
		return new ThreeVector(a, b, c);
	}
	
	 public String toString() {
		  return "x = "+x+", y = "+y+", z = "+z;}
		 
	 static double scalarProduct(ThreeVector a, ThreeVector b){
		  return (a.x)*(b.x)+(a.y)*(b.y)+(a.z)*(b.z);}
		 
	 static ThreeVector vectorProduct(ThreeVector a, ThreeVector b){
		  return new ThreeVector(((a.y)*(b.z)-(a.z)*(b.y)), ((a.z)*(b.x)-(a.x)*(b.z)),((a.x)*(b.y)-(a.y)*(b.x)));} 
		 }

