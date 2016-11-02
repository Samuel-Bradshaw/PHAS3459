package module5;

public class TestSquareMatrix {

	static double[][] sq1 = {{1,2,3, 4},{3,4,4,5},{7,8,1,9},{1,1,1,1}}; 

	public static void main(String[] args) {

		try{SquareMatrix sm1 = new SquareMatrix(sq1);
		System.out.println(sm1);
		}

		catch(Exception e){
			System.out.println(e);
		}

		
		try{
			SquareMatrix u3 = SquareMatrix.unitMatrix(3);
			System.out.println(u3);
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		
	}

}
