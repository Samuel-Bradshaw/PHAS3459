package module1;

import java.lang.Math;

public class VectorMethods {
	
	//defining dot product function 
	 double dotProduct (double x1, double y1, double z1,
	 			double x2, double y2, double z2) {

		 double x = x1*x2;
		 double y = y1*y2;
		 double z = z1*z2;

		 return x + y + z; 
	 	}

	 
	//magnitude function
	 double magnitude (double x, double y, double z){
		 return Math.sqrt((x*x)+(y*y)+(z*z));
				 }
	 
	//angle function 
	 //cos(angle)= (dot product of vector1 & vector2)/(mag1*mag2) 
	 //recall arccos function from Math 
	 double angle (double x1, double y1, double z1,
	 			double x2, double y2, double z2) {
		 
		 double ang = Math.acos(
			dotProduct(x1, y1, z1, x2, y2, z2)/(magnitude(x1, y1, z1)*magnitude(x2,y2,z2))
				 				);
		 return ang;
	 }
	 
	public static void main(String[] args) {
		
		VectorMethods vm = new VectorMethods();
		
		//testing the dot product function
		double dp1 = vm.dotProduct(1 ,2, 3, 4, 5, 6);
		System.out.println("(1, 2, 3).(4, 5, 6) = "+dp1);
		
		//testing the magnitude function 
		double mag1 = vm.magnitude(1,2,2);
		System.out.println("Magnitude of vector (1, 2, 2) = "+mag1);
		
		//testing angle function
		double ang1 = vm.angle(6, 3, 1, 2, 4, 2);
		System.out.println("Angle between (6,3,1) and (2,4,2) = "+ang1+" radians");
		
		double ang2 = vm.angle(6, 3, 1, 0, 0, 0);
		System.out.println("Angle between (6,3,1) and (0,0,0) = "+ang2+" radians");
		System.out.println("-as one of the vectors is (0,0,0) there is no angle between them.");
		
		
		
	
		

	}

}
 

 