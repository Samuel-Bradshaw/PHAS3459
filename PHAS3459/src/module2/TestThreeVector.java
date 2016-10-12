package module2;

public class TestThreeVector {

	public static void main(String[] args) {
		ThreeVector v1 = new ThreeVector(5,2,3);
		double mag1 = v1.magnitude();
		ThreeVector unitv1 =v1.unitVector();  
		
		ThreeVector v2 = new ThreeVector(4,5,1);
		double mag2 = v2.magnitude();
		ThreeVector unitv2 = v2.unitVector(); 
		
		ThreeVector v3 = new ThreeVector(0,0,0);
		double mag3 = v3.magnitude();
		ThreeVector unitv3 = v3.unitVector(); 
		
		System.out.println("v1: "+v1);
		System.out.println("mag of v1 is: "+mag1);
		System.out.println("unit vector of v1 is: "+unitv1);
		
		System.out.println("v2: "+v2);
		System.out.println("mag of v2 is: "+mag2);
		System.out.println("unit vector of v2 is: "+unitv2);
		
		System.out.println("v3: "+v3);
		System.out.println("mag of v3 is: "+mag3);
		System.out.println("unit vector of v3 is: "+unitv3);
		
		double v1v2dot = ThreeVector.scalarProduct(v1, v2); // why is there an error?
		double v1v3dot = ThreeVector.scalarProduct(v1, v3);
		double v2v3dot = ThreeVector.scalarProduct(v2, v3);
		
		System.out.println("v1.v2 = "+v1v2dot);
		System.out.println("v1.v3 = "+v1v3dot);
		System.out.println("v2.v3 = "+v2v3dot);
		
		ThreeVector v1v2vec = ThreeVector.vectorProduct(v1, v2); // why is there an error?
		ThreeVector v1v3vec = ThreeVector.vectorProduct(v1, v3);
		ThreeVector v2v3vec = ThreeVector.vectorProduct(v2, v3);
		
		System.out.println("v1.v2 = "+v1v2vec);
		System.out.println("v1.v3 = "+v1v3vec);
		System.out.println("v2.v3 = "+v2v3vec);
		

	}
}
