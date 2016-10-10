package module2;

public class TestThreeVector {

	public static void main(String[] args) {
		ThreeVector v1 = new ThreeVector(5,2,3);
		double mag1 = v1.magnitude();
		ThreeVector unitv1 =v1.unitVector();  
		
  
		System.out.println("mag of v1 is: "+mag1);
		System.out.println("unit vector of v1 is: "+unitv1);
		
		
		

	}
}
