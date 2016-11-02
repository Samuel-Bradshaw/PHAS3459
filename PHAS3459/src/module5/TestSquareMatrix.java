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
			SquareMatrix u5 = SquareMatrix.unitMatrix(2);
			System.out.println(u5);
			}
		catch(Exception e){
			System.out.println(e);
		}
		
		
	}

}
