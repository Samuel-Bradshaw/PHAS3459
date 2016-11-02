package module5;

public class TestSquareMatrix {

	static double[][] aArray = {{2,0,-1},{0,2,0},{3,0,1}};
	static double[][] bArray = {{-1,0,1},{0,1,0},{-3,0,1}};
	static double[][] cArray = {{2,3},{3,4}}; 
	static double[][] dArray = {{-4,3},{3,-2}}; 

	public static void main(String[] args) {

		try{
			SquareMatrix a = new SquareMatrix(aArray);
			SquareMatrix b = new SquareMatrix(bArray);
			SquareMatrix c = new SquareMatrix(cArray);
			SquareMatrix d = new SquareMatrix(dArray);

			System.out.println("A = \n"+a);
			System.out.println("B = \n"+b);
			System.out.println("C = \n"+c);
			System.out.println("D = \n"+d);
			
			SquareMatrix aAddb = SquareMatrix.add(a,b); //Testing add method
			System.out.println("A + B = \n"+aAddb);
			
			SquareMatrix aSubtractb = SquareMatrix.subtract(a,b); //Testing subtract method
			System.out.println("A - B = \n"+aSubtractb);
			
			SquareMatrix aMultiplyb = SquareMatrix.multiply(a,b); //Testing multiply method
			System.out.println("A B = \n"+aMultiplyb);
			
			SquareMatrix bMultiplya = SquareMatrix.multiply(b,a);
			System.out.println("B A = \n"+bMultiplya);	
			
			SquareMatrix aCommuteb = SquareMatrix.subtract(aMultiplyb, bMultiplya);
			System.out.println("[A,B] = A B - B A = \n"+aCommuteb);
			
			SquareMatrix cMultiplyd = SquareMatrix.multiply(c,d);
			System.out.println("C D = \n"+cMultiplyd);
			boolean test1 = cMultiplyd.equals(SquareMatrix.unitMatrix(2)); //Testing unitMatrix and equals method
			System.out.println("Is C D equal to the Identity Matrix?: "+test1);
			
		}

		catch(Exception e){
			System.out.println(e);
		}

	}

}
