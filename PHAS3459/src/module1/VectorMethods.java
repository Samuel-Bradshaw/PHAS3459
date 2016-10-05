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
	 double magnitude (double x, double y, double z) {
		  
		 
		 return Math.sqrt((x*x)+(y*y)+(z*z));
				 
		 
	 }
	 
	public static void main(String[] args) {
		
		VectorMethods vm = new VectorMethods();
		
		double dp1 = vm.dotProduct(1 ,2, 3, 4, 5, 6);
		System.out.println(dp1);
		
		
		double mag1 = vm.magnitude(1,2,2);
		System.out.println(mag1);
		
		
	
		

	}

}
 

 