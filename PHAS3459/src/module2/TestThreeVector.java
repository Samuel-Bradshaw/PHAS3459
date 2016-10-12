package module2;

public class TestThreeVector {

	public static void main(String[] args) {
		ThreeVector v1 = new ThreeVector(5,2,3); //creating a new "object", v1, in the ThreeVector "class"
		//double mag1 = v1.magnitude();
		ThreeVector unitv1 = v1.unitVector();  
		
		ThreeVector v2 = new ThreeVector(4,5,1);
		//double mag2 = v2.magnitude();
		ThreeVector unitv2 = v2.unitVector(); 
		
		ThreeVector v3 = new ThreeVector(0,0,0);
		//double mag3 = v3.magnitude();
		ThreeVector unitv3 = v3.unitVector(); 
		
		System.out.println("v1 = "+v1);
		//System.out.println("mag of v1 is: "+mag1);
		System.out.println("unit vector of v1 = "+unitv1);
		
		System.out.println("v2 = "+v2);
		//System.out.println("mag of v2 is: "+mag2);
		System.out.println("unit vector of v2 = "+unitv2);
		
		System.out.println("v3 = "+v3);
		//System.out.println("mag of v3 is: "+mag3);
		System.out.println("unit vector of v3 = "+unitv3);
		
		
		//STATIC METHODS
		
		//Scalar Products static
		double v1v2dot = ThreeVector.scalarProduct(v1, v2);
		double v1v3dot = ThreeVector.scalarProduct(v1, v3);
		System.out.println("v1.v2 = "+v1v2dot);
		System.out.println("v1.v3 = "+v1v3dot);

		
		//Vector Products static method
		ThreeVector v1v2vec = ThreeVector.vectorProduct(v1, v2); 
		ThreeVector v1v3vec = ThreeVector.vectorProduct(v1, v3);
		System.out.println("v1*v2 = "+v1v2vec);
		System.out.println("v1*v3 = "+v1v3vec);
		
		//angles static method
		double v1v2angle = ThreeVector.angle(v1, v2);
		System.out.println("Angle between v1 and v2: "+v1v2angle);
		double v1v3angle = ThreeVector.angle(v1, v3);
		System.out.println("Angle between v1 and v3: "+v1v3angle);

		//NON-STATIC METHODS
		
		//scalar Products
		double v1v2dotnonstatic = v1.scalarProduct(v2);
		double v1v3dotnonstatic = v1.scalarProduct(v3);
		System.out.println("v1.v2 (Non-static method) = "+v1v2dotnonstatic);
		System.out.println("v1.v3 (Non-static method) = "+v1v3dotnonstatic);
		
		//vector Products
		ThreeVector v1v2vecnonstatic = v1.vectorProduct(v2);
		ThreeVector v1v3vecnonstatic = v1.vectorProduct(v3);
		System.out.println("v1*v2 (Non-static method) = "+v1v2vecnonstatic);
		System.out.println("v1*v3 (Non-static method) = "+v1v3vecnonstatic);
		
		//angles
		double v1v2anglestatic = v1.angle(v2);
		double v1v3anglestatic = v1.angle(v3);
		System.out.println("Angle between v1 and v2 (Non-static method): "+v1v2anglestatic);
		System.out.println("Angle between v1 and v3 (Non-static method): "+v1v3anglestatic);
		
	}
}
