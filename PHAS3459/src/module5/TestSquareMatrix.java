package module5;

public class TestSquareMatrix {

	static double[][] sq1 = {{1,2},{3,4}}; 
	
	public static void main(String[] args) {
		try{SquareMatrix sm1 = new SquareMatrix(sq1);
		System.out.println(sm1);}
		catch(Exception e){
			System.out.println(e);
		}
 
	}

}
