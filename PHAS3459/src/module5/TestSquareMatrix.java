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
		
		SquareMatrix a1b1 = SquareMatrix.add(a,b);
		System.out.println("a = \n"+a);
		System.out.println("b = \n"+b);
		System.out.println("a + b = \n"+a1b1);
		
		
		}

		catch(Exception e){
			System.out.println(e);
		}

		
		try{
			}
		catch(Exception e){
			System.out.println(e);
		}
		
		
	}

}
