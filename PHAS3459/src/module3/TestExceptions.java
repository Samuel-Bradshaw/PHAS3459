package module3;

public class TestExceptions {

	public static void main(String[] args) {
		
		//Testing Complex Exceptions
		Complex z1 = new Complex(1.0,1.0);
		Complex z2 = new Complex(0.0,0.0);
		
		try {Complex z3 = Complex.divide(z1, z2); //dividing by 0
		System.out.println(z3);
		}
		catch (Exception e){
			System.out.println(e);
		}
		
		try {Complex z2n = z2.normalised(); //normalising zero
		System.out.println("z2n="+z2n);
		}
		catch (Exception e){
			System.out.println(e);
		}
		
		//Testing ThreeVector Exceptions
		ThreeVector v1 = new ThreeVector(0,0,0); 
		ThreeVector v2 = new ThreeVector(1,0,0);
		
		try {ThreeVector v1n = v1.unitVector(); //finding unit vector of 0
		System.out.println("v1n = "+v1n);
		}
		catch (Exception e){
			System.out.println(e);
		}
		
		try {double v1v2ang = ThreeVector.angle(v1, v2); //finding angle between a vector and 0
		System.out.println("Angle between v1 and v2 ="+v1v2ang);
		}
		catch (Exception e){
			System.out.println(e);
		}
		
		//Testing FallingParticle Exceptions
		try {FallingParticle p1 = new FallingParticle(-1, 5);//assigning a negative mass
		System.out.println("Particle has mass,"+p1.m+", and drag coefficient, "+p1.d+".");
		}
		catch (Exception e){
			System.out.println(e);
		}
		
		try {FallingParticle p1 = new FallingParticle(2, -5); // assigning a negative drag coefficient
		System.out.println("Particle has mass,"+p1.m+", and drag coefficient, "+p1.d+".");
		}
		catch (Exception e){
			System.out.println(e);
		}
		
		try {FallingParticle p2 = new FallingParticle(1, 1);
			p2.setZ(-5); //assigning a negative starting height
			System.out.println("Starting height of p2 = "+p2.z+"m");}
		catch (Exception e){
		System.out.println(e);
		}
		
		
		
	}
}
