package module2;


public class TestComplex {

	public static void main(String[] args) {

		Complex c1 = new Complex(2,-1); 
		Complex c2 = new Complex(-1, 2);
		System.out.println("c1 = "+c1);
		System.out.println("c2 = "+c2);
		
		Complex c1c2 = Complex.multiply(c1, c2); 
		System.out.println("c1c2 = "+c1c2);
		
		Complex c1dividec2 = Complex.divide(c1, c2);
		System.out.println("c1/c2 = "+c1dividec2);
		
		Complex c1I = Complex.multiply(c1, Complex.I); 
		System.out.println("c1I = "+c1I);
		
		Complex c1divide0 = Complex.divide(c1, Complex.ZER0);
		System.out.println("c1/ZER0 = "+c1divide0);
		
		Complex c1squared = Complex.multiply(c1, c1.conjugate()); 
		System.out.println("c1*c1 = "+c1squared);
		
		Complex c2squared = Complex.multiply(c2, c2.conjugate()); 
		System.out.println("c2*c2 = "+c2squared);

		
	}



}