package module3;

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
		 return Math.sqrt((x*x) + (y*y) + (z*z));
		 }

	//unit vector calculator method
	public ThreeVector unitVector() throws Exception{
		if((this.x == 0) && (this.y == 0) && (this.z == 0)){
			throw new Exception("Normalisation of vector failed: cannot normalise a zero vector.");
		}
		
		//double a = x/Math.sqrt((x*x) + (y*y) + (z*z));
		double a = x/this.magnitude();
		double b = y/this.magnitude();
		double c = z/this.magnitude(); 
		return new ThreeVector(a, b, c);
	}

	 public String toString() {
		  return "("+x+", "+y+", "+z+")";
		  } 

	 static double scalarProduct(ThreeVector a, ThreeVector b){
		  return (a.x)*(b.x)+(a.y)*(b.y)+(a.z)*(b.z);
		  }

	 static ThreeVector vectorProduct(ThreeVector a, ThreeVector b){
		  return new ThreeVector(((a.y)*(b.z)-(a.z)*(b.y)), ((a.z)*(b.x)-(a.x)*(b.z)),((a.x)*(b.y)-(a.y)*(b.x)));
		  } 

	 static ThreeVector add(ThreeVector a, ThreeVector b){
		 return new ThreeVector(a.x + b.x, a.y + b.y, a.z + b.z);
	 }

	 static double angle(ThreeVector a, ThreeVector b) throws Exception{
		 if (a.magnitude() == 0 || b.magnitude()== 0) {
			 throw new Exception("Angle calculation failure: cannot compute angle with zero vector"); 
		 }
		 
		 return Math.acos( 											//Using the formula for the dot or scalar product 
				 scalarProduct(a, b)/ (a.magnitude()*b.magnitude()) //between two vectors to find the angle between them.
				 );}

	 //Non-static methods

	 double scalarProduct(ThreeVector b){
		 // recalling the static method defined above 
		 return scalarProduct(this, b);}

	ThreeVector vectorProduct(ThreeVector b){
		// recalling the static method of vectorProduct
			 return vectorProduct(this, b);
			 } 

	// double angle(ThreeVector b){
	// return angle(this, b);
	// }

}
		

