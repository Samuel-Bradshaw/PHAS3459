package module5;

public class TestSquareMatrix {

	static double[][] sq1 = {{1,2,3},{3,4,5},{7,8,9}}; 
	
	public static void main(String[] args) {
		try{SquareMatrix sm1 = new SquareMatrix(sq1);
		System.out.println(sm1);
		System.out.println(sq1.length);
		}
		catch(Exception e){
			System.out.println(e);
		}
 
	}

}
